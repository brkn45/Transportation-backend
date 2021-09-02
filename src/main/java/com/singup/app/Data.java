package com.singup.app;

import java.util.ArrayList;

public class Data {
	ArrayList<Driver> driver;
	ArrayList<Passenger> passenger;
	
	Data(){
		driver = new ArrayList<Driver>();
		passenger = new ArrayList<Passenger>();
	}

	public ArrayList<Driver> getDriver() {
		return driver;
	}

	public void setDriver(ArrayList<Driver> driver) {
		this.driver = driver;
	}

	public ArrayList<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(ArrayList<Passenger> passenger) {
		this.passenger = passenger;
	}
	
}
