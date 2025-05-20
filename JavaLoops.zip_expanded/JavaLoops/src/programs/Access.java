package programs;

import java.util.Scanner;

public class Access {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String password;
		int number, attempts = 3;
		while (attempts != 0) {
			System.out.print("Enter password: ");
			password = scanner.next();
			if (password.equals("quit")) {
				System.out.print("Access Denied");
				break;
			}
			System.out.print("Enter number: ");
			number = scanner.nextInt();
			if (password.equals("terps") && number == 1847) {
				System.out.println("Access Granted");
				break;

			} else {
				System.out.println("Wrong credentials");
				attempts--;
			}
		}
		if (attempts == 0) {
			System.out.print("Access Denied");
		}
		scanner.close();
	}
}
