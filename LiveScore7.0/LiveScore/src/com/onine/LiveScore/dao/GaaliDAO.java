package com.onine.LiveScore.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.onine.model.Gaali;

public class GaaliDAO {
	private SQLiteDatabase database;
	private DAOHelper dbHelper;
	private Gson gson = new GsonBuilder().create();
	private String[] allColumns = { DAOHelper.COLUMN_ID,
			DAOHelper.COLUMN_GAALI_JSON /*
										 * , DAOHelper.COLUMN_PRONOUNCIATION,
										 * DAOHelper.COLUMN_USES1,
										 * DAOHelper.COLUMN_USES2,
										 * DAOHelper.COLUMN_USES3,
										 * DAOHelper.COLUMN_USES4,
										 * DAOHelper.COLUMN_PROPERTIES,
										 * DAOHelper.COLUMN_ORIGIN,
										 * DAOHelper.COLUMN_LANGUAGE,
										 * DAOHelper.COLUMN_DESCRIPTION1,
										 * DAOHelper.COLUMN_DESCRIPTION2,
										 * DAOHelper.COLUMN_DESCRIPTION3,
										 * DAOHelper.COLUMN_DESCRIPTION4,
										 * DAOHelper.COLUMN_RELATEDTO,
										 * DAOHelper.COLUMN_EXTRA
										 */};

	public GaaliDAO(Context context) {
		dbHelper = new DAOHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public long createGaali(String jsonString) {
		ContentValues values = new ContentValues();
		values.put(DAOHelper.COLUMN_GAALI_JSON, jsonString);
		/*
		 * values.put(DAOHelper.COLUMN_DESCRIPTION1, gaali.getDescription1());
		 * values.put(DAOHelper.COLUMN_DESCRIPTION2, gaali.getDescription2());
		 * values.put(DAOHelper.COLUMN_DESCRIPTION3, gaali.getDescription3());
		 * values.put(DAOHelper.COLUMN_DESCRIPTION4, gaali.getDescription4());
		 * values.put(DAOHelper.COLUMN_EXTRA, gaali.getExtra());
		 * values.put(DAOHelper.COLUMN_LANGUAGE, gaali.getLanguage());
		 * values.put(DAOHelper.COLUMN_ORIGIN,gaali.getOrigin());
		 * values.put(DAOHelper.COLUMN_PRONOUNCIATION,
		 * gaali.getPronounciation()); values.put(DAOHelper.COLUMN_PROPERTIES,
		 * gaali.getProperties()); values.put(DAOHelper.COLUMN_RELATEDTO,
		 * gaali.getRelatedTo()); values.put(DAOHelper.COLUMN_USES1,
		 * gaali.getUses1()); values.put(DAOHelper.COLUMN_USES2,
		 * gaali.getUses2()); values.put(DAOHelper.COLUMN_USES3,
		 * gaali.getUses3()); values.put(DAOHelper.COLUMN_USES4,
		 * gaali.getUses4());
		 */

		long insertId = database.insert(DAOHelper.TABLE, null, values);

		return insertId;

	}
	
	public void deleteGaaliAll() {
	//	long id = gaali.getId();
		database.delete(DAOHelper.TABLE, null, null);
		
	}
	
	public void deleteGaali(Gaali gaali) {
		long id = gaali.getId();
		database.delete(DAOHelper.TABLE, DAOHelper.COLUMN_ID + " = " + id, null);
		
	}

	public List<Gaali> getAllGaali() {
		List<Gaali> gaalis = new ArrayList<Gaali>();
		Cursor cursor = database.query(DAOHelper.TABLE, allColumns, null, null,
				null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Gaali gaali = jsonToGaali(cursor);
			gaalis.add(gaali);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return gaalis;
	}
	
	public Gaali getGaali(int id) {
		Gaali gaali = new Gaali();
		Cursor cursor = database.query(DAOHelper.TABLE, allColumns, "_id = "+id, null,
				null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			gaali = jsonToGaali(cursor);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return gaali;
	}

	private Gaali jsonToGaali(Cursor cursor) {
		// TODO Auto-generated method stub
		System.out.println("JSON String");
		System.out.println(cursor.getString(1)); 
		return gson.fromJson(cursor.getString(1), Gaali.class);
	}

}
