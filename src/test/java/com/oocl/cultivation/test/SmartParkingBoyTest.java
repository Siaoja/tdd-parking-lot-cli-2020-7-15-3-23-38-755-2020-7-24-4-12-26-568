package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {

    List<ParkingLot> parkingLots;
    SmartParkingBoy smartParkingBoy;

    @BeforeEach
    void init() {
        parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        smartParkingBoy =new SmartParkingBoy(parkingLots);
    }

    @Test
    void should_given_two_cars_when_park_then_each_parkinglot_is_1() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        for (int i = 0; i < 2; i++) {
            smartParkingBoy.parkCar(new Car());
        }

        //then
        assertEquals(1, smartParkingBoy.getParkingLots().get(0).getTicketCarMap().size());
        assertEquals(1, smartParkingBoy.getParkingLots().get(1).getTicketCarMap().size());

    }

    @Test
    void should_given_cars_when_park_cars_then_return_tickets() {
        //given
        for (int i = 0; i < 10; i++) {
            //given
            Car car = new Car();

            //when
            CarTicket carTicket = smartParkingBoy.parkCar(car).getCarTicket();

            //then
            assertNotNull(carTicket);
        }
    }

    @Test
    void should_given_tickets_when_fetch_cars_then_return_right_car() {
        //given
        List<Car> carList = new ArrayList<>();
        List<CarTicket> carTicketList = new ArrayList<>();
        List<Car> fetchedCarList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //given
            carList.add(new Car());
            carTicketList.add(smartParkingBoy.parkCar(carList.get(i)).getCarTicket());
        }

        //when
        for (int i = 0; i < 10; i++) {
            fetchedCarList.add(smartParkingBoy.fetchCar(carTicketList.get(i)).getCar());
        }

        //then
        for (int i = 0; i < 10; i++) {
            assertNotNull(fetchedCarList.get(i));
            assertEquals(carList.get(i), fetchedCarList.get(i));
        }
    }

    @Test
    void should_given_wrong_ticket_when_fetch_cars_then_return_no_car() {
        //given
        Car car = new Car();
        smartParkingBoy.parkCar(car);
        CarTicket wrongTicket = new CarTicket();

        //when
        Car fetchedCar = smartParkingBoy.fetchCar(wrongTicket).getCar();

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_given_no_ticket_when_fetch_cars_then_return_no_car() {
        //given
        Car car = new Car();
        smartParkingBoy.parkCar(car);
        CarTicket wrongTicket = null;

        //when
        Car fetchedCar = smartParkingBoy.fetchCar(wrongTicket).getCar();

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_given_used_ticket_when_fetch_cars_then_return_no_car() {
        //given
        Car car = new Car();
        CarTicket carTicket = smartParkingBoy.parkCar(car).getCarTicket();
        smartParkingBoy.fetchCar(carTicket);

        //when
        Car fetchedCar = smartParkingBoy.fetchCar(carTicket).getCar();

        //then
        assertNull(fetchedCar);
    }


    @Test
    void should_given_wrong_ticket_when_fetch_car_then_return_correspond_message() {
        //given
        Car car = new Car();
        smartParkingBoy.parkCar(car);
        CarTicket wrongTicket = new CarTicket();

        //when
        FetchCarInfo fetchCarInfo = smartParkingBoy.fetchCar(wrongTicket);
        Car fetchedCar = fetchCarInfo.getCar();
        String message = fetchCarInfo.getTicketMessage();

        //then
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    void should_given_used_ticket_when_fetch_car_then_return_correspond_message() {
        //given
        Car car = new Car();
        CarTicket carTicket = smartParkingBoy.parkCar(car).getCarTicket();
        smartParkingBoy.fetchCar(carTicket);

        //when
        FetchCarInfo fetchCarInfo = smartParkingBoy.fetchCar(carTicket);
        Car fetchedCar = fetchCarInfo.getCar();
        String message = fetchCarInfo.getTicketMessage();

        //then
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    void should_given_no_ticket_when_fetch_car_then_return_correspond_message() {
        //given
        Car car = new Car();
        smartParkingBoy.parkCar(car);

        //when
        FetchCarInfo fetchCarInfo = smartParkingBoy.fetchCar(null);
        Car fetchedCar = fetchCarInfo.getCar();
        String message = fetchCarInfo.getTicketMessage();

        //then
        assertNull(fetchedCar);
        assertEquals("Please provide your parking ticket.", message);
    }

    @Test
    void should_given_11_cars_when_park_car_then_return_correspond_message() {
        //give
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            carList.add(new Car());
        }

        //when
        List<ParkCarInfo> parkCarInfo = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            parkCarInfo.add(smartParkingBoy.parkCar(carList.get(i)));
        }


        //then
        assertNull(parkCarInfo.get(10).getCarTicket());
        assertEquals("Not enough position.", parkCarInfo.get(10).getParkMessage());
    }
}
