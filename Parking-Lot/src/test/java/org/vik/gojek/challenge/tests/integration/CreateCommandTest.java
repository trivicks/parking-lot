package org.vik.gojek.challenge.tests.integration;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.interpreter.InteractiveCommandInterpreter;
import org.vik.gojek.challenge.parkinglot.interpreter.ParkingLotCommands;

public class CreateCommandTest {

	private static final String SPACE = " ";

	@Test
	public void testCreateCommand() throws Exception {
		InteractiveCommandInterpreter cmdInt = new InteractiveCommandInterpreter();
		ParkingLot parkingLot = (ParkingLot) cmdInt
				.processCommand(ParkingLotCommands.CREATE_PARKING_LOT_CMD + SPACE + "5");
		assertTrue(parkingLot.getAvailableCapacity() == 5);
	}
}
