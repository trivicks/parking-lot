package org.vik.gojek.challenge.tests.integration;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.Car;
import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.ParkingTicket;
import org.vik.gojek.challenge.parkinglot.Slot;
import org.vik.gojek.challenge.parkinglot.exceptions.ParkingLotFullException;

public class TicketIssueTest {

	static String regNum = "KA-01-ML-9999";
	static String color = "Blue";
	static Car car = new Car(regNum, color);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testIssueTicket() throws Exception {
		ParkingLot parkingLot = ParkingLot.getInstance(3);
		ParkingTicket ticket = parkingLot.park(car);
		Integer slotNumber = ticket.getSlotNumber();
		Slot slot = parkingLot.getParkingSlots().get(slotNumber - 1);
		assertTrue("Nearest slot not allocated as required", slot.getSlotNumber() == 1);
		assertTrue("Parking ticket issues - slot number allocated does not have car information",
				slot.getParkedCar().getRegistrationNumber().equalsIgnoreCase(regNum));
	}

	@Test
	public void testParkingLotFull() throws Exception {
		ParkingLot parkingLot = ParkingLot.getInstance(1);
		parkingLot.park(car);
		Car nextCar = new Car("KA-00-HH-0000", "Black");
		try {
			parkingLot.park(nextCar);
			fail("Did not get parking full exception, test expects it!");
		} catch (ParkingLotFullException e) {
			// Test passed
		}
	}

}
