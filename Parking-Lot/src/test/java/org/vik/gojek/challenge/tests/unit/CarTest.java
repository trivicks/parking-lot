package org.vik.gojek.challenge.tests.unit;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.Car;

public class CarTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testCarDefaults() {
		String regNum = "KA-01-ML-9999";
		String color = "Blue";
		Car car = new Car(regNum, color);
		assertTrue("RegNo Initialization issues with car", regNum.equalsIgnoreCase(car.getRegistrationNumber()));
		assertTrue("Color Initialization issues with car", color == car.getColor());
	}

}
