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
	}

}
