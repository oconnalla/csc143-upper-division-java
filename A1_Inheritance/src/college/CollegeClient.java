package college;

public class CollegeClient {

	public static void print(Person person) {
		System.out.println(person);
		System.out.println("--------------------------------------------");
		System.out.println("Who am I? \t" + person.getClass());
		System.out.println("Classification? \t" + person.classification());
		System.out.println();
	}
	
	public static void main(String[] args) {
		Person finnegan   = new Person("Finnegan Wolf", 19);
		Person aethelfeld = new Person("Aethelfeld Eastwick", 22);
		Person jessica    = new Person("Jessica Lemon", 37);
		Student jupiter	  = new Student("Jupiter Jones", 22, Rank.SOPHO, Major.PHYS, 3.4);
		Student finn      = new Student(finnegan, Rank.SOPHO, Major.ENGR, 3.3);
		Student aethel    = new Student(aethelfeld, Rank.JUNOR, Major.CPSC, 3.6);
		
		Employee jess     = new Employee(jessica, "STEM 207", 52125.0, 11.5);
		Employee john	  = new Employee("John Wick", 45, "STEM-100", 75000.0, 20.0 );
		
		//property1
		//System.out.println(jess.getName());
		//System.out.println(john.getName());

		//property2
		System.out.println("Installments: " + john.payments());
		
		//property3
		System.out.println(jessica.classification()); //Person
		System.out.println(jess.classification()); //EMPLOYEEE
		System.out.println(jupiter.classification()); //STUDENT/		
		
		
		System.out.println(finn);
		System.out.println();
		System.out.println(aethel);
		System.out.println();
		print(jess);
		System.out.println();
		print(jupiter);
	}

}
