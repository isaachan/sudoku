package com.thoughtworks.sudoku;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoxBuilderTest {

	@Test
	public void rotate_box() {
		FakeBox box = new FakeBox();
		BoxBuilder boxBuilder = new BoxBuilder(box, new FakeRotateStrategy());
		boxBuilder.rotate();
		
		String oneRotation = "rl(0,1)|rl(3,4)|rl(6,7)|rc(0,1)|rc(3,4)|rc(6,7)|" + 
							 "rl([0,1,2],[3,4,5])|" +
							 "rc([0,1,2],[3,4,5])|";
		String boxRotationLog = 
				oneRotation + oneRotation;
		
		assertEquals(boxRotationLog, box.log);
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

		@Override
		public void rotateLines(int[] lineIndies, int[] otherLineIndies) {
			log += "rl(" + convertString(lineIndies) + "," + convertString(otherLineIndies) + ")|";
		}
		
		@Override
		public void rotateColumns(int[] columnIndies, int[] otherColumnIndies) {
			log += "rc(" + convertString(columnIndies) + "," + convertString(otherColumnIndies) + ")|";
		}

		private String convertString(int[] otherLineIndies) {
			String string = "";
			for(int i : otherLineIndies) string += "," + i;
			return "[" + string.substring(1) + "]";
		}
		
	}

	class FakeRotateStrategy extends RotateStrategy {

		@Override
		public int rotateTimes() {
			return 2;
		}
		
		@Override
		public int[] rotateLines() {
			return new int[] {0, 1};
		}

		@Override
		public int[] rotateColumns() {
			return new int[] {0, 1};
		}

		@Override
		public int[] rotateLineGroups() {
			return new int[] {0, 1};
		}
		
		@Override
		public int[] rotateColumnGroups() {
			return new int[] {0, 1};
		}
	}
	
}

