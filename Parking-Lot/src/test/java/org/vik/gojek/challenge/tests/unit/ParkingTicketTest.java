package org.vik.gojek.challenge.tests.unit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.ParkingTicket;

public class ParkingTicketTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testTicketInit() {
		Integer slotNum = 1;
		String regNum = "KA-01-ML-9999";
		ParkingTicket ticket = new ParkingTicket(slotNum, regNum);
		assertTrue("Ticket init problems - slot number does not match", ticket.getSlotNumber() == slotNum);
		assertTrue("Ticket init problems - reg number does not match", ticket.getRegistrationNumber() == regNum);
		assertTrue("Ticket init problems - date", ticket.getInTime() != null);

	}

}
