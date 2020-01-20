package college;

public enum Rank {
	FRESH("Freshman"),
	SOPHO("Sophomore"),
	JUNOR("Junior"),
	SENOR("Senior");
	
	private String rank;
	
	private Rank(String rank) {
		this.rank = rank;
	}
	
	public String toString() {
		return rank;
	}
}
