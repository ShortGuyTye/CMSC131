package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import programs.Passport;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {
	/*
	 * Each method in a JUnit StudentTest class represents a test. You can write
	 * code in a method of this class as you do in the main method of a driver. 
	 * As you write your code, define methods in this class that test each of 
	 * the methods you need to implement. When you run a method you can have 
	 * System.out.println statements to see the results of your code. Using 
	 * this approach is simpler than defining driver classes.
	 * 
	 * For this project you don't need to worry about adding assertions (we will
	 * talk about them soon). If you don't add assertions, by default, every test
	 * will pass (so when you run your student tests you will see a green bar).  
	 * We have left two examples of tests below so you can see how you can test
	 * your code.
	 * 
	 * You can run a single test (e.g., testingtoString() below) by double-clicking
	 * on the method's name and selecting Run-->Run As-->JUnit Test.  You can also
	 * double-click on the method's name and select the white triangle that is inside
	 * of a green circle (under Navigate menu entry).
	 */
	
	@Test
	public void testingtoString() {
		Passport passport1 = new Passport("Rose", "Sanders");
		System.out.println(passport1);
	}

	@Test
	public void testingSetSeparator() {
		Passport passport1 = new Passport("Tom", "Johnson");
		System.out.println(passport1);
		
		passport1.setSeparator('#');
		System.out.println(passport1);
	}
}