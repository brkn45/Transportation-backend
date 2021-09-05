package com.singup.app;

import java.util.ArrayList;

public class Data {
	ArrayList<Driver> driver;
	ArrayList<Passenger> passenger;
	int size;
	Data(){
		driver = new ArrayList<Driver>();
		passenger = new ArrayList<Passenger>();
		this.size = 0;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size =size;
	}
	public int increaseSize() {
		size++;
		return size-1;
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
