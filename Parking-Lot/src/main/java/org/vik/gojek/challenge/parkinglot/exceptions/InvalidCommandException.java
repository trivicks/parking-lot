package org.vik.gojek.challenge.parkinglot.exceptions;

public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = 9069330622536510903L;
	private static String message = "Invalid command";

	public InvalidCommandException() {
		super(message);
	}

	public InvalidCommandException(String info) {
		super(message + ", Additional info: " + info);
	}

}
