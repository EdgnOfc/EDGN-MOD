package com.edgn.utils;

import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class WynnApiUtils {
    public static String getStringFromURL(String url) {
        String temp = "";
        try {
            URL turl = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) turl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                Scanner scan = new Scanner(turl.openStream());
                while (scan.hasNext()) {
                    temp += scan.nextLine();
                }
                scan.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

}