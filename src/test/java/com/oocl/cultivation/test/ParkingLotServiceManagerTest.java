package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingBoybParkingLots);

        //when
        parkingLotServiceManager.arrangeManager(parkingBoya);
        parkingLotServiceManager.arrangeManager(smartParkingBoy);

        //then
        assertEquals(2,parkingLotServiceManager.getManagerListSize());
    }

    @Test
    void should_given_many_parkingBoy_when_arrange_park_then_return_ticket() {
        //given
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        List<ParkingLot> smartParkingBoyParkingLots = new ArrayList<>();
        List<ParkingLot> superSmartParkingBoyParkingLots = new ArrayList<>();
        for(int i =0; i < 3; i++)
            smartParkingBoyParkingLots.add(new ParkingLot());
        for(int i =0; i < 3; i++)
            superSmartParkingBoyParkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(smartParkingBoyParkingLots);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(superSmartParkingBoyParkingLots);
        parkingLotServiceManager.arrangeManager(smartParkingBoy);
        parkingLotServiceManager.arrangeManager(superSmartParkingBoy);

        //when
        int ParkingBoyIndex = 1;
        Car car1 = new Car();
        ParkCarInfo parkCarInfo = parkingLotServiceManager.arrangePark(ParkingBoyIndex,car1);


        //then
        assertNotNull(parkCarInfo.getCarTicket());
        assertEquals(1,parkingLotServiceManager.getManagerList().get(1).getParkingLots().get(0).getTicketCarMap().size());
    }

    @Test
    void should_given_car_when_manager_park_then_return_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            parkingLots.add(new ParkingLot());
        }
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        Car car = new Car();

        //when
        ParkCarInfo parkCarInfo = parkingLotServiceManager.parkCar(car);
        FetchCarInfo fetchCarInfo = parkingLotServiceManager.fetchCar(parkCarInfo.getCarTicket());

        //then
        assertNotNull(parkCarInfo.getCarTicket());
        assertEquals(car, fetchCarInfo.getCar());
    }
}
