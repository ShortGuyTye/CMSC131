package programs;

import java.util.Scanner;
import java.util.Random;

public class ThrowDie {
	public static void main(String[] args) {
		int rolls, seed, die;
		char dot = '0', space = '.', symbol;
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many times to throw a die?: ");
		rolls = scanner.nextInt();
		System.out.print("Enter seed: ");
		seed = scanner.nextInt();
		Random random = new Random(seed);
		for (int k = 0; k < rolls; k++) {
			die = random.nextInt(6) + 1;
			System.out.println("Throw #" + (k + 1));
			if (die == 1) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (i == 1 && j == 1) {
							symbol = dot;
						} else {
							symbol = space;
						}
						System.out.print(symbol);

					}
					System.out.println("");
				}
			} else if (die == 2) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if ((i == 0 && j == 0) || (i == 2 && j == 2)) {
							symbol = dot;
						} else {
							symbol = space;
						}
						System.out.print(symbol);

					}
					System.out.println("");
				}

			} else if (die == 3) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (i == j) {
							symbol = dot;
						} else {
							symbol = space;
						}
						System.out.print(symbol);

					}
					System.out.println("");
				}

			} else if (die == 4) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if ((i == 0 || i == 2) && j % 2 == 0) {
							symbol = dot;
						} else {
							symbol = space;
						}
						System.out.print(symbol);

					}
					System.out.println("");
				}

			} else if (die == 5) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if ((i == 0 || i == 2) && j % 2 == 0) {
							symbol = dot;

						} else if (i == 1 && j == 1) {
							symbol = dot;
						} else {

							symbol = space;
						}
						System.out.print(symbol);

					}
					System.out.println("");

				}
			} else if (die == 6) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (j == 0 || j == 2) {
							symbol = dot;
						} else {
							symbol = space;
						}
						System.out.print(symbol);

					}
					System.out.println("");
				}

			}
		}
		scanner.close();
	}
}
