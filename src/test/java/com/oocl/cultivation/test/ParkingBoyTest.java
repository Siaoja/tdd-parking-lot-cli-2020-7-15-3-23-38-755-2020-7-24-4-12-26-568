package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {

    @Test
    void should_given_cars_when_park_cars_then_return_tickets() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        for(int i = 0; i < 10; i++){
            //given
            Car car = new Car();

            //when
            CarTicket carTicket = parkingBoy.parkCar(car);

            //then
            assertNotNull(carTicket);
        }
    }
}
