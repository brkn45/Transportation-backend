package com.singup.app;

import java.util.ArrayList;

public class Driver extends User {
	ArrayList<String> busId;
	
	public Driver(String name, String mail, String password, String address, String personType, String gender) {
		super(name, mail, password, address, personType, gender);
		this.busId = new ArrayList<String>();
	}
	public Driver(User user) {
		super(user.getName(), user.getMail(),user.getPassword(),user.getAddress(),user.getPersonType(), user.getGender());
		super.setId(user.getId());
		this.busId = new ArrayList<String>();
	}
	
	public ArrayList<String> getBusId(){
		return busId;
	}
	
	

}
