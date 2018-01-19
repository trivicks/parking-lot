package org.vik.gojek.challenge.parkinglot.interpreter;

import org.vik.gojek.challenge.parkinglot.commands.CreateParkingLotCommand;
import org.vik.gojek.challenge.parkinglot.commands.LeaveCommand;
import org.vik.gojek.challenge.parkinglot.commands.ParkCommand;
import org.vik.gojek.challenge.parkinglot.commands.RegNumsQueryByColorCommand;
import org.vik.gojek.challenge.parkinglot.commands.SlotNumberQueryByRegNumberCommand;
import org.vik.gojek.challenge.parkinglot.commands.SlotNumsQueryByColorCommand;
import org.vik.gojek.challenge.parkinglot.commands.StatusCommand;
import org.vik.gojek.challenge.parkinglot.exceptions.InvalidCommandException;

public class CommandFactory {

	public CommandHandler getCommandHandler(String commandLine) throws Exception {
		String command = getCommand(commandLine);
		CommandHandler commandHandler = null;
		if (command.contains(ParkingLotCommands.CREATE_PARKING_LOT_CMD)) {
			commandHandler = new CreateParkingLotCommand();
		} else if (command.contains(ParkingLotCommands.PARK_CMD)) {
			commandHandler = new ParkCommand();
		} else if (command.contains(ParkingLotCommands.LEAVE_CMD)) {
			commandHandler = new LeaveCommand();
		} else if (command.contains(ParkingLotCommands.STATUS_CMD)) {
			commandHandler = new StatusCommand();
		} else if (command.contains(ParkingLotCommands.REGNUMS_BY_COLOR_QUERY_CMD)) {
			commandHandler = new RegNumsQueryByColorCommand();
		} else if (command.contains(ParkingLotCommands.SLOT_NUMBERS_BY_COLOR_QUERY_CMD)) {
			commandHandler = new SlotNumsQueryByColorCommand();
		} else if (command.contains(ParkingLotCommands.SLOT_NUMBER_BY_REGNUM_QUERY_CMD)) {
			commandHandler = new SlotNumberQueryByRegNumberCommand();
		} else {
			throw new InvalidCommandException(command);
		}
		return commandHandler;
	}

	private String getCommand(String line) {
		String[] fields = line.split("\\s+");
		return fields[0];
	}

}
