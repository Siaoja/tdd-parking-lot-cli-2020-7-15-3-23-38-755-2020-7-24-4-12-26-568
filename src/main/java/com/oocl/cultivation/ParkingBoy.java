package com.oocl.cultivation;

public class ParkingBoy {
    ParkingLot parkingLot;

    public ParkingBoy() {
        parkingLot = new ParkingLot();
    }

    public ParkCarInfo parkCar(Car car) {
        return new ParkCarInfo(parkingLot.park(car),null);
    }

    public FetchCarInfo fetchCar(CarTicket carTicket) {
        Car car = parkingLot.fetch(carTicket);
        String tickeMessage = "";
        if (car == null) {
            tickeMessage = queryTicket(carTicket);
        }
        FetchCarInfo fetchCarInfo = new FetchCarInfo(car, tickeMessage);
        return fetchCarInfo;
    }

    private String queryTicket(CarTicket carTicke) {
        String ticketMessage = "";
        if (carTicke == null) {
            ticketMessage = "Please provide your parking ticket.";
        } else if (!parkingLot.isRightTicket(carTicke)) {
            ticketMessage = "Unrecognized parking ticket.";
        }
        return ticketMessage;
    }
}
