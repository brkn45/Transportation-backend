package com.singup.app;

import java.util.ArrayList;

public class Passenger extends User{
	private ArrayList<String> busId;
	
	public Passenger(String name, String mail, String password, String address, String personType, String gender) {
		super(name, mail, password, address, personType, gender);
		busId = new ArrayList<String>();
	}
	
	public Passenger(User user) {
		super(user.getName(), user.getMail(),user.getPassword(),user.getAddress(),user.getPersonType(), user.getGender());
		this.busId = new ArrayList<String>();
	}
	
	public ArrayList<String> getBusId(){
		return busId;
	}
	
	
}
