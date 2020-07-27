package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkCarInfo parkCar(Car car) {
        ParkCarInfo parkCarInfo;
        CarTicket carTicket = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                carTicket = parkingLot.park(car);
                break;
            }
        }

        parkCarInfo = new ParkCarInfo(carTicket, (carTicket == null ? "Not enough position." : null));
        return parkCarInfo;
    }

    public FetchCarInfo fetchCar(CarTicket carTicket) {
        FetchCarInfo fetchCarInfo;
        Car car = null;
        String ticketMessage = null;

        for (ParkingLot parkingLot : parkingLots) {
            Car fetchCar = parkingLot.fetch(carTicket);
            if (fetchCar != null) {
                car = fetchCar;
            }
        }
        if (car == null) {
            ticketMessage = queryTicket(carTicket);
        }
        fetchCarInfo = new FetchCarInfo(car, ticketMessage);
        return fetchCarInfo;
    }

    private String queryTicket(CarTicket carTicket) {
        String ticketMessage = null;
        if(carTicket == null){
            ticketMessage = "Please provide your parking ticket.";
        }else {
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.isRightTicket(carTicket)) {
                    ticketMessage = "";
                    break;
                }
                ticketMessage = "Unrecognized parking ticket.";
            }
        }
        return ticketMessage;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
