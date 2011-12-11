package com.thoughtworks.sudoku;

public class BoxBuilder {

	private final Box box;
	private final RotateStrategy rotateStratage;

	public BoxBuilder(Box box, RotateStrategy rotateStratage) {
		this.box = box;
		this.rotateStratage = rotateStratage;
	}

	public void rotate() {
		int rotationTimes = this.rotateStratage.rotateTimes();
		for (int i = 0; i < rotationTimes; i++) {
			rotateOnce();
		}
	}

	private void rotateOnce() {
		rotateLines();
		rotateColumns();
		rotateGroups();
	}

	private void rotateGroups() {
		rotateLineGroups();
		rotatColumnGroups();
	}

	private void rotatColumnGroups() {
		int[][] rotatedGroupIndies = getRotatedGroupIndies();
		box.rotateColumns(rotatedGroupIndies[0], rotatedGroupIndies[1]);
	}

	private void rotateLineGroups() {
		int[][] rotatedGroupIndies = getRotatedGroupIndies();
		box.rotateLines(rotatedGroupIndies[0], rotatedGroupIndies[1]);
	}

	private int[][] getRotatedGroupIndies() {
		int[] rotateColumnGroups = this.rotateStratage.rotateColumnGroups();
		int seed1 = (rotateColumnGroups[0]) * 3;
		int seed2 = (rotateColumnGroups[1]) * 3;
		return new int[][] {new int[] {seed1, seed1+1, seed1+2}, new int[] {seed2, seed2+1, seed2+2}};
	}
	
	private void rotateColumns() {
		for (int i = 0; i < 7; i += 3) {
			int[] rotateColumns = this.rotateStratage.rotateColumns();
			box.rotateColumns(rotateColumns[0] + i, rotateColumns[1] + i);
		}
	}

	private void rotateLines() {
		for (int i = 0; i < 7; i += 3) {
			int[] rotateLines = this.rotateStratage.rotateLines();
			box.rotateLines(rotateLines[0] + i, rotateLines[1] + i);
		}
	}

}
