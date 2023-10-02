package com.bluenile.testkit.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class main {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String BASE_URL = "https://restcountries.com/v3.1/name/";

    public static void main(String[] args) throws Exception {
        String countryName = "norway"; // You can change this to any other country
        sendGET(countryName);
    }

    private static void sendGET(String countryName) throws Exception {
        URL url = new URL(BASE_URL + countryName);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Modify the response
            String modifiedResponse = response.toString()
                    .replace("\"official\":\"Kingdom of Norway\"", "\" not king\"")
                    .replace(",", ",\n");  // Add newline after each comma

            // print modified result
            System.out.println(modifiedResponse);
        } else {
            System.out.println("GET request not worked");
        }
    }
}
