package org.vik.gojek.challenge.parkinglot.interpreter;

import java.util.ArrayList;

import org.vik.gojek.challenge.parkinglot.ParkingLot;

public interface CommandHandler {

	public Object run(ArrayList<String> args, ParkingLot parkingLot) throws Exception;

}
