package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {

    @Test
    void should_given_two_cars_when_park_then_each_parkinglot_is_1() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        for(int i = 0; i < 2; i++){
            smartParkingBoy.parkCar(new Car());
        }

        //then
        assertEquals(1,smartParkingBoy.getParkingLots().get(0).getTicketCarMap().size());
        assertEquals(1,smartParkingBoy.getParkingLots().get(1).getTicketCarMap().size());

    }
}
