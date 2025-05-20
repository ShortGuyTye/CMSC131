package sysImplementation;

public class Utilities {

	public static java.lang.String getArrayString(int[] array, char separator) {
		testNull(array);
		String answer = "";
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				answer += Integer.toString(array[i]);
			} else {
				answer += Integer.toString(array[i]) + separator;
			}
		}
		return answer;
	}

	public static int getInstances(int[] array, int lowerLimit, int upperLimit) {
		int count = 0;
		testNull(array);
		for (int i = 0; i < array.length; i++) {
			if ((array[i] <= upperLimit) && (array[i] >= lowerLimit)) {
				count++;
			}
		}
		return count;
	}

	public static int[] filter(int[] array, int lowerLimit, int upperLimit) {
		int counter = 0;
		int[] newArray = new int[getInstances(array, lowerLimit, upperLimit)];
		if (array == null) {
			throw new IllegalArgumentException("null array");
		}
		if (lowerLimit > upperLimit) {
			throw new IllegalArgumentException("invalid limits");
		}
		for (int i = 0; i < array.length; i++) {
			if ((array[i] <= upperLimit) && (array[i] >= lowerLimit)) {
				newArray[counter] = array[i];
				counter++;
			}
		}
		return newArray;
	}

	public static void rotate(int[] array, boolean leftRotation, int positions) {
		testNull(array);
		if (array.length < 2) {
			return;
		}
		if (leftRotation) {
			array = rotateLeft(array, positions);
		} else {
			array = rotateRight(array, positions);
		}

	}

	private static int[] rotateLeft(int[] array, int position) {
		int tempNum;
		for (int j = 0; j < position; j++) {
			tempNum = array[0];
			for (int i = 0; i < array.length; i++) {
				if (i != array.length - 1) {
					array[i] = array[i + 1];
				}
			}
			array[array.length - 1] = tempNum;
		}
		return array;
	}

	private static int[] rotateRight(int[] array, int position) {
		int tempNum;
		for (int j = 0; j < position; j++) {
			tempNum = array[array.length - 1];
			for (int i = array.length - 1; i >= 0; i--) {
				if (i != 0) {
					array[i] = array[i - 1];
				}
			}
			array[0] = tempNum;
		}
		return array;
	}

	public static java.lang.StringBuffer[] getArrayStringsLongerThan(java.lang.StringBuffer[] array, int length) {
		int count = 0;
		if (array == null) {
			throw new IllegalArgumentException("null array");
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() > length) {
				count++;
			}
		}
		java.lang.StringBuffer[] newArray = new java.lang.StringBuffer[count];
		count = 0;
		for (int j = 0; j < array.length; j++) {
			if (array[j].length() > length) {
				newArray[count] = array[j];
				count++;
			}
		}
		return newArray;
	}

	private static void testNull(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException("null array");
		}

	}
}