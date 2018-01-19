package org.vik.gojek.challenge.tests.unit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.Slot;

public class ParkingSlotTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSlotInit() {
		Integer slotNum = 1;
		Slot parkingSlot = new Slot(slotNum);
		assertTrue("Slot init problems", parkingSlot.getSlotNumber() == slotNum);
	}

}
