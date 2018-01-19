package org.vik.gojek.challenge.parkinglot.interpreter;

import java.io.File;
import java.util.Scanner;

public class FileCommandInterpreter extends CommandInterpreterBase {

	private File inputFile = null;

	public String getResult() {
		return result.toString().substring(0, result.length() - 1);
	}

	public FileCommandInterpreter(File inputFile) throws Exception {
		this.inputFile = inputFile;
	}

	@Override
	public void run() throws Exception {
		if (inputFile != null) {
			Scanner scanner = new Scanner(inputFile);
			while (scanner.hasNextLine()) {
				String command = scanner.nextLine();
				Object commandOutput = processCommand(command);
				if (commandOutput != null) {
					handleCommandResult(commandOutput, command);
				}
			}
			scanner.close();
		} else {
			throw new Exception("Input file cannot be null. Please provide a valid file.");
		}
	}
}
