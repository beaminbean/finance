package finance;

import java.util.Scanner;

// (extends means) - PaidAdvisor inherits all attributes and methods from Person
public class PaidAdvisor extends Person {

	// Class (static - class variable, not an instance attribute, stays with the
	// class) final (CONSTANT)
	private static final double REGULAR_PAY_RATE = 25;
	private static final double SPECIAL_PAY_RATE = 50;
	private static final double OVERTIME_HOURS = 30;
	private static final double OVERTIME_RATE = 1.5;

	// object variables
	private double regularPayRate = REGULAR_PAY_RATE;
	private double specialPayRate = SPECIAL_PAY_RATE;
	private double overtimePayRate = 0;
	private double hoursWorked = 0;
	private double hoursSpecial = 0;
	private Person person = null;

	// Constructor with parameters
	public PaidAdvisor(Person person, double rate, double hoursWorked, double hoursSpecial) {
		setNameRateHours(person, rate, hoursWorked, hoursSpecial);
	}

	// Constructor with hours parameters
	public PaidAdvisor(double hoursWorked, double hoursSpecial) {

		// go with defaults and hours are passed
		this(new Person("No First", "No Last"), REGULAR_PAY_RATE, hoursWorked, hoursSpecial);
	}

	// Default Constructor
	public PaidAdvisor() {

		// go with defaults if no parameters are passed
		this(new Person("No First", "No Last"), REGULAR_PAY_RATE, 0, 0);
	}

	// Define the method, calculatePay() , that calculates the multiplication of the
	// pay rate (the regular pay rate and the overtime pay rate) and the hours
	// worked
	public double calculatePay() {

		double regular = 0;
		double overtime = 0;
		double special = 0;

		if (hoursWorked <= OVERTIME_HOURS) {
			regular = this.regularPayRate * this.hoursWorked;
			special = this.specialPayRate * this.hoursSpecial;

		} else {
			regular = this.regularPayRate * OVERTIME_HOURS;
			overtime = this.overtimePayRate * (this.hoursWorked - OVERTIME_HOURS);
			special = this.specialPayRate * this.hoursSpecial;
		}

		// return calculated pay of all work types
		return regular + overtime + special;
	}

	// Define the method, getPayRate() , that returns either of the pay rates
	// (regular or overtime)
	public double getPayRate(String payRateType) {

		if (payRateType.equals("regular")) {
			return this.regularPayRate;
		} else if (payRateType.equals("overtime")) {
			return this.overtimePayRate;
		} else if (payRateType.equals("special")) {
			return this.specialPayRate;
		}

		// return 0 if none of the payRateType are received
		return 0;
	}

	// Define the method, getHoursWorked(), that returns the hours worked
	public String getHoursWorked() {
		return ("Hours Worked: " + hoursWorked + " Hours Special: " + hoursSpecial);
	}

	// Define the method, setNameRateHours(), that sets the name, rate and
	// hours for the research consultant
	public void setNameRateHours(Person person, double rate, double hoursWorked, double hoursSpecial) {

		this.person = person;

		this.regularPayRate = rate;
		this.overtimePayRate = rate * OVERTIME_RATE;

		this.hoursWorked = hoursWorked;
		this.hoursSpecial = hoursSpecial;
	}

	// Define the method, toString(), that returns the wages based on the method,
	// calculatePay()
	public String toString() {
		return "Wages for employee " + person.getFirstName() + " " + person.getLastName() + " are: " + calculatePay();
	}

	public static void main(String args[]) {

		// get input from keyboard
		Scanner scanner = new Scanner(System.in);

		// get user input from keyboard
		System.out.println("Please enter the First Name: ");
		String fname = scanner.nextLine();
		System.out.println("Please enter the Last Name: ");
		String lname = scanner.nextLine();
		System.out.println("Please enter the Rate: ");
		double rate = scanner.nextDouble();
		System.out.println("Please enter the Hours Worked: ");
		double hours = scanner.nextDouble();
		System.out.println("Please enter the Hours Special Worked: ");
		double hoursSpecial = scanner.nextDouble();

		// subtract special hours to hours worked
		hours -= hoursSpecial;

		// close out scanner
		scanner.close();

		// call Person Constructor and generate person object with first and last name
		Person person = new Person(fname, lname);

		System.out.println("\nNo Argument Constructor");

		// call PaidAdvisor Constructor with no arguments
		PaidAdvisor paidAdvisor = new PaidAdvisor();

		// print results
		System.out.println("paidAdvisor.getHoursWorked: " + paidAdvisor.getHoursWorked());
		System.out.println("paidAdvisor.calculatePay: " + paidAdvisor.calculatePay());
		System.out.println("paidAdvisor.getPayRate(regular): " + paidAdvisor.getPayRate("regular"));
		System.out.println("paidAdvisor.getPayRate(overtime): " + paidAdvisor.getPayRate("overtime"));
		System.out.println("paidAdvisor.getPayRate(special): " + paidAdvisor.getPayRate("special"));
		System.out.println("paidAdvisor.toString: " + paidAdvisor.toString());

		System.out.println("\nPaid Hours Argument Constructor");

		// call PaidAdvisor Constructor with hours arguments
		paidAdvisor = new PaidAdvisor(40, 5);

		// print results
		System.out.println("paidAdvisor.getHoursWorked: " + paidAdvisor.getHoursWorked());
		System.out.println("paidAdvisor.calculatePay: " + paidAdvisor.calculatePay());
		System.out.println("paidAdvisor.getPayRate(regular): " + paidAdvisor.getPayRate("regular"));
		System.out.println("paidAdvisor.getPayRate(overtime): " + paidAdvisor.getPayRate("overtime"));
		System.out.println("paidAdvisor.getPayRate(special): " + paidAdvisor.getPayRate("special"));
		System.out.println("paidAdvisor.toString: " + paidAdvisor.toString());

		System.out.println("\nFull Argument Constructor");

		// call PaidAdvisor Constructor and pass in values from user input
		paidAdvisor = new PaidAdvisor(person, rate, hours, hoursSpecial);

		// print results
		System.out.println("paidAdvisor.getHoursWorked: " + paidAdvisor.getHoursWorked());
		System.out.println("paidAdvisor.calculatePay: " + paidAdvisor.calculatePay());
		System.out.println("paidAdvisor.getPayRate(regular): " + paidAdvisor.getPayRate("regular"));
		System.out.println("paidAdvisor.getPayRate(overtime): " + paidAdvisor.getPayRate("overtime"));
		System.out.println("paidAdvisor.getPayRate(special): " + paidAdvisor.getPayRate("special"));
		System.out.println("paidAdvisor.toString: " + paidAdvisor.toString());
	}
}
