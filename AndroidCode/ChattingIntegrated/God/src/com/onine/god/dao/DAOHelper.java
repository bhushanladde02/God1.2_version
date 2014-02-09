package com.onine.god.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOHelper extends SQLiteOpenHelper {

	public static final String TABLE = "gaali";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_GAALI_JSON= "gaali_json"  ;
	/*public static final String COLUMN_PRONOUNCIATION=  "pronounciation";
	public static final String COLUMN_USES1= "uses1" ;
	public static final String COLUMN_USES2= "uses2" ;
	public static final String COLUMN_USES3= "uses3" ;
	public static final String COLUMN_USES4=  "uses4";
	public static final String COLUMN_PROPERTIES= "properties" ;
	public static final String COLUMN_ORIGIN=  "origin";
	public static final String COLUMN_LANGUAGE= "language" ;
	public static final String COLUMN_DESCRIPTION1=  "description1";
	public static final String COLUMN_DESCRIPTION2=  "description2";
	public static final String COLUMN_DESCRIPTION3=  "description3";
	public static final String COLUMN_DESCRIPTION4=  "description4";
	public static final String COLUMN_RELATEDTO=  "relatedto";
	public static final String COLUMN_EXTRA=  "extra";*/
	

	private static final String DATABASE_NAME = "god";
	private static final int DATABASE_VERSION = 1;
	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE + "(" + COLUMN_ID
			+ " integer primary key autoincrement, "+COLUMN_GAALI_JSON+" text ) ;"; 

	public DAOHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DATABASE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 db.execSQL("DROP TABLE IF EXISTS " + TABLE);
		    onCreate(db);
	}

}
