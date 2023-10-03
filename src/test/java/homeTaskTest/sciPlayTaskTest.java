package homeTaskTest;

import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.http.ParseException;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class sciPlayTaskTest {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    @Test(groups = {})
    public void generateMockFileOfGamePlayData() throws Exception {
        String mockDataFile="gameplay.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mockDataFile))) {
            writer.write("Player ID,Game Session ID,Score,Items Collected,Enemies Defeated,Timestamp\n");

            for (int i = 0; i < 1000; i++) {
                String playerId = random.nextInt(10) == 0 ? "" : faker.idNumber().valid();  // 10% chance of missing Player ID
                String gameSessionId = faker.idNumber().valid();
                int score = random.nextInt(10) == 0 ? random.nextInt(100) * -1 : random.nextInt(100);  // 10% chance of negative score
                int itemsCollected = random.nextInt(50);  // Some random number, you can adjust
                if (random.nextInt(10) == 0)
                    itemsCollected += 50;  // 10% chance that itemsCollected exceeds actual limit
                int enemiesDefeated = random.nextInt(100);  // Random number of enemies defeated
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timestamp = dateFormat.format(faker.date().past(10, TimeUnit.DAYS));

                writer.write(String.join(",",
                        playerId, gameSessionId, String.valueOf(score), String.valueOf(itemsCollected),
                        String.valueOf(enemiesDefeated), timestamp));
                writer.newLine();
            }
        }
    }


    @Test(groups = {})
    public void validateGamePlayDataFromTheMockFile() throws Exception {
        final String mockDataFile = "gameplay.csv";
        final int MAX_ITEMS_COLLECTED = 100;  // Adjust this value according to game's specified maximum


        try (CSVReader reader = new CSVReader(new FileReader(mockDataFile))) {
            List<String[]> allRows = reader.readAll();

            // Skip the header row
            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);

                String playerId = row[0];
                String gameSessionId = row[1];
                String score = row[2];
                String itemsCollected = row[3];
                String timestamp = row[5];

                // Validate Player ID
                if (playerId == null || playerId.trim().isEmpty()) {
                    System.out.println("Row " + i + ": Missing Player ID.");
                }

                // Validate Score
                if (Integer.parseInt(score.trim()) < 0) {
                    System.out.println("Row " + i + ": Negative value in the Score column.");
                }

                // Validate Timestamp format
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                sdf.setLenient(false); // this will not allow dates like 2021-02-30
                try {
                    sdf.parse(timestamp.trim());
                } catch (ParseException e) {
                    System.out.println("Row " + i + ": Invalid timestamp format.");
                }

                // Validate Items Collected
                if (Integer.parseInt(itemsCollected) > MAX_ITEMS_COLLECTED) {
                    System.out.println("Row " + i + ": Exceeded maximum items collected.");
                }
            }

            // Validate duplicate Game Session ID
            Set<String> uniqueGameSessions = new HashSet<>();
            for (int i = 1; i < allRows.size(); i++) {
                String gameSessionId = allRows.get(i)[1];
                if (uniqueGameSessions.contains(gameSessionId)) {
                    System.out.println("Duplicate Game Session ID found: " + gameSessionId);
                }
            }
        }
    }

    @Test(groups = {})
    public void cleanAndValidateGamePlayDataFromTheMockFile() throws Exception {
        final String mockDataFile = "gameplay.csv";
        final String REPORT_FILE_PATH = "validation_report.csv";
        final int MAX_ITEMS_COLLECTED = 100;

        // ANSI escape code for red text.
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        List<String[]> reportData = new ArrayList<>();
        reportData.add(new String[]{"Row Number", "Discrepancy", "Resolution"});

        try (CSVReader reader = new CSVReader(new FileReader(mockDataFile))) {
            List<String[]> allRows = reader.readAll();

            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);

                String playerId = row[0];
                String score = row[2].trim();
                String itemsCollected = row[3].trim();

                // Check and rectify Player ID
                if (playerId == null || playerId.trim().isEmpty()) {
                    System.out.println(ANSI_RED + "Row " + i + ": Missing Player ID. Flagged for manual review." + ANSI_RESET);
                    reportData.add(new String[]{String.valueOf(i), "Missing Player ID      ", "Flagged for manual review"});
                }

                // Check and rectify Score
                int scoreValue = Integer.parseInt(score);
                if (scoreValue < 0) {
                    row[2] = "0";
                    System.out.println("Row " + i + ": Negative score has been fixed to zero.");
                    reportData.add(new String[]{String.valueOf(i), "Negative Score         ", "Fixed to zero              "});
                }

                // Check and rectify Items Collected
                int itemsValue = Integer.parseInt(itemsCollected);
                if (itemsValue > MAX_ITEMS_COLLECTED) {
                    row[3] = String.valueOf(MAX_ITEMS_COLLECTED);
                    System.out.println("Row " + i + ": Items Collected exceeded the limit and has been fixed to the maximum allowed value of " + MAX_ITEMS_COLLECTED + ".");
                    reportData.add(new String[]{String.valueOf(i), "Exceeded Items Collected", "Set to " + MAX_ITEMS_COLLECTED + "                  "});
                }
            }

            // Validate duplicate Game Session ID
            Set<String> uniqueGameSessions = new HashSet<>();
            for (int i = 1; i < allRows.size(); i++) {
                String gameSessionId = allRows.get(i)[1];
                if (uniqueGameSessions.contains(gameSessionId)) {
                    System.out.println("Duplicate Game Session ID found: " + gameSessionId);
                    reportData.add(new String[]{String.valueOf(i), "Duplicate Game Session ID", "No resolution              "});
                } else {
                    uniqueGameSessions.add(gameSessionId);
                }
            }

            // Save the cleaned data back to the CSV file
            try (CSVWriter writer = new CSVWriter(new FileWriter(mockDataFile))) {
                writer.writeAll(allRows);
            }

            // Save the report data to the report CSV file
            try (CSVWriter writer = new CSVWriter(new FileWriter(REPORT_FILE_PATH))) {
                writer.writeAll(reportData);
            }
        }
    }


}




