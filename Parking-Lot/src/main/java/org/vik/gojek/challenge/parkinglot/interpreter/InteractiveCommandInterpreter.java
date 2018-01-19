package org.vik.gojek.challenge.parkinglot.interpreter;

import java.util.Scanner;

public class InteractiveCommandInterpreter extends CommandInterpreterBase {

	public void run() throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("ParkingLot->");
			String command = scanner.nextLine();
			if (command.contains("exit")) {
				System.out.println("See ya, wouldn't wanna be ya!");
				break;
			} else if (command.isEmpty()) {
				continue;

			} else if (command.equalsIgnoreCase("help")) {
				System.out.println("Available commands:");
				System.out.println("    create_parking_lot <number>");
				System.out.println("    park <registration number> <color>");
				System.out.println("    status");
				System.out.println("    leave <slot number>");
				System.out.println("    registration_numbers_for_cars_with_colour <color>");
				System.out.println("    slot_numbers_for_cars_with_colour <color>");
				System.out.println("    slot_number_for_registration_number <registration number>");
				continue;
			}
			try {
				processCommand(command);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		scanner.close();
	}

}
