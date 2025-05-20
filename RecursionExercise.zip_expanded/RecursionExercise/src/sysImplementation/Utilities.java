package sysImplementation;

import java.util.ArrayList;

public class Utilities {

	public static String addDelimiter(String str, char delimeter) {
		String answer = "";
		if (str.length() != 0) {
			answer += str.charAt(0);
			if (str.length() != 1) {
				answer += delimeter;
			}
			return answer + addDelimiter(str.substring(1, str.length()), delimeter);
		} else {
			return answer;
		}
	}

	public static String getDigits(String str) {
		String answer = "";
		if (str.length() != 0) {
			if (str.charAt(0) == '0' || str.charAt(0) == '1' || str.charAt(0) == '2' || str.charAt(0) == '3'
					|| str.charAt(0) == '4' || str.charAt(0) == '5' || str.charAt(0) == '6' || str.charAt(0) == '7'
					|| str.charAt(0) == '8' || str.charAt(0) == '9') {
				answer += str.charAt(0);
			}
			return answer + getDigits(str.substring(1, str.length()));
		} else {
			return answer;
		}
	}

	public static void replaceCharacter(char[] array, char target, char replacement) {
		replaceCharacterAuxilery(array, target, replacement, 0);
	}

	private static void replaceCharacterAuxilery(char[] array, char target, char replacement, int counter) {
		if (counter < array.length) {
			if (array[counter] == target) {
				array[counter] = replacement;
			}
			replaceCharacterAuxilery(array, target, replacement, counter + 1);
		}
	}

	public static int getSumEven(int[] array) {
		return getSumEvenAuxilery(array, 0);
	}

	private static int getSumEvenAuxilery(int[] array, int counter) {
		int sum = 0;
		if (counter < array.length) {
			if (array[counter] % 2 == 0) {
				sum = array[counter];
			}
			return sum + getSumEvenAuxilery(array, counter + 1);
		}
		return sum;
	}

	public static ArrayList<Integer> getListRowIndices(int[][] array, int rowLength) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		return getListRowIndicesAuxilery(array, rowLength, answer, 0);

	}

	private static ArrayList<Integer> getListRowIndicesAuxilery(int[][] array, int rowLength,
			ArrayList<Integer> arraylist, int counter) {
		if (counter < array.length) {
			if (array[counter].length == rowLength) {
				arraylist.add(counter);
			}
			return (getListRowIndicesAuxilery(array, rowLength, arraylist, counter + 1));
		}
		return arraylist;
	}

	public static int replaceCells(char[][] array, int x, int y, char target, char replacement) {
		int counter = 0;
		if (XYExist(array, x, y) && array[x][y] == target) {
			array[x][y] = replacement;
			counter = counter + 1;
			if (XYExist(array, x + 1, y) && array[x + 1][y] == target) {
				counter += replaceCells(array, x + 1, y, target, replacement);
			}
			if (XYExist(array, x - 1, y) && array[x - 1][y] == target) {
				counter += replaceCells(array, x - 1, y, target, replacement);
			}
			if (XYExist(array, x, y + 1) && array[x][y + 1] == target) {
				counter += replaceCells(array, x, y + 1, target, replacement);
			}
			if (XYExist(array, x, y - 1) && array[x][y - 1] == target) {
				counter += replaceCells(array, x, y - 1, target, replacement);
			}

			if (XYExist(array, x + 1, y + 1) && array[x + 1][y + 1] == target) {
				counter += replaceCells(array, x + 1, y + 1, target, replacement);
			}
			if (XYExist(array, x - 1, y + 1) && array[x - 1][y + 1] == target) {
				counter += replaceCells(array, x - 1, y + 1, target, replacement);
			}
			if (XYExist(array, x + 1, y - 1) && array[x + 1][y - 1] == target) {
				counter += replaceCells(array, x + 1, y - 1, target, replacement);
			}
			if (XYExist(array, x - 1, y - 1) && array[x - 1][y - 1] == target) {
				counter += replaceCells(array, x - 1, y - 1, target, replacement);
			}
			return counter;
		}
		return 0;
	}

	private static boolean XYExist(char[][] array, int x, int y) {
		if (x >= 0 && x < array.length && y >= 0 && y < array[x].length) {
			return true;
		}
		return false;
	}
}
