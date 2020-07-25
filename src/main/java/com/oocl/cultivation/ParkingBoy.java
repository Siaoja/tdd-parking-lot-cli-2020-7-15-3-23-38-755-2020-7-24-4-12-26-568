package com.oocl.cultivation;

public class ParkingBoy {
    ParkingLot parkingLot;

    public ParkingBoy() {
        parkingLot = new ParkingLot();
    }

    public CarTicket parkCar(Car car) {
        return parkingLot.park(car);
    }

    public Car fetchCar(CarTicket carTicket) {
        if (parkingLot.isRightTicket(carTicket))
            return parkingLot.fetch(carTicket);
        else
            return null;
    }

    public String queryTicket(CarTicket carTicketicket) {
        if(carTicketicket == null){
            return "Please provide your parking ticket.";
        }else{
            return "Unrecognized parking ticket.";
        }
    }
}
