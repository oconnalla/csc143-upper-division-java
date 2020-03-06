package people;

public class ArrivalTime implements Comparable<ArrivalTime> {
	// FIELDS
	private int hour;
	private int minutes;
	private String timePeriod;

	// CONSTRUCTOR
	public ArrivalTime(int hour, int minutes, String timePeriod) {
		this.hour = hour;
		this.minutes = minutes;
		this.timePeriod = timePeriod;
	}

	// GETTERS
	public int getHour() {
		return hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	@Override
	// compares this time to other time
	public int compareTo(ArrivalTime other) {
		if (!other.timePeriod.equals(this.timePeriod)) {
			if (this.timePeriod.equalsIgnoreCase("AM")) {
				return -1;
			}
			return 1;
		}
		// compare hour
		int diffHour = this.getHour() - other.getHour();
		if (diffHour != 0) {
			return diffHour;
		}

		// compare minutes
		int diffMin = this.getMinutes() - other.getMinutes();
		if (diffMin != 0) {
			return diffMin;
		}
		return 0;
	}

	// checks if this arrival time equals other arrivaltime
	@Override
	public boolean equals(Object other) {
		boolean flag = false;
		if (other instanceof ArrivalTime) {
			ArrivalTime time = (ArrivalTime) other;
			if (this.timePeriod.equals(time.getTimePeriod())) {
				if (this.hour == time.getHour() && this.minutes == time.getMinutes()) {
					flag = true;
				}
			}
		}
		return flag;
	}

	// File FORMATTERS
	// return a string in a comma separated output
	public String toFile() {
		// need to add 0 if minutes is less than 10
		if (minutes < 10) {
			return (hour + ", 0" + minutes + ", " + timePeriod + "\n");
		} else {
			return (hour + ", " + minutes + ", " + timePeriod + "\n");
		}
	}

	// returns a string of employee in pretty print
	@Override
	public String toString() {
		if (minutes < 10) {
			return (hour + ":" + "0" + minutes + " " + timePeriod + "\n");
		} else {
			return (hour + ":" + minutes + " " + timePeriod + "\n");
		}
	}

}
