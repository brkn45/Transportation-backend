package com.singup.app;

import java.util.ArrayList;

public class Data {
	ArrayList<Driver> driver;
	ArrayList<Passenger> passenger;
	ArrayList<Bus> bus;
	

	int BusIDStartNumber;
	int size;
	Data(){
		driver = new ArrayList<Driver>();
		passenger = new ArrayList<Passenger>();
		this.bus = new ArrayList<Bus>();
		this.size = 0;
		this.BusIDStartNumber = 1000;
	}
	public int getBusIDStartNumber() {
		return BusIDStartNumber;
	}
	public void setBusIDStartNumber(int busIDStartNumber) {
		BusIDStartNumber = busIDStartNumber;
	}
	public int addAndReturnBusId() {
		BusIDStartNumber++;
		return BusIDStartNumber;
	}
	public ArrayList<Bus> getBus(){
		return bus;
	}
	public void setBus(ArrayList<Bus> bus) {
		this.bus = bus;
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
