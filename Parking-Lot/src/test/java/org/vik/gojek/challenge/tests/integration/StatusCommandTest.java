package org.vik.gojek.challenge.tests.integration;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.ParkingTicket;
import org.vik.gojek.challenge.parkinglot.interpreter.InteractiveCommandInterpreter;
import org.vik.gojek.challenge.parkinglot.interpreter.ParkingLotCommands;

public class StatusCommandTest {

	private static final String SPACE = " ";

	@Test
	public void testQueryStatus() throws Exception {
		InteractiveCommandInterpreter cmdInt = new InteractiveCommandInterpreter();
		cmdInt.processCommand(ParkingLotCommands.CREATE_PARKING_LOT_CMD + " 5");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-1111" + SPACE + "Red");
		ParkingTicket ticket2 = (ParkingTicket) cmdInt
				.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-2222" + SPACE + "Yellow");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-3333" + SPACE + "White");

		String output = (String) cmdInt.processCommand(ParkingLotCommands.STATUS_CMD);
		assertTrue("Issues with registration number query by color - got this - " + output,
				output.contains("Slot No." + "\t" + "Registration No" + "\t" + "Colour"));
		assertTrue("Issues with registration number query by color - got this - " + output,
				output.contains("1\tKA-01-ML-1111\tRed"));
		assertTrue("Issues with registration number query by color - got this - " + output,
				output.contains("2\tKA-01-ML-2222\tYellow"));
		assertTrue("Issues with registration number query by color - got this - " + output,
				output.contains("3\tKA-01-ML-3333\tWhite"));

		cmdInt.processCommand(ParkingLotCommands.LEAVE_CMD + SPACE + ticket2.getSlotNumber().toString());

		output = (String) cmdInt.processCommand(ParkingLotCommands.STATUS_CMD);
		assertTrue("Issues with registration number query by color - got this - " + output,
				output.contains("Slot No.\tRegistration No\tColour"));
		assertTrue("Issues with registration number query by color - got this - " + output,
				output.contains("1\tKA-01-ML-1111\tRed"));
		assertTrue("Issues with registration number query by color - got this - " + output,
				output.contains("3\tKA-01-ML-3333\tWhite"));

	}

}
