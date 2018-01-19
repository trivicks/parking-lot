package org.vik.gojek.challenge.tests.integration;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.vik.gojek.challenge.parkinglot.interpreter.FileCommandInterpreter;

public class CommandInterpreterTest {

	@Test
	public void testFileInput() throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file_inputs.txt").getFile());
		FileCommandInterpreter cmdInt = new FileCommandInterpreter(file);
		cmdInt.run();
		String output = cmdInt.getResult();
		assertTrue(output, output.equalsIgnoreCase("Created a parking lot with 6 slots\n" + "Allocated slot number: 1\n"
				+ "Allocated slot number: 2\n" + "Allocated slot number: 3\n" + "Allocated slot number: 4\n"
				+ "Allocated slot number: 5\n" + "Allocated slot number: 6\n" + "Slot number 4 is free\n"
				+ "Slot No.	Registration No	Colour\n" + "1	KA-01-HH-1234	White\n" + "2	KA-01-HH-9999	White\n"
				+ "3	KA-01-BB-0001	Black\n" + "5	KA-01-HH-2701	Blue\n" + "6	KA-01-HH-3141	Black\n"
				+ "Allocated slot number: 4\n" + "Sorry, parking lot is full\n"
				+ "KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333\n" + "1, 2, 4\n" + "6\n" + "Not found"));
	}

}
