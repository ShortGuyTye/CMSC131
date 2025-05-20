package programs;

import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		/* Write your program here */
		double base, height, area;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter base: ");
		base = scanner.nextInt();

		System.out.print("Enter height: ");
		height = scanner.nextInt();
		area = base * height * 0.5;
		System.out.print("Area is: " + area);

		scanner.close();
	}
}