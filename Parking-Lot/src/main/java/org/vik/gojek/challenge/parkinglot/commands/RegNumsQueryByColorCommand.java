package org.vik.gojek.challenge.parkinglot.commands;

import java.util.ArrayList;
import java.util.Iterator;

import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.exceptions.InvalidCommandParametersException;
import org.vik.gojek.challenge.parkinglot.interpreter.CommandHandler;

public class RegNumsQueryByColorCommand implements CommandHandler {

	@Override
	public Object run(ArrayList<String> args, ParkingLot parkingLot) throws Exception {
		if (args.size() != 1)
			throw new InvalidCommandParametersException(args.get(0));
		
		ArrayList<String> regNums = parkingLot.fetchRegNumsByColor(args.get(0));
		if (regNums.isEmpty())
			return "Not Found";
		
		String output = "";
		Iterator<String> iterator = regNums.iterator();
		while (iterator.hasNext()) {
			output += iterator.next() + ", ";
		}
		output = output.substring(0, output.length() - 2);
		System.out.println(output);
		return output;
	}

}
