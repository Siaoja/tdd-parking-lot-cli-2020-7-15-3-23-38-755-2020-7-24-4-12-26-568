package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkCarInfo parkCar(Car car) {
        ParkCarInfo parkCarInfo;
        CarTicket carTicket = null;
        ParkingLot bestParkingLot = null;
        double bestUnavailablePositionRate = 1.0;

        for (ParkingLot parkingLot : super.getParkingLots()) {
            double parkingLotUsedCapacity = parkingLot.getTicketCarMap().size();
            double parkingLotMaxCapacity = parkingLot.getMaxCapacity();
            double parkingLotUnavaliablePositionRate = parkingLotUsedCapacity / parkingLotMaxCapacity;
            if (parkingLotUnavaliablePositionRate < bestUnavailablePositionRate) {
                bestParkingLot = parkingLot;
                bestUnavailablePositionRate = parkingLotUnavaliablePositionRate;
            }
        }
        if (bestParkingLot != null) {
            carTicket = bestParkingLot.park(car);
        }

        parkCarInfo = new ParkCarInfo(carTicket, (carTicket == null ? "Not enough position." : null));
        return parkCarInfo;
    }
}
