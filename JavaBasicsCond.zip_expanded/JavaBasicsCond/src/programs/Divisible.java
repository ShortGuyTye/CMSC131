package programs;

import java.util.Scanner;

public class Divisible {

	public static void main(String[] args) {
		/* Write your program here */
		int x, y, remainder;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter x: ");
		x = scanner.nextInt();

		System.out.print("Enter y: ");
		y = scanner.nextInt();
		remainder = x % y;
		System.out.println("Remainder: " + remainder);

		if (remainder == 0) {
			System.out.print(x + " is divisible by " + y);
		} else {
			System.out.print(x + " is NOT divisible by " + y);
		}
		scanner.close();
	}
}