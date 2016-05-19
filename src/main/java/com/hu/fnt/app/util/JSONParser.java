package com.hu.fnt.app.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONParser {
	
	public static JSONArray getObjects(String API_BASE, Map<String, String> params, Map<String, String> headers) throws IOException, JSONException{
		StringBuilder sb = new StringBuilder(API_BASE);
		
		if(!params.isEmpty() || params == null){
			addParams(sb, params);
		}
		
		URL url = new URL(sb.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		if(!headers.isEmpty() || params == null){
			addHeaders(conn, headers);
		}
		
		InputStreamReader in = new InputStreamReader(conn.getInputStream());
		
		JSONArray result = getResponse(in);
		
		conn.disconnect();
		
		return result;
	}
	
	
	private static void addHeaders(HttpURLConnection conn, Map<String, String> headers){
		for(Map.Entry<String, String> entry : headers.entrySet()){
			conn.setRequestProperty(entry.getKey(), entry.getValue());
		}
	}
	
	private static void addParams(StringBuilder sb, Map<String, String> params){
		sb.append("?");
		
		int count = 0;
		for(Map.Entry<String, String> entry : params.entrySet()){
			char prefix = '&';
			
			if(count > 0){
				prefix = '&';
			}	
			sb.append(prefix+entry.getKey()+"="+entry.getValue());
				
			count++;
		}
	}
	
	private static JSONArray getResponse(InputStreamReader in) throws IOException, JSONException{
		StringBuilder jsonResults = new StringBuilder();
		
		int read;
        char[] buff = new char[1024];
        while ((read = in.read(buff)) != -1) {
            jsonResults.append(buff, 0, read);
        }
        
        JSONArray result = null;
        try{
        	result = new JSONArray(jsonResults.toString());
        }catch(JSONException e){
        	jsonResults.insert(0, "[");
        	jsonResults.append("]");
        	
        	result = new JSONArray(jsonResults.toString());
        }
             
		return result;
	}
}

