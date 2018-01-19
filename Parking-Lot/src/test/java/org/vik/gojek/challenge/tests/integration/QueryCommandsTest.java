package org.vik.gojek.challenge.tests.integration;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.interpreter.InteractiveCommandInterpreter;
import org.vik.gojek.challenge.parkinglot.interpreter.ParkingLotCommands;

public class QueryCommandsTest {

	private static final String SPACE = " ";

	@Test
	public void testQueryRegNumByColor() throws Exception {
		InteractiveCommandInterpreter cmdInt = new InteractiveCommandInterpreter();
		cmdInt.processCommand(ParkingLotCommands.CREATE_PARKING_LOT_CMD + " 5");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-1111" + SPACE + "Red");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-2222" + SPACE + "Yellow");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-3333" + SPACE + "White");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-4444" + SPACE + "White");
		String regnums = (String) cmdInt
				.processCommand(ParkingLotCommands.REGNUMS_BY_COLOR_QUERY_CMD + SPACE + "White");
		assertTrue("Issues with registration number query by color - got this - " + regnums,
				regnums.equalsIgnoreCase("KA-01-ML-3333, KA-01-ML-4444"));

		regnums = (String) cmdInt.processCommand(ParkingLotCommands.REGNUMS_BY_COLOR_QUERY_CMD + SPACE + "Red");
		assertTrue("Issues with registration number query by color - got this - " + regnums,
				regnums.equalsIgnoreCase("KA-01-ML-1111"));

		regnums = (String) cmdInt.processCommand(ParkingLotCommands.REGNUMS_BY_COLOR_QUERY_CMD + SPACE + "Yellow");
		assertTrue("Issues with registration number query by color - got this - " + regnums,
				regnums.equalsIgnoreCase("KA-01-ML-2222"));

	}

	@Test
	public void testQuerySlotNumByColor() throws Exception {
		InteractiveCommandInterpreter cmdInt = new InteractiveCommandInterpreter();
		cmdInt.processCommand(ParkingLotCommands.CREATE_PARKING_LOT_CMD + " 5");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-1111" + SPACE + "Red");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-2222" + SPACE + "Yellow");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-3333" + SPACE + "White");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-4444" + SPACE + "White");
		String slotnums = (String) cmdInt
				.processCommand(ParkingLotCommands.SLOT_NUMBERS_BY_COLOR_QUERY_CMD + SPACE + "White");
		assertTrue("Issues with registration number query by color - got this - " + slotnums,
				slotnums.equalsIgnoreCase("3, 4"));

		slotnums = (String) cmdInt.processCommand(ParkingLotCommands.SLOT_NUMBERS_BY_COLOR_QUERY_CMD + SPACE + "Red");
		assertTrue("Issues with registration number query by color - got this - " + slotnums,
				slotnums.equalsIgnoreCase("1"));

		slotnums = (String) cmdInt
				.processCommand(ParkingLotCommands.SLOT_NUMBERS_BY_COLOR_QUERY_CMD + SPACE + "Yellow");
		assertTrue("Issues with registration number query by color - got this - " + slotnums,
				slotnums.equalsIgnoreCase("2"));
	}

	@Test
	public void testQuerySlotNumByRegNum() throws Exception {
		InteractiveCommandInterpreter cmdInt = new InteractiveCommandInterpreter();
		cmdInt.processCommand(ParkingLotCommands.CREATE_PARKING_LOT_CMD + " 5");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-1111" + SPACE + "Red");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-2222" + SPACE + "Yellow");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-3333" + SPACE + "White");
		cmdInt.processCommand(ParkingLotCommands.PARK_CMD + SPACE + "KA-01-ML-4444" + SPACE + "White");

		String slotnum = (String) cmdInt
				.processCommand(ParkingLotCommands.SLOT_NUMBER_BY_REGNUM_QUERY_CMD + SPACE + "KA-01-ML-1111");
		assertTrue("Issues with registration number query by color - got this - " + slotnum, Integer.parseInt(slotnum) == 1);

		slotnum = (String) cmdInt
				.processCommand(ParkingLotCommands.SLOT_NUMBER_BY_REGNUM_QUERY_CMD + SPACE + "KA-01-ML-4444");
		assertTrue("Issues with registration number query by color - got this - " + slotnum, Integer.parseInt(slotnum) == 4);
	}
	
}
