package com.hu.fnt.app.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GiantBombDAO {

    private final String API_KEY = "e8545aaf5791d435a1fd8d77eb675b14dc94d483";
    private final String API_BASE = "http://www.giantbomb.com/api/";

    //getReview//API_BASE + "/review/"+ gameId +"/?api_key=" + API_KEY + "&format=json&field_list=description:"
    //SearchGame//API_BASE + "/games/?api_key=" + API_KEY + "&format=json&filter=name:" + gameTitle
   
    public String getJSON(String siteUrl) {
        String json = null;
        try {
            URL url = new URL("" + siteUrl);

            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuilder sb = new StringBuilder();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            json = sb.toString();
            System.out.println(json);
            is.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public Map<String, String> getIdsAndNames(String gameTitle) {
        String jsonInput = getJSON(API_BASE + "/games/?api_key=" + API_KEY + "&format=json&filter=name:" + gameTitle);
        Map<String, String> idsAndNames = new HashMap<>();

        try {

            JSONObject json = (JSONObject) new JSONParser().parse(jsonInput);
            JSONArray array = (JSONArray) json.get("results");
            Iterator i = array.iterator();
            while (i.hasNext()) {
                JSONObject inner = (JSONObject) i.next();

                idsAndNames.put((String) inner.get("id"), (String) inner.get("name"));

            }

        } catch (Exception e) {
            System.out.println("Failed");
            e.printStackTrace();
        }
        return idsAndNames;

    }
    
    public String getReview(String gameId) {
        String jsonInput = getJSON(API_BASE + "/review/"+ gameId +"/?api_key=" + API_KEY + "&format=json&field_list=description:");
        String gameReview = null;

        try {

            JSONObject json = (JSONObject) new JSONParser().parse(jsonInput);
            JSONArray array = (JSONArray) json.get("results");
            Iterator i = array.iterator();
            while (i.hasNext()) {
                JSONObject inner = (JSONObject) i.next();

                gameReview = (String) inner.get("description");

            }

        } catch (Exception e) {
            System.out.println("Failed");
            e.printStackTrace();
        }
        return gameReview;

    }
}
