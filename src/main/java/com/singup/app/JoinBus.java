package com.singup.app;

public class JoinBus {
	Integer busId;
    String PassengerId;

    JoinBus(Integer busId, String PassengerId){
        this.busId       = busId;
        this.PassengerId = PassengerId;
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
