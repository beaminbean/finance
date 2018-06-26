package finance;

public class Person {

	private String firstName = ""; // store the first name
	private String lastName = ""; // store the last name

	// Default constructor
	public Person() {
		firstName = "";
		lastName = "";
	}

	// Constructor with parameters
	public Person(String first, String last) {
		setName(first, last);
	}

	// Method to output the first name and last name
	public String toString() {
		return (firstName + " " + lastName);
	}

	// Method to set firstName and lastName
	public void setName(String first, String last) {
		firstName = first;
		lastName = last;
	}

	// Method to return the firstName
	public String getFirstName() {
		return firstName;
	}

	// Method to return the lastName
	public String getLastName() {
		return lastName;
	}
}
