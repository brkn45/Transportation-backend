package com.singup.app;

public class JoinBus {
	private Integer busId;
    private String PassengerId;

    JoinBus(Integer busId, String Passenger){
        this.busId       = busId;
        this.PassengerId = Passenger;
    }

    public Integer getBusId() {
        return busId;
    }

    public String getPassengerId() {
        return PassengerId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public void setPassengerId(String passengerId) {
        PassengerId = passengerId;
    }
}
