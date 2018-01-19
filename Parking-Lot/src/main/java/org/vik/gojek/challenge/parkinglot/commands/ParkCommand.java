package org.vik.gojek.challenge.parkinglot.commands;

import java.util.ArrayList;

import org.vik.gojek.challenge.parkinglot.Car;
import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.ParkingTicket;
import org.vik.gojek.challenge.parkinglot.exceptions.InvalidCommandParametersException;
import org.vik.gojek.challenge.parkinglot.exceptions.ParkingLotFullException;
import org.vik.gojek.challenge.parkinglot.interpreter.CommandHandler;

public class ParkCommand implements CommandHandler {

	@Override
	public Object run(ArrayList<String> args, ParkingLot parkingLot) throws Exception {
		if (args.size() != 2)
			throw new InvalidCommandParametersException(args.get(0));
		ParkingTicket ticket;
		Car car = new Car(args.get(0), args.get(1));
		try {
			ticket = parkingLot.park(car);
			System.out.println("Allocated slot number: " + ticket.getSlotNumber().toString());
			return ticket;
		} catch (ParkingLotFullException e) {
			System.out.println("Sorry, parking lot is full");
			return "Sorry, parking lot is full";
		}

	}

}
