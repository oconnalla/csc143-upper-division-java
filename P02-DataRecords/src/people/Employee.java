package people;

public class Employee extends Person implements Comparable<Employee> {
	private final String office;
	private final double salary;
	private final int years;

	// CONSTRUCTOR
	public Employee(Employee other) {
		super(other.name, other.getAge(), other.getId(), other.isWillAttend());
		this.office = other.office;
		this.salary = other.salary;
		this.years = other.years;
	}

	public Employee(Builder builder) {
		super(builder.name, builder.age, builder.id, builder.willAttend);
		this.office = builder.office;
		this.salary = builder.salary;
		this.years = builder.years;
	}

	// GETTERS
	public String getOffice() {
		return this.office;
	}

	public double getSalary() {
		return this.salary;
	}

	public int getYears() {
		return this.years;
	}

	public double payments() {
		return ((this.salary / 12) / 2);
	}

	// ranking by salary, then by name, age and service
	public int rankSalary() {
		return 1;
	}

	// ranking by years of service, then name, salary, age
	public int rankYears() {
		return 1;
	}

	// compares the salary of two employee objects
	public static int compareSalary(Employee e1, Employee e2) {
		if ((e1.salary - e2.salary) < 0) {
			return -1;
		} else if ((e1.salary - e2.salary) == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	// Compares this employee to other employee in natural order
	// ford demo
	@Override
	public int compareTo(Employee other) {
		if (!name.equals(other.name)) {
			return name.compareTo(other.name);
//		} else if (!lastName.equals(other.lastName)) {
//			return lastName.compareTo(other.lastName);
//		} else if (!firstName.equals(other.firstName)) {
//			return firstName.compareTo(firstName);
		} else if (years - other.years != 0) {
			return years - other.years;
		} else if (salary - other.salary != 0) {
			return (Double.compare(salary, other.salary));
		}
		return age - other.age;
	}

	// calculates the difference between two employees salary
	public static int rankSalary(Employee e1, Employee e2) {
		int diffSalary = (int) (e1.salary - e2.salary);
		return diffSalary;
	}

	// calculates the difference in service years
	public static int rankYears(Employee e1, Employee e2) {
		int diffYears = e1.age - e2.age;
		return diffYears;
	}

	// FORMATTERS
	// return a string in a comma separated output
	@Override
	public String toFile() {
		return super.toFile() + ", " + office + ", " + salary + ", " + years + ", " + payments();
	}

	// returns a string of employee in pretty print
	@Override
	public String toString() {
		return super.toString() + "\nOffice:\t\t " + office + "\nSalary:\t\t " + salary + "\nService:\t " + years
				+ "\nBi-Mothly:\t " + payments() + "\n";
	}

	@Override
	// checks if this object equals to another employee object
	public boolean equals(Object other) {
		boolean flag = false;
		if (other instanceof Employee) {
			Employee otherEmployee = (Employee) other;
			boolean parentCheck = super.equals(other);
			// check the parent for equal content
			if (parentCheck == true) {
				// if salary is the same
				if (this.salary == otherEmployee.salary) {
					// if office is the same
					if (this.office.equals(otherEmployee.office)) {
						// if the years are the same
						if (this.years == otherEmployee.years) {
							flag = true;
						}
					}
				}
			}
		}
		return flag;
	}

	// NESTED CLASS
	public static class Builder {
		private String office;
		private double salary;
		private int years;

		private String name;
		private int age;
		private String id;
		private boolean willAttend;

		public Builder()
		// Default VALUES
		{
			name = "N/A N/A";
			age = 0;
			id = "unassigned";
			willAttend = false;
			office = "Unassigned";
			salary = 0.0;
			years = 0;
		}

		// SETTERS
		public Builder setOffice(String office) {
			this.office = office;
			return this;
		}

		public Builder setSalary(double salary) {
			this.salary = salary;
			return this;
		}

		public Builder setYears(int years) {
			this.years = years;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Builder setWillAttend(boolean willAttend) {
			this.willAttend = willAttend;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}

}
