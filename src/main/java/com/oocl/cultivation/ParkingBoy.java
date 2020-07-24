package com.oocl.cultivation;

public class ParkingBoy {
    ParkingLot parkingLot;

    public ParkingBoy(){
        parkingLot = new ParkingLot();
    }
    public CarTicket parkCar(Car car) {
        return parkingLot.park(car);
    }

    public Car fetchCar(CarTicket ticket) {
        return null;
    }
}
