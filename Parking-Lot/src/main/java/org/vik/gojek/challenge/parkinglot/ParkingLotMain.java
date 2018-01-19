package org.vik.gojek.challenge.parkinglot;

import java.io.File;

import org.vik.gojek.challenge.parkinglot.interpreter.CommandInterpreter;
import org.vik.gojek.challenge.parkinglot.interpreter.FileCommandInterpreter;
import org.vik.gojek.challenge.parkinglot.interpreter.InteractiveCommandInterpreter;

public class ParkingLotMain {

	public static void main(String[] args) throws Exception {
		CommandInterpreter interpreter;
		if (args.length == 1) {
			interpreter = new FileCommandInterpreter(new File(args[0]));
		} else {
			interpreter = new InteractiveCommandInterpreter();
		}
		interpreter.run();
	}

}
