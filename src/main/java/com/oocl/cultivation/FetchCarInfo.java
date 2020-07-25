package com.oocl.cultivation;

public class FetchCarInfo {
    private Car car;
    private String ticketMessage;

    public FetchCarInfo(Car car, String ticketMessage) {
        this.car = car;
        this.ticketMessage = ticketMessage;
    }

    public Car getCar() {
        return car;
    }

    public String getTicketMessage() {
        return ticketMessage;
    }
}
