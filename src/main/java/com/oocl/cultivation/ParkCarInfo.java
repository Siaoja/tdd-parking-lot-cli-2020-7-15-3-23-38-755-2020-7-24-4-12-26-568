package com.oocl.cultivation;

public class ParkCarInfo {
    private CarTicket carTicket;
    private String parkMessage;

    public ParkCarInfo(CarTicket carTicket, String parkMessage) {
        this.carTicket = carTicket;
        this.parkMessage = parkMessage;
    }

    public CarTicket getCarTicket() {
        return carTicket;
    }

    public String getParkMessage() {
        return parkMessage;
    }
}
