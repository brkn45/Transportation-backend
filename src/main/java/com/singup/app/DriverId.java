package com.singup.app;

public class DriverId {
	private String driverId;
	private String name;
    

	public DriverId(String driverId,String name){
        this.driverId =driverId;
        this.name = name;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
