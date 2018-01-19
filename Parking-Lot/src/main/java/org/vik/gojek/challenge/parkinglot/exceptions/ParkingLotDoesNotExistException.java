package org.vik.gojek.challenge.parkinglot.exceptions;

public class ParkingLotDoesNotExistException extends Exception {

	private static final long serialVersionUID = -1781365932189263846L;

	private static String message = "Create a parking lot before attempting to runs other commands.";

	public ParkingLotDoesNotExistException() {
		super(message);
	}

	public ParkingLotDoesNotExistException(String info) {
		super(message + ", Additional info: " + info);
	}

}
