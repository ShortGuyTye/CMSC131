package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import sysImplementation.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnotherTest {

	@Test
	public void test1() {
		char[][] charArray = { 
				{ 'X', 'X', 'X', 'X' },
				{ 'B', 'X', 'X', 'X' },
				{ 'B', 'X', 'E', 'X' },
				{ 'X', 'C', 'X', 'X' },
		};

		String answer = getStringForArray(charArray);
		System.out.println(answer);

		int x = 0, y = 1;
		char target = 'X', replacement = '.';
		int replaced = Utilities.replaceCells(charArray, x, y, target, replacement);
		answer = getStringForArray(charArray);
		System.out.println(answer);
		System.out.println("Replaced: " + replaced);
	}

	/* Test Output 
	 
X X X X 
B X X X 
B X E X 
X C X X 

. . . . 
B . . . 
B . E . 
. C . . 

Replaced: 12
	 
	 */
	private static String getStringForArray(char[][] array) {
		StringBuffer answer = new StringBuffer();

		/* Notice how we can loop through the array */
		for (char[] row : array) {
			for (char entry : row) {
				answer.append(entry + " ");
			}
			answer.append("\n");
		}

		return answer.toString();
	}
}