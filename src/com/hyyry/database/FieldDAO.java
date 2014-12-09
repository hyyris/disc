package com.hyyry.database;

import java.util.ArrayList;
import java.util.List;

import com.hyyry.objects.Field;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FieldDAO {
	
	private SQLiteDatabase db;
	private FieldDB dbHelper;


	public FieldDAO(Context context) {
		dbHelper = new FieldDB(context);
		db = dbHelper.getWritableDatabase();
	}

	// Close the db
	public void close() {
		dbHelper.onUpgrade(db, 1, 1);
		db.close();
	}

	public void createField(String nimi, String holes) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", nimi);
		contentValues.put("holes", holes);
		db.insert("fields", null, contentValues);
	}
	
	public void createField(Field field) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", field.getName());
		contentValues.put("holes", field.getHolesString());
		db.insert("fields", null, contentValues);
		
	}

	/**
	 * Delete TODO object
	 * @param todoId
	 */
	public void deleteField(int fieldID) {
		// Delete from DB where id match
		db.delete("fields", "_id = " + fieldID, null);
	}

	/**
	 * Get all TODOs.
	 * @return
	 */
	public List<Field> getFields() {
		//List todoList = new ArrayList();
		List<Field> fieldList = new ArrayList<Field>();
		
		// Name of the columns we want to select
		String[] tableColumns = new String[] {"_id","name","holes"};

		// Query the database
		Cursor cursor = db.query("fields", tableColumns, null, null, null, null, null);
		cursor.moveToFirst();

		// Iterate the results
		while (!cursor.isAfterLast()) {
			Field field = new Field();
			// Take values from the DB
			field.setID(cursor.getInt(0));
			field.setName(cursor.getString(1));
			field.setHoles(cursor.getString(2));

			// Add to the DB
			fieldList.add(field);

			// Move to the next result
			cursor.moveToNext();
		}

		return fieldList;
	}

}
