package org.vik.gojek.challenge.parkinglot.commands;

import java.util.ArrayList;

import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.exceptions.InvalidCommandParametersException;
import org.vik.gojek.challenge.parkinglot.interpreter.CommandHandler;

public class LeaveCommand implements CommandHandler {

	@Override
	public Object run(ArrayList<String> args, ParkingLot parkingLot) throws Exception {
		if (args.size() != 1)
			throw new InvalidCommandParametersException(args.get(0));

		Integer slotNumber = Integer.parseInt(args.get(0));
		parkingLot.leave(slotNumber);
		System.out.println("Slot number " + slotNumber + " is free");
		return "Slot number " + slotNumber + " is free";
	}

}
