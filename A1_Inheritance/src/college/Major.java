package college;

public enum Major {
	
	PHYS("Physics"), 
	ASTR("Astronomy"), 
	CPSC("Computer Science"), 
	ENGR("Engineering");
	
	private String major;
	
	private Major(String major) {
		this.major = major;
	}
	
	public String toString() {
		return major;
	}
}
