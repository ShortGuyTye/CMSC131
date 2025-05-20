package system;

public class TwoDimArrayUtil {

	public static char[][] appendLeftRight(char[][] left, char[][] right) {
		if (left == null || right == null) {
			throw new IllegalArgumentException("Invalid parameter appendLeftRight");
		}
		int rows;
		boolean isLeftSmaller = false;
		if (left.length > right.length) {
			rows = left.length;
		} else {
			rows = right.length;
			isLeftSmaller = true;
		}
		char[][] answer = new char[rows][];
		for (int i = 0; i < answer.length; i++) {
			char[] temp;
			if (i >= left.length && isLeftSmaller == true) {
				temp = new char[right[i].length];
				for (int j = 0; j < temp.length; j++) {
					temp[j] = right[i][j];
				}
			}
			else if (i >= right.length && isLeftSmaller == false) {
				temp = new char[left[i].length];
				for (int j = 0; j < temp.length; j++) {
					temp[j] = left[i][j];
				}
			} else {
				temp = new char[left[i].length + right[i].length];
				for (int j = 0; j < temp.length; j++) {
					if (j < left[i].length) {
						temp[j] = left[i][j];
					} else {
						temp[j] = right[i][j - left[i].length];
					}
				}
			}
			answer[i] = temp;
		}

		return answer;
	}

	public static char[][] appendTopBottom(char[][] top, char[][] bottom) {
		if (top == null || bottom == null) {
			throw new IllegalArgumentException("Invalid parameter appendTopBottom");
		}
		char[][] answer = new char[top.length + bottom.length][];
		for (int i = 0; i < answer.length; i++) {
			char[] topTemp;
			char[] bottomTemp;
			if (i < top.length) {
				topTemp = new char[top[i].length];
				for (int j = 0; j < top[i].length; j++) {
					topTemp[j] = top[i][j];
				}
				answer[i] = topTemp;
			} else {
				bottomTemp = new char[bottom[i - top.length].length];
				for (int j = 0; j < bottom[i - top.length].length; j++) {
					bottomTemp[j] = bottom[i - top.length][j];
				}
				answer[i] = bottomTemp;
			}

		}
		return answer;
	}

	public static boolean isRagged(char[][] array) {
		if (array == null) {
			throw new IllegalArgumentException("Invalid parameter isRagged");
		}
		for (int i = 0; i < array.length; i++) {
			if (array[0].length != array[i].length) {
				return true;
			}
		}
		return false;
	}

	public static void rotateLeftOneColumn(char[][] array) {
		if (array == null || isRagged(array)) {
			throw new IllegalArgumentException("Invalid parameter rotateLeftOneColumn");
		}
		if (array[0].length == 1 || array[0].length == 0) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			char temp = array[i][0];
			for (int j = 0; j < array[i].length; j++) {
				if (j == array[i].length - 1) {
					array[i][j] = temp;
				} else {
					array[i][j] = array[i][j + 1];
				}
			}
		}
	}

	public static void rotateTopOneRow(char[][] array) {
		if (array == null || isRagged(array)) {
			throw new IllegalArgumentException("Invalid parameter rotateTopOneRow");
		}
		if (array.length == 1 || array.length == 0) {
			return;
		}
		char[] temp = array[0];
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				array[i] = temp;
			} else {
				array[i] = array[i + 1];
			}
		}
	}
}
