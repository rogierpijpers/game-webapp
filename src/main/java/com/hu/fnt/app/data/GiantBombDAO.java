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

import org.json.JSONArray;
import org.json.JSONException;

import com.hu.fnt.app.util.JSONParser;

public class GiantBombDAO {
    private static final String API_KEY = "e8545aaf5791d435a1fd8d77eb675b14dc94d483";
    private static final String API_BASE = "http://www.giantbomb.com/api/";

    public static String getReview(String gameTitle) {
        gameTitle = gameTitle.replaceAll(" ", "%20");
        
        JSONParser parser = new JSONParser(API_BASE + "games/");
        parser.addParam("api_key", API_KEY);
    	parser.addParam("format", "json");
    	parser.addParam("filter", "name:"+gameTitle);
    	parser.addParam("field_list", "name,description");
    	
    	parser.printURLonExecute(true);
    	
    	JSONArray result;
    	
    	String review = "";
    	
		try {
			JSONArray returnValue = parser.getObjects();
			result = returnValue.getJSONObject(0).getJSONArray("results");
			
			for(int i = 0; i < result.length(); i++){
				gameTitle = gameTitle.replaceAll("%20", " ");
				
				if(gameTitle.equals(result.getJSONObject(i).getString("name").trim())){
					review = result.getJSONObject(i).getString("description");
				}
			}
			if(review.equals("")){
				review = result.getJSONObject(0).getString("description");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return review;
    }
}
