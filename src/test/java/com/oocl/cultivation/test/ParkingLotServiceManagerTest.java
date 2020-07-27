package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotServiceManagerTest {
    @Test
    void should_given_2_parkingBoy_when_arrange_manager_then_return_manager_list_size_2() {
        //given
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        List<ParkingLot> parkingBoyaParkingLots = new ArrayList<>();
        List<ParkingLot> parkingBoybParkingLots = new ArrayList<>();
        for(int i =0; i < 3; i++)
            parkingBoyaParkingLots.add(new ParkingLot());
        for(int i =0; i < 3; i++)
            parkingBoybParkingLots.add(new ParkingLot());
        ParkingBoy parkingBoya = new ParkingBoy(parkingBoyaParkingLots);
        ParkingBoy parkingBoyb = new ParkingBoy(parkingBoybParkingLots);

        //when
        parkingLotServiceManager.arrangeManager(parkingBoya);
        parkingLotServiceManager.arrangeManager(parkingBoyb);

        //then
        assertEquals(2,parkingLotServiceManager.getManagerListSize());
    }
}
