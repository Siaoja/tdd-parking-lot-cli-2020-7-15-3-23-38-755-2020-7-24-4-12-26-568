package com.oocl.cultivation;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkCarInfo;
import com.oocl.cultivation.ParkingBoy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager {
    List<ParkingBoy> managerList;

    public ParkingLotServiceManager() {
        managerList = new ArrayList<>();
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
}
