package people;

public class Person {
	// VARIABLES
	protected String name;
	protected int age;
	protected String id;
	protected boolean willAttend;

	public String firstName;
	public String lastName;

	// CONSTRUCTORS

	public Person(Person other) {
		this(other.getName(), other.getAge(), other.getId(), other.isWillAttend());

	}

	public Person(String name, int age, String id, boolean willAttend) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.willAttend = willAttend;
	}

	// GETTERS
	public String getFirstName() {
		firstName = name.substring(0, name.indexOf(" "));
		return firstName;
	}

	public String getLastName() {
		lastName = name.substring(name.indexOf(" "), name.length());
		return lastName;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getId() {
		return id;
	}

	public boolean isWillAttend() {
		return willAttend;
	}

	// COMPARE PERSON OBJECTS
	public static int compareName(Person p1, Person p2) {
		String lastNameP1 = p1.getLastName();
		String lastNameP2 = p2.getLastName();
		int compare = lastNameP1.compareTo(lastNameP2);
		if (compare == 0) {
			String firstNameP1 = p1.getFirstName();
			String firstNameP2 = p2.getFirstName();
			compare = firstNameP1.compareTo(firstNameP2);
			// if first name is the same it will return 0 and then begin comparing age
			if (compare == 0) {
				int ageP1 = p1.getAge();
				int ageP2 = p2.getAge();
				compare = ageP1 - ageP2;
				if (compare == 0) {
//					compare = 0;
					return compare;
				}
			}
		}
		return compare;
	}

	@Override
	public boolean equals(Object object) {
		boolean flag = false;
		if (object instanceof Person) {
			Person other = (Person) object;
			if (this.name.equals(other.getName())) {
				if (this.age == other.getAge()) {
					if (this.id == other.getId()) {
						if (this.willAttend == other.willAttend) {
							flag = true;
						}
					}
				}
			}
		}
		return flag;
	}

	// FORMATTER
	@Override
	public String toString() {
		return ("\nName:  \t\t " + getFirstName() + "," + getLastName() + "\nAge: \t\t " + age + "\nID:  \t\t " + id
				+ "\nAttending Gala:\t " + String.valueOf(willAttend));
	}

	public String toFile() {
		String confirmation = "No";
		if (willAttend) {
			confirmation = "Yes";
		}
		return name + ", " + age + ", " + id + ", " + confirmation;
	}

//	@Override
//	public String toString() {
//		return String.format("Name:" + getFirstName() + ", " + getLastName() + "\n Age: \\t\\t" + " %d, %s, "
//				+ String.valueOf(willAttend), age, id);
//	}

}
