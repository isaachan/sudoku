package com.thoughtworks.sudoku;


import static org.junit.Assert.*;

import org.junit.Test;

public class BoxBuilderTest {

	@Test
	public void rotate_box() {
		FakeBox box = new FakeBox();
		BoxBuilder boxBuilder = new BoxBuilder(box, new FakeRotateStrategy());
		boxBuilder.rotate();
		
		assertEquals("rl(0,1)|rl(3,4)|rl(6,7)|rc(0,1)|rc(3,4)|rc(6,7)|", box.log);
	}
	
	class FakeBox extends Box {

		public String log = "";

		@Override
		public void rotateLines(int lineIndex, int anotherLineIndex) {
			log += "rl(" + lineIndex + "," + anotherLineIndex + ")|";
		}
		
		@Override
		public void rotateColumns(int columnIndex, int anotherColumnIndex) {
			log += "rc(" + columnIndex + "," + anotherColumnIndex + ")|";
		}
		
	}

	class FakeRotateStrategy extends RotateStrategy {

		@Override
		public int[] rotateLines() {
			return new int[] {0,1};
		}
		

		@Override
		public int[] rotateColumns() {
			return new int[] {0,1};
		}
		
	}
	
}

