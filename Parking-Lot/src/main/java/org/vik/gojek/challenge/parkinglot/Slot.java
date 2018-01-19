package org.vik.gojek.challenge.parkinglot;

public class Slot {

	private Integer slotNumber = null;

	public Car getParkedCar() {
		return parkedCar;
	}

	public void setParkedCar(Car parkedCar) {
		this.parkedCar = parkedCar;
	}

	public Integer getSlotNumber() {
		return slotNumber;
	}

	private Car parkedCar = null;

	public Slot(Integer slotNumber) {
		this.slotNumber = slotNumber;
	}

}
