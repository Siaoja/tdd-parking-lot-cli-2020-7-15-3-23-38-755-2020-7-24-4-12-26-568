package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_given_car_when_parking_car_then_return_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();


        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);

    }
}
