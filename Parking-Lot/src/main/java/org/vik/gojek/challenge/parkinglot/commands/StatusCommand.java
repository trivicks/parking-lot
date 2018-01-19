package org.vik.gojek.challenge.parkinglot.commands;

import java.util.ArrayList;
import java.util.Iterator;

import org.vik.gojek.challenge.parkinglot.Car;
import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.Slot;
import org.vik.gojek.challenge.parkinglot.exceptions.InvalidCommandParametersException;
import org.vik.gojek.challenge.parkinglot.exceptions.ParkingLotDoesNotExistException;
import org.vik.gojek.challenge.parkinglot.interpreter.CommandHandler;

public class StatusCommand implements CommandHandler {

	@Override
	public Object run(ArrayList<String> args, ParkingLot parkingLot) throws Exception {
		if (args != null) {
			throw new InvalidCommandParametersException(args.get(0));
		} else {
			if (parkingLot != null) {
				StringBuilder output = new StringBuilder("Slot No."+ "\t" + "Registration No" + "\t" + "Colour");
				Iterator<Slot> iterator = parkingLot.getParkingSlots().iterator();
				System.out.println(output.toString());
				while (iterator.hasNext()) {
					Slot slot = iterator.next();
					Car car = slot.getParkedCar();
					if (car != null) {
						String out = slot.getSlotNumber().toString() + "\t" + car.getRegistrationNumber() + "\t"
								+ car.getColor();
						System.out.println(out);
						output.append("\n" + out);
					}
				}
				return output.toString();
			} else {
				throw new ParkingLotDoesNotExistException();
			}
		}
	}

}
