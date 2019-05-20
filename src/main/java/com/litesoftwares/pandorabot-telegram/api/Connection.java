package com.litesoftwares.api;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Connection {
    private final static String API_URL = "https://www.pandorabots.com/pandora/talk-xml?";

    public static String doGETRequest(String params){
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(API_URL + params);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";

            while ((line = br.readLine()) != null){
                response.append(line);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}