package com.eye_egypt.conferenceapp.database;

public class LibraryItems {
	
	//private variables
	int _id;
	String _name;
	String _title;
	
	// Empty constructor
	public LibraryItems(){
		
	}
	// constructor
	public LibraryItems(int id, String name, String _title){
		this._id = id;
		this._name = name;
		this._title = _title;
	}
	
	// constructor
	public LibraryItems(String name, String _title){
		this._name = name;
		this._title = _title;
	}
	// getting ID
	public int getID(){
		return this._id;
	}
	
	// setting id
	public void setID(int id){
		this._id = id;
	}
	
	// getting name
	public String getName(){
		return this._name;
	}
	
	// setting name
	public void setName(String name){
		this._name = name;
	}
	
	// getting phone number
	public String getTitle(){
		return this._title;
	}
	
	// setting phone number
	public void setTitle(String title){
		this._title = title;
	}
}
