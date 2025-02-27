package com.eye_egypt.conferenceapp.database;

import java.util.ArrayList;
import java.util.List;

import com.eye_egypt.conferenceapp.utilities.Constants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = Constants.AppName + "DB";

	// Contacts table name
	private static final String TABLE_LibraryItems = "LibraryItems";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_TITLE = "title";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_LibraryItems_TABLE = "CREATE TABLE " + TABLE_LibraryItems + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ KEY_TITLE + " TEXT" + ")";
		db.execSQL(CREATE_LibraryItems_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LibraryItems);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new LibraryItems
	public void addContact(LibraryItems libraryItems) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, libraryItems.getName()); // LibraryItems Name
		values.put(KEY_TITLE, libraryItems.getTitle()); // LibraryItems Phone

		// Inserting Row
		db.insert(TABLE_LibraryItems, null, values);
		db.close(); // Closing database connection
	}

	// Getting single LibraryItems
	LibraryItems getContact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_LibraryItems, new String[] { KEY_ID,
				KEY_NAME, KEY_TITLE }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		LibraryItems libraryItems = new LibraryItems(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2));
		// return contact
		return libraryItems;
	}
	
	// Getting All LibraryItems
	public List<LibraryItems> getAllContacts() {
		List<LibraryItems> contactList = new ArrayList<LibraryItems>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_LibraryItems;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				LibraryItems libraryItems = new LibraryItems();
				libraryItems.setID(Integer.parseInt(cursor.getString(0)));
				libraryItems.setName(cursor.getString(1));
				libraryItems.setTitle(cursor.getString(2));
				// Adding contact to list
				contactList.add(libraryItems);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}

	// Updating single contact
	public int updateContact(LibraryItems libraryItems) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, libraryItems.getName());
		values.put(KEY_TITLE, libraryItems.getTitle());

		// updating row
		return db.update(TABLE_LibraryItems, values, KEY_ID + " = ?",
				new String[] { String.valueOf(libraryItems.getID()) });
	}

	// Deleting single contact
	public void deleteContact(LibraryItems libraryItems) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_LibraryItems, KEY_ID + " = ?",
				new String[] { String.valueOf(libraryItems.getID()) });
		db.close();
	}


	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_LibraryItems;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
