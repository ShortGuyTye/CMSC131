package app;

public class DrawingAppDriver {

	public static void main(String [] args) {
		String rect;
		rect = DrawingApp.getHorizontalBars(10, 12, 9, '*', '.', 'Y');
		System.out.println(rect);
	}
}
