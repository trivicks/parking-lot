package org.vik.gojek.challenge.tests.integration;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.Car;
import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.ParkingTicket;
import org.vik.gojek.challenge.parkinglot.Slot;

public class TicketReturnTest {

	static String regNum = "KA-01-ML-9999";
	static String color = "Blue";
	static Car car = new Car(regNum, color);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testReturnTicket() throws Exception {
		ParkingLot parkingLot = ParkingLot.getInstance(3);
		ParkingTicket ticket = parkingLot.park(car);
		Integer slotNumber = ticket.getSlotNumber();
		Slot slot = parkingLot.getParkingSlots().get(slotNumber - 1);
		assertTrue("Parking ticket problems - slot number allocated does not have car",
				slot.getParkedCar().getRegistrationNumber().equalsIgnoreCase(regNum));
		parkingLot.leave(slotNumber);
		assertTrue("Parking ticket problems - slot number de-allocated should have no car",
				slot.getParkedCar() == null);
	}

}
