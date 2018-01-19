package org.vik.gojek.challenge.parkinglot.exceptions;

public class InvalidCommandParametersException extends Exception {

	private static final long serialVersionUID = -8137348657325489819L;

	private static String message = "Invalid number of parameters for command";

	public InvalidCommandParametersException() {
		super(message);
	}

	public InvalidCommandParametersException(String info) {
		super(message + ", Additional info: " + info);
	}

}
