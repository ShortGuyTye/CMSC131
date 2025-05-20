package system;

public class CombineTopBottom implements Diagram{
	private int animationType;
	private char[][] board;

	public CombineTopBottom(Diagram top, Diagram bottom, int animationType) {
		this.animationType = animationType;
		if (top.getNumberCols() != bottom.getNumberCols()) {
			throw new IllegalArgumentException("Invalid number of cols");
		}
		board = TwoDimArrayUtil.appendTopBottom(top.getBoard(), bottom.getBoard());
	}
	public char[][] getBoard() {
		return board;
	}

	public int getNumberCols() {
		return board[0].length;
	}

	public int getNumberRows() {
		return board.length;
	}

	public char[][] nextAnimationStep() {
		if (animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn(board);
		}
		if (animationType == 2) {
			TwoDimArrayUtil.rotateTopOneRow(board);
		}
		return board;
	}

}
