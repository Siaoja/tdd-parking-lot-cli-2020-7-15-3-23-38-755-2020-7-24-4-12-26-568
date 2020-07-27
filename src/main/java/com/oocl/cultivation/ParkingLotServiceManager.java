package com.oocl.cultivation;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkCarInfo;
import com.oocl.cultivation.ParkingBoy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager {
    List<ParkingBoy> managerList;
    List<ParkingLot> parkingLots;

    public ParkingLotServiceManager() {
        managerList = new ArrayList<>();
    }
    public ParkingLotServiceManager(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public void arrangeManager(ParkingBoy parkingBoy) {
        managerList.add(parkingBoy);
    }

    public int getManagerListSize() {
        return managerList.size();
    }

    public ParkCarInfo arrangePark(int parkingBoyIndex, Car car) {
        ParkingBoy parkingBoy = managerList.get(parkingBoyIndex);
        return parkingBoy.parkCar(car);
    }

    public List<ParkingBoy> getManagerList() {
        return managerList;
    }

    public ParkCarInfo parkCar(Car car) {
        ParkCarInfo parkCarInfo;
        CarTicket carTicket = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getTicketCarMap().size() < parkingLot.getMaxCapacity()) {
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
        String tickeMessage = null;
        for (ParkingLot parkingLot : parkingLots) {
            Car temp = parkingLot.fetch(carTicket);
            if (temp != null) {
                car = temp;
            }
        }
        fetchCarInfo = new FetchCarInfo(car, tickeMessage);
        return fetchCarInfo;
    }
}
