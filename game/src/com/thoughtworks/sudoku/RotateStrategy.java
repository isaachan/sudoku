package com.thoughtworks.sudoku;

import java.util.Random;

public class RotateStrategy {

	private final Random randomGenerator = new Random();

	public int[] rotateLines() {
		return new int[] { generateDigitBetweenZeroAndTwo(), generateDigitBetweenZeroAndTwo() };
	}

	private int generateDigitBetweenZeroAndTwo() {
		return randomGenerator.nextInt(2);
	}

	public int[] rotateColumns() {
		return new int[] { generateDigitBetweenZeroAndTwo(), generateDigitBetweenZeroAndTwo() };
	}
	
	public int[] rotateLineGroups() {
		return new int[] { generateDigitBetweenZeroAndTwo(), generateDigitBetweenZeroAndTwo() };
	}

	public int[] rotateColumnGroups() {
		return new int[] { generateDigitBetweenZeroAndTwo(), generateDigitBetweenZeroAndTwo() };
	}

	public int rotateTimes() {
		return randomGenerator.nextInt(9) + 1;
	}
	
}
