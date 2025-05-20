package system;

import app.DrawingApp;
import gui.BoardCell;

public class HorizontalBars implements Diagram{
	private int animationType;
	private char[][] board;

	public HorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3,
			int animationType) {
		this.animationType = animationType;
		board = BoardCell.getCharArray(DrawingApp.getHorizontalBars(maxRows, maxCols, bars, color1, color2, color3));
	}
	
	public char[][] getBoard(){ 
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
			TwoDimArrayUtil.rotateTopOneRow(board);
		}
		return board;
	}
}
