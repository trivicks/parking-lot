package org.vik.gojek.challenge.parkinglot.exceptions;

public class ParkingLotFullException extends Exception {

	private static final long serialVersionUID = 7252858283393414527L;

	public ParkingLotFullException() {
		super("Sorry, parking lot is full");
	}

}
