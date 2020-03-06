package people;

public class Visiter extends Person implements Comparable<Visiter> {
	private ArrivalTime time;

	// CONSTRUCTORS
	public Visiter(Visiter other) {
		this(other.getName(), other.getAge(), other.getId(), other.isWillAttend(),

				new ArrivalTime(other.time.getHour(), other.time.getMinutes(), other.time.getTimePeriod()));
	}

	public Visiter(String name, int age, String id, Boolean WillAttend, ArrivalTime time) {
		super(name, age, id, WillAttend);
		this.time = time;
	}

	// Compares the last name first, then first name
	public static int compareName(Visiter v1, Visiter v2) {
		int compare = v1.lastName.compareTo(v2.lastName);

		if (compare == 0) {
			compare = v1.firstName.compareTo(v2.firstName);
			if (compare == 0) {
				return compare;
			}
		}
		return compare;
	}

	@Override
	// compares this object to other object in natural order
	public int compareTo(Visiter other) {
		int compVisiters = this.time.compareTo(other.time);

		if (compVisiters == 0) {
			compVisiters = this.lastName.compareTo(other.lastName);
			if (compVisiters == 0) {
				compVisiters = this.firstName.compareTo(other.firstName);
				if (compVisiters == 0) {
					compVisiters = this.age - other.age;
					if (compVisiters == 0) {
						return 0;
					}
				}
			}
		}
		return compVisiters;
	}

	// checks if this object equals to other object
	@Override
	public boolean equals(Object other) {
		boolean flag = false;
		if (other instanceof Visiter) {
			Visiter visiter = (Visiter) other;
			boolean parentCheck = super.equals(visiter);

			if (parentCheck == true) {
				if (this.time.getHour() == visiter.time.getHour()) {
					if (this.time.getMinutes() == visiter.time.getMinutes()) {
						flag = true;
					}
				}
			}
		}
		return flag;
	}

	// FORMATTERS
	// returns a string in a comma separated output
	@Override
	public String toFile() {
		return super.toFile() + ", " + time.toFile();
	}

	// returns a string of employee in pretty print
	@Override
	public String toString() {
		return super.toString() + "\nArrival Time: \t " + time.toString();
	}

}
