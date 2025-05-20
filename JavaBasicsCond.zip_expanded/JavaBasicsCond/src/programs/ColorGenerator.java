package programs;

import java.util.Scanner;

public class ColorGenerator {

	public static void main(String[] args) {
		/*
		 * Do you want red? (Yes/Yeah/No): No Do you want green and blue? (Yes/Yeah/No):
		 * Yes Final Color: #00FFFF
		 */
		String red, gandb, finalColor;
		String yes = "Yes";
		String yeah = "Yeah";
		String color = "#";
		Scanner scanner = new Scanner(System.in);

		System.out.print("Do you want red? (Yes/Yeah/No): ");
		red = scanner.nextLine();
		System.out.print("Do you want green and blue? (Yes/Yeah/No): ");
		gandb = scanner.nextLine();

		if (red.equals(yes) || red.equals(yeah)) {
			color = color + "FF";
		} else {
			color = color + "00";
		}
		if (gandb.equals(yes) || gandb.equals(yeah)) {
			color = color + "FFFF";
		} else {
			color = color + "0000";
		}

		System.out.print("Final Color: " + color);
		scanner.close();
	}
}