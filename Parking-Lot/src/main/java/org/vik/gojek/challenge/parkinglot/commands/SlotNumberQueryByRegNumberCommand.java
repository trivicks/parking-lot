package org.vik.gojek.challenge.parkinglot.commands;

import java.util.ArrayList;

import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.exceptions.InvalidCommandParametersException;
import org.vik.gojek.challenge.parkinglot.interpreter.CommandHandler;

public class SlotNumberQueryByRegNumberCommand implements CommandHandler {

	@Override
	public Object run(ArrayList<String> args, ParkingLot parkingLot) throws Exception {
		if (args.size() != 1)
			throw new InvalidCommandParametersException(args.get(0));

		Integer slotNum = parkingLot.fetchSlotNumByRegNum(args.get(0));
		if (slotNum == -1) {
			System.out.println("Not found");
			return "Not found";
		} else {
			System.out.println(slotNum);
			return slotNum.toString();
		}
	}
}
