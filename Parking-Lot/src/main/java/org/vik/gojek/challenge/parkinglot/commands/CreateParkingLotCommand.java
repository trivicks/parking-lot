package org.vik.gojek.challenge.parkinglot.commands;

import java.util.ArrayList;

import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.exceptions.InvalidCommandParametersException;
import org.vik.gojek.challenge.parkinglot.interpreter.CommandHandler;

public class CreateParkingLotCommand implements CommandHandler {

	@Override
	public Object run(ArrayList<String> args, ParkingLot ignoreThisParam) throws Exception {
		if (args.size() != 1)
			throw new InvalidCommandParametersException(args.get(0));

		ParkingLot parkingLot = ParkingLot.getInstance(Integer.parseInt(args.get(0)));
		System.out.println("Created a parking lot with " + args.get(0) + " slots");
		return parkingLot;
	}

}
