package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.Ticket;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {
    @Test
    void should_given_cars_when_park_cars_then_return_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        for(int i = 0; i < 10; i++){
            //given
            Car car = new Car();

            //when
            Ticket ticket = parkingBoy.parkingCar(car);

            //then
            assertNotNull(ticket);
        }



    }
}
