package org.vik.gojek.challenge.tests.unit;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.Car;
import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.ParkingTicket;
import org.vik.gojek.challenge.parkinglot.Slot;

public class ParkingLotTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testCapacity() {
		Integer CAPACITY = 5;
		ParkingLot parkingLot = ParkingLot.getInstance(CAPACITY);
		assertTrue("Parking lot init problems, capacity does not match.",
				parkingLot.getParkingSlots().size() == CAPACITY);
		ArrayList<Slot> slots = parkingLot.getParkingSlots();
		for (int i = 0; i < CAPACITY; i++) {
			assertTrue("Slot num and array index don't match which is essential for search logic.",
					slots.get(i).getSlotNumber() == i + 1);
		}
	}

	@Test
	public void testFreeCapacity() throws Exception {
		Integer CAPACITY = 5;
		ParkingLot parkingLot = ParkingLot.getInstance(CAPACITY);

		// Parking
		ParkingTicket ticket1 = parkingLot.park(new Car("KA-01-ML-1111", "Black"));
		assertTrue("Availability tracking issue while parking", parkingLot.getAvailableCapacity() == CAPACITY - 1);
		ParkingTicket ticket2 = parkingLot.park(new Car("KA-01-ML-1111", "Red"));
		assertTrue("Availability tracking issue while parking", parkingLot.getAvailableCapacity() == CAPACITY - 2);

		// Leaving
		parkingLot.leave(ticket1.getSlotNumber());
		assertTrue("Availability tracking issue while leaving", parkingLot.getAvailableCapacity() == CAPACITY - 1);

		parkingLot.leave(ticket2.getSlotNumber());
		assertTrue("Availability tracking issue while leaving", parkingLot.getAvailableCapacity() == CAPACITY);
	}

	@Test
	public void testNearestAvailableAllocation() throws Exception {
		Integer CAPACITY = 3;
		ParkingLot parkingLot = ParkingLot.getInstance(CAPACITY);

		ParkingTicket ticket1 = parkingLot.park(new Car("KA-01-ML-1111", "Red"));
		ParkingTicket ticket2 = parkingLot.park(new Car("KA-01-ML-2222", "Red"));
		ParkingTicket ticket3 = parkingLot.park(new Car("KA-01-ML-3333", "Red"));

		assertTrue("Nearest available allocation issue", ticket1.getSlotNumber() == 1);
		assertTrue("Nearest available allocation issue", ticket2.getSlotNumber() == 2);
		assertTrue("Nearest available allocation issue", ticket3.getSlotNumber() == 3);

		parkingLot.leave(ticket1.getSlotNumber());
		ParkingTicket ticket4 = parkingLot.park(new Car("KA-01-ML-1111", "Red"));
		assertTrue("Nearest available allocation issue", ticket4.getSlotNumber() == 1);

		parkingLot.leave(ticket2.getSlotNumber());
		ParkingTicket ticket5 = parkingLot.park(new Car("KA-01-ML-1111", "Red"));
		assertTrue("Nearest available allocation issue", ticket5.getSlotNumber() == 2);

		parkingLot.leave(ticket3.getSlotNumber());
		ParkingTicket ticket6 = parkingLot.park(new Car("KA-01-ML-1111", "Red"));
		assertTrue("Nearest available allocation issue", ticket6.getSlotNumber() == 3);
	}

}
