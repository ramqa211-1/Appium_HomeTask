package homeTaskTest;//package homeTaskTest;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//public class UserRetriever {
//
//    private static final String USER_AGENT = "Mozilla/5.0";
//    private static final String GET_URL = "https://reqres.in/api/users?page=2";
//    private static final String CSV_PATH = "test-output/fakeUserList.csv";
//
//    public static void main(String[] args) throws Exception {
//        URL url = new URL(GET_URL);
//        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//
//        httpURLConnection.setRequestMethod("GET");
//        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
//
//        int responseCode = httpURLConnection.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) { // success
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    httpURLConnection.getInputStream()));
//
//            StringBuilder responseBuilder = new StringBuilder();
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                responseBuilder.append(inputLine);
//            }
//            in.close();
//
//            JSONObject jsonResponse = new JSONObject(responseBuilder.toString());
//            JSONArray dataArray = jsonResponse.getJSONArray("data");
//
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_PATH))) {
//                for (int i = 0; i < dataArray.length(); i++) {
//                    JSONObject user = dataArray.getJSONObject(i);
//                    writer.write("id: " + user.getInt("id"));
//                    writer.newLine();
//                    writer.write("email: \"" + user.getString("email") + "\"");
//                    writer.newLine();
//                    writer.write("first_name: \"" + user.getString("first_name") + "\"");
//                    writer.newLine();
//                    writer.write("last_name: \"" + user.getString("last_name") + "\"");
//                    writer.newLine();
//                    writer.write("avatar: \"" + user.getString("avatar") + "\"");
//                    writer.newLine();
//                    writer.newLine(); // Extra line to separate users
//                }
//            }
//
//            System.out.println("Response saved to " + CSV_PATH);
//        } else {
//            System.out.println("GET request failed. Response code: " + responseCode);
//        }
//    }
//}
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//public class DataChecker {

//    private static final String USER_AGENT = "Mozilla/5.0";
//    private static final String GET_URL = "https://reqres.in/api/users?page=2";
//    private static final String NEW_DATA_CSV = "test-output/newUserData.csv";
//
//    private Set<Integer> userIdsCache = new HashSet<>();
//
//    public void startCheckingForNewData() {
//        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//        executor.scheduleAtFixedRate(() -> {
//            try {
//                JSONArray currentData = fetchData();
//                for (int i = 0; i < currentData.length(); i++) {
//                    JSONObject user = currentData.getJSONObject(i);
//                    int id = user.getInt("id");
//                    if (!userIdsCache.contains(id)) {
//                        userIdsCache.add(id);
//                        handleNewData(user);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }, 0, 1, TimeUnit.MINUTES);
//    }
//
//    private JSONArray fetchData() throws Exception {
//        URL url = new URL(GET_URL);
//        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//
//        httpURLConnection.setRequestMethod("GET");
//        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
//
//        int responseCode = httpURLConnection.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    httpURLConnection.getInputStream()));
//
//            StringBuilder responseBuilder = new StringBuilder();
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                responseBuilder.append(inputLine);
//            }
//            in.close();
//
//            JSONObject jsonResponse = new JSONObject(responseBuilder.toString());
//            return jsonResponse.getJSONArray("data");
//        } else {
//            throw new RuntimeException("Failed to fetch data. HTTP Code: " + responseCode);
//        }
//    }
//
//    private void handleNewData(JSONObject newUser) {
//        System.out.println("New User Detected: " + newUser);
//
//        // Write to CSV file
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NEW_DATA_CSV, true))) {
//            writer.write(newUser.getInt("id") + ",");
//            writer.write(newUser.getString("email") + ",");
//            writer.write(newUser.getString("first_name") + ",");
//            writer.write(newUser.getString("last_name") + ",");
//            writer.write(newUser.getString("avatar"));
//            writer.newLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Additional Logging if required
//        // This is just a simple log to console. In real-world applications, you'd use a logger like Log4j.
//        System.out.println("Logged new user to CSV: " + newUser.getString("first_name") + " " + newUser.getString("last_name"));
//    }
//
//    public static void main(String[] args) {
//        new DataChecker().startCheckingForNewData();
//    }

    // ... Other imports ...

    public class DataChecker {
        private static final String USER_AGENT = "Mozilla/5.0";
        // ... Other class members ...

        private static final String POST_URL = "https://reqres.in/api/users";
        private static final String NEW_USER_CSV = "test-output/newlyAddedUsers.csv";

        // ... Other methods ...

        public void addUserAndSaveToCSV(String name, String job) throws Exception {
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", name);
            requestBody.put("job", job);

            URL url = new URL(POST_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setDoOutput(true);

            try (OutputStream os = httpURLConnection.getOutputStream()) {
                byte[] input = requestBody.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        httpURLConnection.getInputStream()));

                StringBuilder responseBuilder = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    responseBuilder.append(inputLine);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(responseBuilder.toString());

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(NEW_USER_CSV, true))) {
                    writer.write(jsonResponse.getInt("id") + ",");
                    writer.write(name + ",");
                    writer.write(job + ",");
                    writer.write(jsonResponse.getString("createdAt"));
                    writer.newLine();
                }
            } else {
                throw new RuntimeException("Failed to add user. HTTP Code: " + responseCode);
            }
        }

        public static void main(String[] args) throws Exception {
            DataChecker checker = new DataChecker();
            checker.addUserAndSaveToCSV("John Doe", "Engineer");
//            checker.startCheckingForNewData();
        }
    }
