package com.hyyry.objects;

import java.util.ArrayList;
import java.util.List;


public class Player {
	
	private int[] gameScore;
	private String name = "";
	private long ID;
	private boolean selected;
	
	// Staattiset listat, helpottaa käsittelyy. Purkkaa?
	public static List<Player> players = new ArrayList<Player>();
	//public static List<Player> gamePlayers = new ArrayList<Player>();
	
	public Player() {
		setID();
	}
	
	public int getScore(int fairwayNr) {
		return gameScore[fairwayNr];
	}
	
	public int[] getGameScore() {
		return gameScore;
	}
	
	public void setScore(int fairwayNr, int score) {
		gameScore[fairwayNr] = score;
		
	}
	
	public void setNewGame(int fieldLength) {
		gameScore = new int[fieldLength];
	}
	
	public static void addPlayer(Player player) {

		players.add(player);
	}
	
	public boolean isSelected() {
	    return selected;
	}

	
	public void setSelected(boolean selected) {
		this.selected = selected; //siirsin ylös...?
		
		if (selected)
			Game.players.add(this);
		else
			Game.players.remove(this);
		
		//this.selected = selected;
	}
	
	/**
	 * TODO: Check the next free ID and use it.
	 */
	private void setID() {
		this.ID = 0; //this.ID = tietokantakontrolleri.nextFree();
	}
	
	public void setID(long id) {
		    this.ID = id;
		  }
	
	public long getID() {
		return this.ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	  
	  

}
