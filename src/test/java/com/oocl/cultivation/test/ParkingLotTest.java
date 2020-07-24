package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_given_car_when_park_car_then_return_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();


        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);

    }

    @Test
    void should_given_ticket_when_fetch_car_then_return_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.park(car);

        //when
        Car fetchedCar = parkingLot.fetch(carTicket);

        //then
        assertNotNull(car);
        assertEquals(car,fetchedCar);

    }

    @Test
    void should_given_cars_when_park_cars_then_return_ticket() {
        //given
        ParkingLot parkingBoy = new ParkingLot();

        for(int i = 0; i < 10; i++){
            //given
            Car car = new Car();

            //when
            CarTicket carTicket = parkingBoy.park(car);

            //then
            assertNotNull(carTicket);
        }
    }
}
