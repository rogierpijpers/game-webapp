package com.hu.fnt.app.data;

import java.util.List;

/**
 * GameFactory in klassendiagram maar deze naam leek me beter
 * @author Rogier
 *
 */
public class GameFacade {
	
	/**
	 * Al klaar
	 * @return
	 */
	public static List<Game> getGames(){
		return SteamDAO.getGames();
	}
	
	
	
	/**
	 * Hier in wordt dus alles samengevoegd:
	 * -gameDetails van SteamDAO
	 * -review van GiantBomb
	 * -rating van IGN
	 * -videoId van youtubeDAO
	 * 
	 * @param appId
	 * @return
	 */
	public static Game getGameDetails(int appId){
		return null;
	}
	
}
