package org.vik.gojek.challenge.parkinglot;

import java.util.ArrayList;
import java.util.Iterator;

import org.vik.gojek.challenge.parkinglot.exceptions.ParkingLotFullException;

public class ParkingLot {

	private ArrayList<Slot> parkingSlots = null;
	private Integer capacity = 0;
	private Integer availableCapacity = 0;
	private static ParkingLot instance = null;

	public Integer getAvailableCapacity() {
		return availableCapacity;
	}

	public Integer getNumberOfCarsParked() {
		return capacity - availableCapacity;
	}

	public ArrayList<Slot> getParkingSlots() {
		return parkingSlots;
	}

	public static ParkingLot getInstance(Integer capacity) {
		if (instance == null) {
			return new ParkingLot(capacity);
		} else {
			return instance;
		}
	}

	private ParkingLot(Integer capacity) {
		this.capacity = capacity;
		this.availableCapacity = capacity;
		parkingSlots = new ArrayList<Slot>(capacity);
		for (int i = 0; i < capacity; i++) {
			Slot slot = new Slot(i + 1);
			parkingSlots.add(slot);
		}
	}

	private Integer getNearestAvailableSlot() throws Exception {
		Iterator<Slot> iterator = parkingSlots.iterator();
		while (iterator.hasNext()) {
			Slot slot = iterator.next();
			if (slot.getParkedCar() == null) {
				return slot.getSlotNumber();
			}
		}
		throw new ParkingLotFullException();
	}

	private ParkingTicket issueTicket(Car car) throws Exception {
		Integer freeSlotNumber = getNearestAvailableSlot();
		ParkingTicket ticket = new ParkingTicket(freeSlotNumber, car.getRegistrationNumber());
		availableCapacity--;
		return ticket;
	}

	public boolean isParkingLotFull() {
		if (availableCapacity == 0)
			return Boolean.TRUE;
		else
			return Boolean.FALSE;

	}

	private void returnTicket(Integer slotNumber) {
		parkingSlots.get(slotNumber - 1).setParkedCar(null);
		availableCapacity++;
		// Since we are not storing returned ticket information, we are not recording
		// OUT time.
	}

	public ParkingTicket park(Car car) throws Exception {
		ParkingTicket ticket = issueTicket(car);
		car.setParkingTicket(ticket);
		parkingSlots.get(ticket.getSlotNumber() - 1).setParkedCar(car);
		return ticket;
	}

	public void leave(Integer slotNumber) {
		returnTicket(slotNumber);
	}

	public ArrayList<String> fetchRegNumsByColor(String color) {
		ArrayList<String> regNums = new ArrayList<String>();
		Iterator<Slot> iterator = parkingSlots.iterator();
		while (iterator.hasNext()) {
			Slot slot = iterator.next();
			if (slot.getParkedCar() != null && slot.getParkedCar().getColor().equalsIgnoreCase(color)) {
				regNums.add(slot.getParkedCar().getRegistrationNumber());
			}
		}
		return regNums;
	}

	public ArrayList<String> fetchSlotNumsByColor(String color) {
		ArrayList<String> slotNums = new ArrayList<String>();
		Iterator<Slot> iterator = parkingSlots.iterator();
		while (iterator.hasNext()) {
			Slot slot = iterator.next();
			if (slot.getParkedCar() != null && slot.getParkedCar().getColor().equalsIgnoreCase(color)) {
				slotNums.add(slot.getSlotNumber().toString());
			}
		}
		return slotNums;
	}

	public Integer fetchSlotNumByRegNum(String regnum) {
		Iterator<Slot> iterator = parkingSlots.iterator();
		Integer slotnum = -1;
		while (iterator.hasNext()) {
			Slot slot = iterator.next();
			if (slot.getParkedCar() != null && slot.getParkedCar().getRegistrationNumber().equalsIgnoreCase(regnum)) {
				slotnum = slot.getSlotNumber();
			}
		}
		return slotnum;
	}

}
