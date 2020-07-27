package com.oocl.cultivation;

public enum ParkingLotInfoConstant {
    PARKINGLOT_CAPACITY_FULL_TIPS("Not enough position."),
    PARKINGLOT_GIVE_NO_TICKET_WHEN_FETCH_TIPS("Please provide your parking ticket.");
    String constantValue;
    ParkingLotInfoConstant(String constantValue){
        this.constantValue = constantValue;
    }

}
