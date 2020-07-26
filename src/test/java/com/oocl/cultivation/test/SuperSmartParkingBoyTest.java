package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    @Test
    void should_given_11_cars_2_different_parkinglot_when_park_then_parkinglot1_1_car_parkinglot2_10_cars() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(100));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when

        for(int i = 0; i < 11; i++){
            superSmartParkingBoy.parkCar(new Car());
        }

        //then
        assertEquals(1,superSmartParkingBoy.getParkingLots().get(0).getTicketCarMap().size());
        assertEquals(10,superSmartParkingBoy.getParkingLots().get(1).getTicketCarMap().size());
    }
}
