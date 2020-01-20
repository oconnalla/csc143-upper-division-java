package college;

public class Student extends Person{
	
	private double gpa;
	private Major  major;
	private Rank   rank;
	
	public Student(Student other) {
		this(other.getName(), other.getAge(), other.rank, other.major, other.gpa);
	}
	
	public Student(Person person, Rank rank, Major major, double gpa) {
		this(person.getName(), person.getAge(), rank, major, gpa);
	}
	
	public Student(String name, int age, Rank rank, Major major, double gpa) {
		super(name, age);
		this.gpa   = gpa;
		this.major = major;
		this.rank  = rank;
	}
	
	public String classification( ) {
		return "Student";
	}
	
	public Major getMajor() {
		return major;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public double getGPA() {
		return gpa;
	}
			
	public String toString( ) {
				
		return  super.toString()    +
			    "Rank: \t \t" 		+ rank   + "\n" +
			    "Major:\t \t" 		+ major  + "\n" +
			    "GPA:  \t \t" 		+ gpa    + "\n" ;
	}
}
