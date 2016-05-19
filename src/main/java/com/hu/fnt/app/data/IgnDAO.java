package com.hu.fnt.app.data;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hu.fnt.app.util.JSONParser;


public class IgnDAO {
	private static final String API_BASE = "https://videogamesrating.p.mashape.com/get.php";
	private static final String API_KEY = "rhwpsesgjwmshTs0P9FWTaCpLiKYp1pudpVjsnxYVxmJ4PjoJZ";
	
	
	public static double getRating(String gameTitle){		
		JSONArray results = null;
		try {
			results = getResults(gameTitle);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		if(results != null){
			double score;
			
			try {
				String scoreStr = results.getJSONObject(0).getString("score");
				score = Double.parseDouble(scoreStr);
			} catch (JSONException e) {
				score = 0.0;
			}
			return score;
		}else{
			return 0.0;
		}
	}
	
	private static JSONArray getResults(String gameTitle) throws IOException, JSONException{
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String> headers = new HashMap<String, String>();		
		params.put("count", "1");		
		gameTitle = gameTitle.replaceAll(" ", "+");		
		params.put("game", gameTitle);		
		headers.put("X-Mashape-key", API_KEY);
		headers.put("Accept", "application/json");
		
		return JSONParser.getObjects(API_BASE, params, headers);
	}
	
	
}
