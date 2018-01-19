package org.vik.gojek.challenge.parkinglot;

public class Car {

	private String color = null;
	private String registrationNumber = null;
	private ParkingTicket parkingTicket = null;

	public void setParkingTicket(ParkingTicket parkingTicket) {
		this.parkingTicket = parkingTicket;
	}

	public ParkingTicket getParkingTicket() {
		return parkingTicket;
	}

	public String getColor() {
		return color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public Car(String regNum, String string) {
		this.color = string;
		registrationNumber = regNum;
	}
}
