package com.oocl.cultivation.test;

import com.oocl.cultivation.*;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkCarInfo parkCar(Car car) {
        ParkCarInfo parkCarInfo;
        CarTicket carTicket = null;
        ParkingLot bestParkingLot=null;
        int bestCapacity = 0;
        for (ParkingLot parkingLot : super.getParkingLots()) {
            int parkingLotCurrentCapacity = parkingLot.getMaxCapacity() - parkingLot.getTicketCarMap().size();
            if(parkingLotCurrentCapacity > bestCapacity){
                bestParkingLot = parkingLot;
                bestCapacity = parkingLotCurrentCapacity;
            }
        }
        if(bestParkingLot != null){
            carTicket = bestParkingLot.park(car);
        }

        parkCarInfo = new ParkCarInfo(carTicket, (carTicket == null ? "Not enough position." : null));
        return parkCarInfo;
    }
}
