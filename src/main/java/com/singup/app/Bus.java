package com.singup.app;

import java.util.ArrayList;

public class Bus {
	private String name;
    private String route;
    private  int totalPas;
    private String BusDriverName;
    private String busId;
    private int busDriverId;
    private ArrayList<Passenger> busPassenger;

	public Bus(String name, String route, int totalPas,String busDriverName){
        this.name =name;
        this.route = route;
        this.totalPas = totalPas;
        this.BusDriverName = busDriverName;
        this.busPassenger = new ArrayList<Passenger>();
        
    }
	public ArrayList<Passenger> getBusPassenger() {
		return busPassenger;
	}
	public void setBusPassenger(ArrayList<Passenger> busPassenger) {
		this.busPassenger = busPassenger;
	}
	public int getBusDriverId() {
		return busDriverId;
	}

	public void setBusDriverId(int busDriverId) {
		this.busDriverId = busDriverId;
	}

    
    public String getBusDriverName() {
		return BusDriverName;
	}

	public void setBusDriverName(String busDriverName) {
		BusDriverName = busDriverName;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public int getTotalPas() {
        return totalPas;
    }

    public void setTotalPas(int totalPas) {
        this.totalPas = totalPas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
