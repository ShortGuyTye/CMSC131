package sysutilities;

public class Address {
	private String state, city, street, zipcode;

	public Address(String street, String city, String state, String zipcode) {
		state = state.trim();
		city = city.trim();
		street = street.trim();
		zipcode = zipcode.trim();
		if (state == null || city == null || street == null || zipcode == null) {
			throw new IllegalArgumentException("Invalid Address Argument");
		}
		for (int i = 0; i < zipcode.length(); i++) {
			char digit = zipcode.charAt(i);
			if (!Character.isDigit(digit)) {
				throw new IllegalArgumentException("Invalid Address Argument");
			}
		}
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	public Address() {
		this("8223 Paint Branch Dr.","College Park","MD","20742");
	}
	public Address(Address address) {
		this.state = address.state;
		this.city = address.city;
		this.street = address.street;
		this.zipcode = address.zipcode;
		
	}
	public Address(String street) {
		state = "MD";
		city = "College Park";
		zipcode = "20742";
		street = street .trim();
		if (street == null) {
			throw new IllegalArgumentException("Invalid Address Argument");
		}else {
			this.street = street;
		}
	}
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}else if (this.getClass() != obj.getClass()) {
			return false;
		}
		Address obj1 = (Address) obj;
		if (this.street.equals(obj1.street) && this.city.equals(obj1.city)
				&& this.state.equals(obj1.state)&& this.zipcode.equals(obj1.zipcode)) {
			return true;
		}
		return false;
	}
	public String toString() {
		String string = street + " " + city + " " + state + " " + zipcode;
		return string;
	}
}