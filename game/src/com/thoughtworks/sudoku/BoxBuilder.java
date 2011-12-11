package com.thoughtworks.sudoku;

public class BoxBuilder {

	private final Box box;
	private final RotateStrategy rotateStratage;

	public BoxBuilder(Box box, RotateStrategy rotateStratage) {
		this.box = box;
		this.rotateStratage = rotateStratage;
	}

	public void rotate() {
		int[] rotateLines = this.rotateStratage.rotateLines();
		box.rotateLines(rotateLines[0], rotateLines[1]);
		
		rotateLines = this.rotateStratage.rotateLines();
		box.rotateLines(rotateLines[0] + 3, rotateLines[1] + 3);
		
		rotateLines = this.rotateStratage.rotateLines();
		box.rotateLines(rotateLines[0] + 6, rotateLines[1] + 6);

		int[] rotateColumns = this.rotateStratage.rotateColumns();
		box.rotateColumns(rotateColumns[0], rotateColumns[1]);
		
		rotateColumns = this.rotateStratage.rotateColumns();
		box.rotateColumns(rotateColumns[0] + 3, rotateColumns[1] + 3);
		
		rotateColumns = this.rotateStratage.rotateColumns();
		box.rotateColumns(rotateColumns[0] + 6, rotateColumns[1] + 6);
		
		int[] rotateLineGroups = this.rotateStratage.rotateLineGroups();
		int seed1 = (rotateLineGroups[0]) * 3;
		int seed2 = (rotateLineGroups[1]) * 3;
		box.rotateLines(new int[] {seed1, seed1+1, seed1+2}, new int[] {seed2, seed2+1, seed2+2});

		int[] rotateColumnGroups = this.rotateStratage.rotateLineGroups();
		int seed3 = (rotateColumnGroups[0]) * 3;
		int seed4 = (rotateColumnGroups[1]) * 3;
		box.rotateColumns(new int[] {seed3, seed3+1, seed3+2}, new int[] {seed4, seed4+1, seed4+2});

	}

}
