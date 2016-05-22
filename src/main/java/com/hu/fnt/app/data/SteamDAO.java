package com.hu.fnt.app.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hu.fnt.app.util.JSONParser;

public class SteamDAO {
	private static final String API_BASE = "http://store.steampowered.com/api/";

	/**
	 * Haalt alle gameId en titles op vanaf
	 * http://api.steampowered.com/ISteamApps/GetAppList/v0001/ Je hoeft dus
	 * alleen appId en title voor elke game te setten (constructor)
	 * 
	 * LET OP! filteren op type="game" anders krijg je ook andere apps en
	 * rotzooi
	 * 
	 * @return
	 */
	public static List<Game> getGames() {
		JSONParser parser = new JSONParser("http://api.steampowered.com/ISteamApps/GetAppList/v0002/");
		parser.printURLonExecute(true);

		JSONArray result;
		List<Game> allGames = new ArrayList<Game>();

		int appId = 0;
		String name = "";

		try {
			JSONArray returnValue = parser.getObjects();

			result = returnValue.getJSONObject(0).getJSONObject("applist").getJSONArray("apps");

			for (int i = 0; i < result.length(); i++) {
				appId = result.getJSONObject(i).getInt("appid");
				name = result.getJSONObject(i).getString("name");
				allGames.add(new Game(appId, name));
			}
		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allGames;
	}

	/**
	 * Haalt de details op van een game aan de hand van appId Hier de Steam API
	 * voor gebruiken (Documentatie staat op hun site)
	 * 
	 * @param appId
	 * @return
	 */
	public static Game getGameDetails(int appId) {
		JSONParser parser = new JSONParser(API_BASE + "appdetails?");
		parser.addParam("appids", String.valueOf(appId));

		parser.printURLonExecute(true);

		JSONArray result = null;
		String name = "";
		Game game = new Game(appId, "");

		try {
			result = parser.getObjects();
			JSONObject jsonObj = result.getJSONObject(0);
			name = jsonObj.getJSONObject(String.valueOf(appId)).getJSONObject("data").getString("name");
			game = new Game(appId, name);
			game.setDescription(jsonObj.getJSONObject(String.valueOf(appId)).getJSONObject("data")
					.getString("detailed_description"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return game;
	}
}
