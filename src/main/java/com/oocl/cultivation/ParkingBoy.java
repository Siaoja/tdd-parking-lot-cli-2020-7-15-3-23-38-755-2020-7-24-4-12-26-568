package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    ParkingLot parkingLot;
    List<ParkingLot> parkingLots;

    public ParkingBoy() {
        parkingLot = new ParkingLot();
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
    }

    public ParkCarInfo parkCar(Car car) {
        ParkCarInfo parkCarInfo;
        CarTicket carTicket = parkingLot.park(car);
        parkCarInfo = new ParkCarInfo(carTicket, (carTicket == null ? "Not enough position.": null));
        return parkCarInfo;
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

    public List<ParkingLot> getParkingLots() {
        return null;
    }
}
