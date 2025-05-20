package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import sysImplementation.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentTests {

	@Test
	public void test1() {
		String test = "Tye";
		System.out.println(Utilities.addDelimiter(test, ','));
		assertTrue(Utilities.addDelimiter(test, ',').equals("T,y,e"));
	}

	@Test
	public void test2() {
		String test = "T1y2e0";
		System.out.println(Utilities.getDigits(test));
		assertTrue(Utilities.getDigits(test).equals("120"));
	}

	@Test
	public void test3() {
		char[] test = new char[] { 'a', 'b', 'c', 'a' };
		Utilities.replaceCharacter(test, 'b', '1');
		System.out.println(Arrays.toString(test));
		assertTrue(true);
	}

	@Test
	public void test4() {
		int[] test = new int[] { 1, 2, 3, 4, 5, 6, 8 };
		int answer = Utilities.getSumEven(test);
		System.out.println(answer);
		assertTrue(answer == 20);
	}

	@Test
	public void test5() {
		int[][] test = new int[][] { { 1, 2, 3, 4, 5, 6, 8 }, { 2, 3, 4 }, { 1 }, {2}};
		ArrayList<Integer> answer = Utilities.getListRowIndices(test, 1);
		System.out.println(answer.toString());
		assertTrue(true);
	}
	@Test
	public void test6() {
		char[][] test = new char[][] {{'1','2','1'}, {'1','1','2'}, {'1','2','1'}};
		Utilities.replaceCells(test, 2, 0, '1', '3');
		System.out.println(Arrays.deepToString(test));
		assertTrue(true);
	}
}