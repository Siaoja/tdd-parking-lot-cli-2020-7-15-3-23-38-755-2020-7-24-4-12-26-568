package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;

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
}
