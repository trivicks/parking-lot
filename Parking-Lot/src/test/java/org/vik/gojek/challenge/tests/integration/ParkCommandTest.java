package org.vik.gojek.challenge.tests.integration;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.Car;
import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.ParkingTicket;
import org.vik.gojek.challenge.parkinglot.interpreter.InteractiveCommandInterpreter;
import org.vik.gojek.challenge.parkinglot.interpreter.ParkingLotCommands;

public class ParkCommandTest {

	private static final String SPACE = " ";

	@Test
	public void testParkCommand() throws Exception {
		InteractiveCommandInterpreter cmdInt = new InteractiveCommandInterpreter();
		ParkingLot parkingLot = (ParkingLot) cmdInt
				.processCommand(ParkingLotCommands.CREATE_PARKING_LOT_CMD + SPACE + "5");
		ParkingTicket ticket = (ParkingTicket) cmdInt
				.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-1111" + SPACE + "Red");
		assertTrue(ticket.getRegistrationNumber().equalsIgnoreCase("KA-01-ML-1111"));

		Car car = parkingLot.getParkingSlots().get(ticket.getSlotNumber() - 1).getParkedCar();
		assertTrue(car.getRegistrationNumber().equalsIgnoreCase("KA-01-ML-1111"));
	}

}
