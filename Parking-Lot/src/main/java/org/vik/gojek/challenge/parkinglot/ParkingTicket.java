package org.vik.gojek.challenge.parkinglot;

import java.util.Date;

public class ParkingTicket {

	private Integer slotNumber = null;
	private String registrationNumber = null;
	private Date inTime = null;
	private Date outTime = null;

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public Date getInTime() {
		return inTime;
	}

	public Integer getSlotNumber() {
		return slotNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public ParkingTicket(Integer slotNumber, String regNum) {
		this.slotNumber = slotNumber;
		this.registrationNumber = regNum;
		this.inTime = new Date();
	}

}
