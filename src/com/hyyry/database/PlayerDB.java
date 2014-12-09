package com.hyyry.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlayerDB extends SQLiteOpenHelper {
	
	  public static final String TABLE_PLAYERS = "players";
	  public static final String COLUMN_ID = "_id";
	  public static final String COLUMN_PLAYER = "player";

	  private static final String DATABASE_NAME = "players.db";
	  private static final int DATABASE_VERSION = 1;
	  
	  // Database creation sql statement
	  private static final String DATABASE_CREATE = "create table "
	      + TABLE_PLAYERS + "(" + COLUMN_ID
	      + " integer primary key autoincrement, " + COLUMN_PLAYER
	      + " text not null);";
	  
	  
	PlayerDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
		onCreate(db);
		//Tuhoo kaiken, korvaa jollain järkevällä tulevaisuudessa
	    /*
		Log.w(MySQLiteHelper.class.getName(),
	            "Upgrading database from version " + oldVersion + " to "
	                + newVersion + ", which will destroy all old data");
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
	        onCreate(db);*/
		
	}
}
