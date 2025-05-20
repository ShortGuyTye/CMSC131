package app;

import java.util.Random;

public class DrawingApp {
	/*
	 * For every method remove the line with "throw ..." and implement the method.
	 * We are using "throw..." so your code does not display any compilation errors
	 * when you import the zip file. Also, if you don't implement a method you will
	 * see a white square (instead of green) in the submit server
	 */
	public static String getRectangle(int maxRows, int maxCols, char symbol) {
		if (maxRows < 1 || maxCols < 1) {
			return null;
		}
		String rect = "";
		for (int row = 0; row < maxRows; row++) {
			for (int col = 0; col < maxCols; col++) {
				rect += symbol;
			}
			if (row != maxRows - 1) {
				rect += "\n";
			}
		}
		return rect;
	}

	public static String getFlag(int size, char color1, char color2, char color3) {
		String rect = "";
		int rowTri = size * 2;
		if (size < 3) {
			return null;
		}
		for (int row = 0; row < size * 2; row++) {
			rowTri--;
			for (int col = 0; col < size * 5; col++) {
				if (row >= col && row < size) {
					rect += color1;
				} else if (row >= size && rowTri >= col) {
					rect += color1;
				} else if (row == 0 || row == size * 2 - 1) {
					rect += color2;
				} else if (row == size || row == size - 1) {
					rect += color2;
				} else {
					rect += color3;
				}
			}
			if (row != size * 2 - 1) {
				rect += "\n";
			}
		}
		return rect;

	}

	public static String getHorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		String rect = "";
		int barNum = maxRows / bars, barCount = 0, barActual = maxRows % bars;
		barActual = maxRows - barActual;
		if (barNum >= 1 && isValidColor(color1) && isValidColor(color2) && isValidColor(color3)) {

			for (int row = 0; row < barActual; row++) {
				for (int col = 0; col < maxCols; col++) {
					if (barCount <= barNum - 1) {
						rect += color1;
					} else if (barCount <= 2 * barNum - 1) {
						rect += color2;
					} else if (barCount <= 3 * barNum - 1) {
						rect += color3;
					} else if (barCount > 3 * barNum - 1) {
						barCount = 0;
						rect += color1;
					}
				}
				if (row != barActual - 1) {
					rect += "\n";
				}
				barCount++;
			}
			return rect;
		}
		return null;
	}

	public static String getVerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		String rect = "";
		int barNum = maxCols / bars, barCount = 0, barActual = maxCols % bars;
		barActual = maxCols - barActual;
		if (barNum >= 1 && isValidColor(color1) && isValidColor(color2) && isValidColor(color3)) {
			for (int row = 0; row < maxRows; row++) {
				for (int col = 0; col < barActual; col++) {
					if (barCount <= barNum - 1) {
						rect += color1;
					} else if (barCount <= 2 * barNum - 1) {
						rect += color2;
					} else if (barCount <= 3 * barNum - 1) {
						rect += color3;
					} else {
						barCount = 0;
						rect += color1;
					}
					barCount++;
				}
				if (row != maxRows - 1) {
					rect += "\n";
					barCount = 0;
				}
			}
			return rect;
		}
		return null;
	}

	public static char getRandomColor(Random random) {
		int rand = random.nextInt(6);
		if (rand == 0) {
			return 'R';
		} else if (rand == 1) {
			return 'G';
		} else if (rand == 2) {
			return 'B';
		} else if (rand == 3) {
			return 'Y';
		} else if (rand == 4) {
			return '*';
		} else if (rand == 5) {
			return '.';
		}
		return 'X';
	}

	private static boolean isValidColor(char color) {
		if (color == 'R' || color == 'G' || color == 'B' || color == 'Y' || color == '*' || color == '.') {
			return true;
		}
		return false;
	}
}