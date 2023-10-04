package com.bluenile.testkit.pages.desktop;

import com.opencsv.CSVReader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class Dashboard {

    private String playerId;
    private String gameSessionId;
    private int score;
    private int itemsCollected;
    private int enemiesDefeated;
    private Date timestamp;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }


    public void setGameSessionId(String gameSessionId) {
        this.gameSessionId = gameSessionId;
    }


    public void setScore(int score) {
        this.score = score;
    }


    public void setItemsCollected(int itemsCollected) {
        this.itemsCollected = itemsCollected;
    }


    public void setEnemiesDefeated(int enemiesDefeated) {
        this.enemiesDefeated = enemiesDefeated;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public static List<Dashboard> parseCsv(String filePath) throws Exception {
        List<Dashboard> dataList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext(); // Skip header row
            while ((line = reader.readNext()) != null) {
                Dashboard data = new Dashboard();
                data.setPlayerId(line[0]);
                data.setGameSessionId(line[1]);
                data.setScore(Integer.parseInt(line[2]));
                data.setItemsCollected(Integer.parseInt(line[3]));
                data.setEnemiesDefeated(Integer.parseInt(line[4]));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                data.setTimestamp(sdf.parse(line[5]));
                dataList.add(data);
            }
        }
        return dataList;
    }

    private static Map<Date, Integer> groupDataByDate(List<Dashboard> dataList) {
        // Using a TreeMap to keep dates sorted
        Map<Date, Set<String>> groupedData = new TreeMap<>();

        // Group data by date and gather unique player IDs
        for (Dashboard data : dataList) {
            Date dateWithoutTime = removeTime(data.getTimestamp());
            groupedData.computeIfAbsent(dateWithoutTime, k -> new HashSet<>()).add(data.getPlayerId());
        }

        // Convert the grouped data to count unique player IDs for each date
        Map<Date, Integer> activePlayersMap = new TreeMap<>();
        for (Map.Entry<Date, Set<String>> entry : groupedData.entrySet()) {
            activePlayersMap.put(entry.getKey(), entry.getValue().size());
        }

        return activePlayersMap;
    }

    private static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }


    public static JFreeChart createActivePlayersChart(List<Dashboard> dataList) {
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries series = new TimeSeries("Active Players Over Time");

        // You'd want to process the data list, group by date and count unique player IDs.
        // For simplicity, let's assume you've grouped the data in a Map<Date, Integer> activePlayersMap
        Map<Date, Integer> activePlayersMap = groupDataByDate(dataList);
        for (Map.Entry<Date, Integer> entry : activePlayersMap.entrySet()) {
            series.add(new Day(entry.getKey()), entry.getValue());
        }

        dataset.addSeries(series);

        return ChartFactory.createTimeSeriesChart(
                "Active Players Over Time",
                "Date",
                "Number of Active Players",
                dataset,
                false,
                true,
                false
        );
    }

    public static void displayChart(JFreeChart chart) {
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
