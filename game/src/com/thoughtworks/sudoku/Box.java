package com.thoughtworks.sudoku;

public class Box {

	private int[][] status;

	public void initlize(int[][] status) {
		this.status = status;
	}

	public int[][] getStatus() {
		return status;
	}

	public void rotateLines(int lineIndex, int anotherLineIndex) {
		int[] tmp = status[lineIndex];
		status[lineIndex] = status[anotherLineIndex];
		status[anotherLineIndex] = tmp;
	}

	public void rotateLines(int[] lineIndies, int[] otherLineIndies) {
		for(int i = 0; i < lineIndies.length; i++) {
			rotateLines(lineIndies[i], otherLineIndies[i]);
		}
	}

	public void rotateColumns(int columnIndex, int anotherColumnIndex) {
		for (int[] line : status) {
			int tmp = line[columnIndex];
			line[columnIndex] = line[anotherColumnIndex];
			line[anotherColumnIndex] = tmp;
		}
	}

	public void roateColumns(int[] columnIndies, int[] otherColumnIndies) {
		for (int i = 0; i < columnIndies.length; i++) {
			rotateColumns(columnIndies[i], otherColumnIndies[i]);
		}
	}

}
