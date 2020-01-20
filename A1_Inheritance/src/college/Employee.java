package college;

public class Employee extends Person{

	private String office;
	private double salary;
	private double years;
	
	public Employee(Employee other) {
		this(other.getName(), other.getAge(), other.office, other.salary, other.years);
	}
	
	public Employee(Person person, String office, double salary, double years) {
		this(person.getName(), person.getAge(), office, salary, years);
	}
	
	public Employee(String name, int age, String office, double salary, double years) {
		super(name, age);
		this.office = office;
		this.salary = salary;
		this.years  = years;
	}
	
	public String classification( ) {
		return "Employee";
	}

	public String getOffice() {
		return office;
	}

	public double getSalary() {
		return salary;
	}

	public double getYears() {
		return years;
	}

	public double payments() {
		return salary / 24;
	}
	
	public String toString( ) {
		String _office 		= 	String.format("Office: \t %s \n", office);
		String _salary 		= 	String.format("Salary: \t %.2f \n", salary);
		String _years 		= 	String.format("Service: \t %.1f \n", years);
		String _payments 	= 	String.format("Bi-Monthly: \t %.2f \n", payments());
		
		return super.toString() + _office + _salary + _years + _payments;
	}
	
}
