package programs;

import java.util.Scanner;

public class Convert {

	public static void main(String[] args) {
		int decimal, dividend = 1, remainder;
		String octal = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter decimal number: ");
		decimal = scanner.nextInt();
		remainder = decimal;
		while (dividend != 0) {
			remainder = decimal % 8;
			octal = remainder + octal;
			dividend = (decimal - remainder) / 8;
			decimal = dividend;
		}
		System.out.print("Octal value: " + octal);
	}
}
