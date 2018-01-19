package org.vik.gojek.challenge.parkinglot.interpreter;

import java.util.ArrayList;

import org.vik.gojek.challenge.parkinglot.ParkingLot;
import org.vik.gojek.challenge.parkinglot.ParkingTicket;
import org.vik.gojek.challenge.parkinglot.exceptions.ParkingLotDoesNotExistException;

public class CommandInterpreterBase implements CommandInterpreter {

	protected ParkingLot parkingLot = null;
	protected CommandFactory commandFactory = new CommandFactory();
	protected StringBuilder result = new StringBuilder("");

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	@Override
	public void run() throws Exception {
		throw new Exception("Run method has to be overridden!");
	}

	public Object processCommand(String commandLine) throws Exception {
		ArrayList<String> args = getCommandArgs(commandLine);
		CommandHandler commandHandler = commandFactory.getCommandHandler(commandLine);
		if (commandLine.contains(ParkingLotCommands.CREATE_PARKING_LOT_CMD)) {
			parkingLot = (ParkingLot) commandHandler.run(args, parkingLot);
			return parkingLot;
		} else {
			if (parkingLot == null)
				throw new ParkingLotDoesNotExistException();

			return commandHandler.run(args, parkingLot);
		}
	}

	protected void handleCommandResult(Object commandOutput, String command) {
		if (commandOutput.getClass().getName().contains("String")) {
			result.append((String) commandOutput);
			result.append("\n");
		} else if (commandOutput.getClass().getName().contains("ParkingLot")) {
			result.append("Created a parking lot with " + getCommandArgs(command).get(0).toString() + " slots");
			result.append("\n");
		} else if (commandOutput.getClass().getName().contains("ParkingTicket")) {
			ParkingTicket ticket = (ParkingTicket) commandOutput;
			result.append("Allocated slot number: " + ticket.getSlotNumber().toString());
			result.append("\n");
		}
	}

	protected ArrayList<String> getCommandArgs(String line) {
		String[] fields = line.split("\\s+");
		// System.out.println("Command is:" + line);
		if (fields.length > 1) {
			ArrayList<String> args = new ArrayList<String>();
			for (int i = 1; i < fields.length; i++) {
				args.add(fields[i]);
			}
			return args; // For commands with arguments
		} else {
			return null; // For commands without any arguments like - status command
		}
	}

}
