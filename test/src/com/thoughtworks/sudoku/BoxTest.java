package com.thoughtworks.sudoku;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BoxTest {

	private Box box;

	@Before
	public void initlize() {
		box = new Box();
		box.initlize(new int[][] {
				{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{9, 8, 7, 6, 5, 4, 3, 2, 1},
				{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{9, 8, 7, 6, 5, 4, 3, 2, 1},
				{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{9, 8, 7, 6, 5, 4, 3, 2, 1},
				{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{9, 8, 7, 6, 5, 4, 3, 2, 1},
				{1, 2, 3, 4, 5, 6, 7, 8, 9} });
	}
	
	@Test
	public void rotate_two_lines() {
		box.rotateLines(0, 1);
		
		assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, box.getStatus()[0]);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, box.getStatus()[1]);
	}

	@Test
	public void rotate_multiple_lines() {
		box.rotateLines(new int[] {0, 1, 2}, new int[] {3, 4, 5});

		assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, box.getStatus()[0]);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, box.getStatus()[1]);
		assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, box.getStatus()[2]);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, box.getStatus()[3]);
		assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, box.getStatus()[4]);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, box.getStatus()[5]);
	}
	
	@Test
	public void rotate_two_columns() {
		box.rotateColumns(0, 1);

		assertEquals(2, box.getStatus()[0][0]);
		assertEquals(1, box.getStatus()[0][1]);
		assertEquals(8, box.getStatus()[1][0]);
		assertEquals(9, box.getStatus()[1][1]);
	}
	
	@Test
	public void rotate_multiple_columns() {
		box.rotateColumns(new int[] {0, 1, 2}, new int[] {3, 4, 5});

		assertEquals(4, box.getStatus()[0][0]);
		assertEquals(5, box.getStatus()[0][1]);
		assertEquals(6, box.getStatus()[0][2]);
		
		assertEquals(1, box.getStatus()[0][3]);
		assertEquals(2, box.getStatus()[0][4]);
		assertEquals(3, box.getStatus()[0][5]);
	}
	
}





























