package sysutilities;

public class Driver {
	public static void main(String[] args) {
		Address address1 = new Address("popo ln", "buenos aires", "arg", "000232");
		Address address2 = new Address();
		System.out.println(address1.getZipcode());
		System.out.println(address2);
	}
}
