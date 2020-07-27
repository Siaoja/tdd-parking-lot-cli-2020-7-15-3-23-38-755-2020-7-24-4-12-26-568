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
    public ParkingLotServiceManager(ArrayList<ParkingLot> parkingLots) {
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
        return null;
    }

    public FetchCarInfo fetchCar(CarTicket carTicket) {
        return null;
    }
}
