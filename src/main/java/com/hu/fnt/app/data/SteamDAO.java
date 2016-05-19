package com.hu.fnt.app.data;

import java.util.List;

public class SteamDAO {
	
	/**
	 * Haalt alle gameId en titles op vanaf http://api.steampowered.com/ISteamApps/GetAppList/v0001/
	 * Je hoeft dus alleen appId en title voor elke game te setten (constructor)
	 * 
	 * LET OP! filteren op type="game" anders krijg je ook andere apps en rotzooi
	 * @return
	 */
	public static List<Game> getGames(){
		
		return null;
	}
	
	
	/**
	 * Haalt de details op van een game aan de hand van appId
	 * Hier de Steam API voor gebruiken (Documentatie staat op hun site)
	 * @param appId
	 * @return
	 */
	public static Game getGameDetails(int appId){
		return null;
	}
}
