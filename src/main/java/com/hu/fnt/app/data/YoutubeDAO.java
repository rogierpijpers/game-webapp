package com.hu.fnt.app.data;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;

import com.hu.fnt.app.util.JSONParser;

public class YoutubeDAO {
	private static final String API_BASE = "https://www.googleapis.com/youtube/v3/search?";
	private static final String API_KEY = "AIzaSyAvc0ZKkQc9isKwPKRPhUDqrgRh7krDwQQ";

	public static String getVideoId(String gameTitle){
        gameTitle = gameTitle.replaceAll(" ", "%20");
        
        JSONParser parser = new JSONParser(API_BASE);
    	parser.addParam("part", "id");
    	parser.addParam("q", gameTitle + "%20Trailer");
    	parser.addParam("type", "video");
    	parser.addParam("fields", "items%2Fid");
    	parser.addParam("key", API_KEY);
    	
    	JSONArray result;
    	
    	String videoId = "";
    	
    	try {
    		JSONArray returnValue = parser.getObjects();
    		result = returnValue.getJSONObject(0).getJSONArray("items");
    		
    		videoId = result.getJSONObject(0).getJSONObject("id").getString("videoId");
    	} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return videoId;
	}
}
