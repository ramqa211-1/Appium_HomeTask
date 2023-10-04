package homeTaskTest;

import com.bluenile.testkit.pages.desktop.Dashboard;
import org.jfree.chart.JFreeChart;

import java.util.List;

public class sciPlayTaskDasboardTest extends Dashboard {

    public static void main(String[] args)   {
        try {
            String filePath = "test-output/sciPlayDateFiles/gameplay.csv";

            Dashboard dashboard = new Dashboard(); // Assuming Dashboard is the name of the class that contains methods like parseCsv, etc.
            List<Dashboard> dataList = dashboard.parseCsv(filePath);
            JFreeChart chart = dashboard.createActivePlayersChart(dataList);
            Dashboard.displayChart(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
