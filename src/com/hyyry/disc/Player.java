package com.hyyry.disc;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name = "";
	private int ID;
	
	public static List<Player> players = new ArrayList<Player>();
	
	public Player() {
		setID();
	}
	
	public static void addPlayer(Player player) {
		//TODO lis‰‰ SQL‰‰n
		players.add(player);
	}
	
	/**
	 * TODO: Check the next free ID and use it.
	 */
	private void setID() {
		this.ID = 0; //this.ID = tietokantakontrolleri.nextFree();
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
