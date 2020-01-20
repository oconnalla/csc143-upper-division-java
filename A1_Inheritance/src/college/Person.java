package college;

public class Person {

	private String name;
	private int    age;
	
	public Person(Person other){
		this(other.name, other.age);
	}
	
	public Person( String name, int age){
		this.name = name;
		this.age =  age;
	}
	
	public String classification( ) {
		return "College";
	}
	
	public int getAge() {
		return age;
	}

	public String getName( ) {
		return name;
	}
	
	public String toString( ) {
		String _name 		= 	String.format("Name: \t \t %s \n", getName());
		String _age 		= 	String.format("Age:  \t \t %d \n", getAge());
		
		return _name + _age;
	}
		
}
