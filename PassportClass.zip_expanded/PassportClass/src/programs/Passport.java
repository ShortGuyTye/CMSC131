package programs;

//import examples.Building;

/**
 * This class represents a person's passport. It has three instance variables
 * representing the first, last and middle name (all are String variables). A
 * character instance variable representing a separator (to be used for
 * formatting purposes) is also part of the class. In addition, the class has a
 * StringBuffer instance variable that represents the passport stamps the person
 * has received.
 * 
 * For this class you need to define and use a private method called
 * validateAndFormat that takes a string as a parameter.
 * 
 * The class will keep track of the number of instances created by using a
 * private static field called objectCount.
 * 
 * @author CS
 *
 */
public class Passport {
	private String firstname, middlename, lastname;
	private char separator = ',';
	private StringBuffer stamps = new StringBuffer();
	private static int objectCount;

	public Passport(String firstname, String middlename, String lastname) {
		this.firstname = validateAndFormat(firstname);
		this.middlename = validateAndFormat(middlename);
		this.lastname = validateAndFormat(lastname);
		objectCount++;
	}

	public String toString() {
		if (middlename == null) {
			String output = lastname + separator + firstname;
			return output;
		}
		String output = lastname + separator + firstname + separator + middlename;
		return output;
	}

	public Passport(String firstname, String lastname) {
		this.firstname = validateAndFormat(firstname);
		this.lastname = validateAndFormat(lastname);
		objectCount++;
	}

	public Passport() {
		this("Samplefirstname", "Samplemiddlename", "SampleLastname");
	}

	public Passport(Passport passport) {
		this.firstname = passport.firstname;
		this.middlename = passport.middlename;
		this.lastname = passport.lastname;
		this.separator = passport.separator;
		this.stamps = new StringBuffer(passport.getStamps());
		
	}

	public Passport addStamp(String stamp) {
		stamps = stamps.append(stamp);
		return this;
	}

	public StringBuffer getStamps() {
		StringBuffer stampsCopy = new StringBuffer(stamps);
		return stampsCopy;
	}

	public char getSeparator() {
		return separator;
	}

	public boolean setSeparator(char separator) {
		if (separator == '@' || Character.isSpaceChar(separator) || Character.isLetter(separator)) {
			return false;
		}
		this.separator = separator;
		return true;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Passport obj1 = (Passport) obj;
		if (this.firstname.equals(obj1.firstname) && this.middlename.equals(obj1.middlename)
				&& this.lastname.equals(obj1.lastname)) {
			return true;
		}
		return false;
	}

	public int compareTo(Passport passport) {
		if (this.firstname == null) {
			return -1;
		} else if (passport.firstname == null) {
			return 1;
		} else if (this.lastname.compareTo(passport.lastname) < 0) {
			return -1;
		} else if (this.lastname.compareTo(passport.lastname) > 0) {
			return 1;
		} else if (this.lastname.compareTo(passport.lastname) == 0) {
			if (this.lastname == null) {
				return -1;
			} else if (passport.lastname == null) {
				return 1;
			} else if (this.firstname.compareTo(passport.firstname) < 0) {
				return -1;
			} else if (this.firstname.compareTo(passport.firstname) > 0) {
				return 1;
			} else if (this.firstname.compareTo(passport.firstname) == 0) {
				if (this.middlename == null) {
					return -1;
				} else if (passport.middlename == null) {
					return 1;
				} else if (this.middlename.compareTo(passport.middlename) < 0) {
					return -1;
				} else if (this.middlename.compareTo(passport.middlename) > 0) {
					return 1;
				} else if (this.middlename.compareTo(passport.middlename) == 0) {
					return 0;
				}
			}
		}
		return 2;
	}

	public static int getNumberOfPassportObjects() {
		return objectCount;
	}

	public static void resetNumberOfPassportObjects() {
		objectCount = 0;
	}

	public static Passport normalize(Passport passport, boolean uppercase) {
		if (passport == null) {
			return null;
		} else if (uppercase) {
			Passport newPassPort = new Passport();
			newPassPort.firstname = passport.firstname.toUpperCase();
			newPassPort.middlename = passport.middlename.toUpperCase();
			newPassPort.lastname = passport.lastname.toUpperCase();
			newPassPort.setSeparator(passport.getSeparator());
			return newPassPort;
		} else {
			Passport newPassPort = new Passport();
			newPassPort.firstname = passport.firstname.toLowerCase();
			newPassPort.middlename = passport.middlename.toLowerCase();
			newPassPort.lastname = passport.lastname.toLowerCase();
			newPassPort.setSeparator(passport.getSeparator());
			return newPassPort;
		}
	}

	public boolean changeLastname(String lastname) {
		if (validateAndFormat(lastname) == null) {
			return false;
		}
		this.lastname = validateAndFormat(lastname);
		return true;
	}

	/*
	 * This method will generate and return a formatted string in lowercase with the
	 * first character in uppercase. The parameter is valid if it is not null and it
	 * is not blank according to the string method isBlank(). If the parameter is
	 * invalid, the method will return null and perform no further processing. If
	 * the parameter is valid, spaces surrounding the parameter will be removed, the
	 * string will be converted to lowercase, and the first character of the string
	 * (after spaces have been removed) will be in upper case. The following methods
	 * can be helpful during the implementation of this method:
	 * Character.toUpperCase, and the string methods charAt and substring.
	 * 
	 * You can test this method by initially defining it public; once you have
	 * tested it, make it private.
	 * 
	 */
	private static String validateAndFormat(String name) {
		if (name == null || name.isBlank()) {
			return null;
		}
		name = name.trim();
		String fixedName = name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
		return fixedName;
	}
}
