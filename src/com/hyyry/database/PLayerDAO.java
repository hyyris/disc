package com.hyyry.database;

import java.util.ArrayList;
import java.util.List;

import com.hyyry.objects.Player;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PLayerDAO {

	private SQLiteDatabase db;
	private PlayerDB dbHelper;


	public PLayerDAO(Context context) {
		dbHelper = new PlayerDB(context);
		db = dbHelper.getWritableDatabase();
	}

	// Close the db
	public void close() {
		dbHelper.onUpgrade(db, 1, 1);
		db.close();
	}

	public void createPlayer(String nimi) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("player", nimi);
		db.insert("players", null, contentValues);
	}
	
	public void createPlayer(Player player) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("player", player.getName());
		db.insert("players", null, contentValues);
	}

	/**
	 * Delete TODO object
	 * @param todoId
	 */
	public void deletePlayer(long playerID) {
		// Delete from DB where id match
		db.delete("players", "_id = " + playerID, null);
	}

	/**
	 * Get all TODOs.
	 * @return
	 */
	public List<Player> getPlayers() {
		//List todoList = new ArrayList();
		List<Player> playerList = new ArrayList<Player>();
		
		// Name of the columns we want to select
		String[] tableColumns = new String[] {"_id","player"};

		// Query the database
		Cursor cursor = db.query("players", tableColumns, null, null, null, null, null);
		cursor.moveToFirst();

		// Iterate the results
		while (!cursor.isAfterLast()) {
			Player player = new Player();
			// Take values from the DB
			player.setID(cursor.getInt(0));
			player.setName(cursor.getString(1));

			// Add to the DB
			playerList.add(player);

			// Move to the next result
			cursor.moveToNext();
		}

		return playerList;
	}
	
	public String getPlayersTesti() {
		//List todoList = new ArrayList();
		List<Player> playerList = new ArrayList<Player>();
		
		// Name of the columns we want to select
		String[] tableColumns = new String[] {"_id","player"};

		// Query the database
		Cursor cursor = db.query("players", tableColumns, null, null, null, null, null);
		cursor.moveToFirst();

		// Iterate the results
		while (!cursor.isAfterLast()) {
			Player player = new Player();
			// Take values from the DB
			player.setID(cursor.getInt(0));
			player.setName(cursor.getString(1));

			// Add to the DB
			playerList.add(player);

			// Move to the next result
			cursor.moveToNext();
		}
		
		String holesString = "";
		for (int i = 0; i < playerList.size(); i++) {
			holesString += playerList.get(i) + " ";
			
		}
		
		return holesString;

		//return playerList;
	}

}
