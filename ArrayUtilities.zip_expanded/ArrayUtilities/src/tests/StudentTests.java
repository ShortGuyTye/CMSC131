package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import sysImplementation.Utilities;

public class StudentTests {

	@Test
	public void test1() {
		int[] array = new int[] {5, 7, 8, 10, 20};
		String test = Utilities.getArrayString(array, ',');
		String answer = "5,7,8,10,20";
		System.out.println(test);
		System.out.println(answer);

		assertTrue(test.equals(answer));
	}
	@Test
	public void test2() {
		int[] array = null;
		String test;
		String answer = "";
		try {
			test = Utilities.getArrayString(array, ',');
			assertTrue(test.equals(answer));
		}
		catch (Exception e) {
			System.out.println("exception");
		}
	}
	@Test
	public void test3() {
		int[] array = new int[] {5, 7, 8, 10, 20};
		int test = Utilities.getInstances(array, 4, 9);
		int answer = 3;
		System.out.println(test);
		System.out.println(answer);
		assertTrue(test == answer);
		
	}
	@Test
	public void test4() {
		int[] array = new int[] {5, 7, 8, 10, 20};
		int[] test = Utilities.filter(array, 4, 9);
		int[] answer = new int[] {5,7,8};
		System.out.println(Utilities.getArrayString(test, ','));
		System.out.println(Utilities.getArrayString(answer, ','));
		assertTrue(Utilities.getArrayString(test, ',').equals(Utilities.getArrayString(answer, ',')));
	}
	@Test
	public void test5() {
		int[] array = new int[] {10,20,7,8};
		Utilities.rotate(array, true, 2);
		String answer = "7,8,10,20";
		System.out.println(Utilities.getArrayString(array, ','));
		System.out.println(answer);

		assertTrue(Utilities.getArrayString(array, ',').equals(answer));
	}
	@Test
	public void test6() {
		int[] array = new int[] {10,20,7,8};
		Utilities.rotate(array, false, 3);
		String answer = "20,7,8,10";
		System.out.println(Utilities.getArrayString(array, ','));
		System.out.println(answer);

		assertTrue(Utilities.getArrayString(array, ',').equals(answer));
	}
	@Test
	public void test7() {
		java.lang.StringBuffer[] array = new java.lang.StringBuffer[] {new StringBuffer("apple"),
				new StringBuffer("banana"), new StringBuffer("cherry"), new StringBuffer("date")};
		String answer = "[banana, cherry]";
		System.out.println(Arrays.toString(Utilities.getArrayStringsLongerThan(array, 5)));
		System.out.println(answer);
		assertTrue(Arrays.toString(Utilities.getArrayStringsLongerThan(array, 5)).equals(answer));
	}

}
