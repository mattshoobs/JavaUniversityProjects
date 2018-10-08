package CS251_HW4;

public class Movie {

	private String name = null;
	private int minutes = 0;
	private int tomatoScore = 0;

	// Constructor
	public Movie(String name, int minutes, int tomatoScore) {
		this.name = name;
		this.minutes = minutes;
		this.tomatoScore = tomatoScore;
	}

	public String getName() {
		return this.name;
	}

	public int getMinutes() {
		return this.minutes;
	}

	public int getTomatoScore() {
		return this.tomatoScore;
	}

	public void setTomatoScore(int tomatoScore) {
		if (tomatoScore < 0 || tomatoScore > 100) {
			return;
		}
		this.tomatoScore = tomatoScore;
	}

	public boolean isFresh() {
		return (this.tomatoScore > 60);
	}

	public String toString() {
		String fresh = this.isFresh() ? "Fresh" : "Rotten";
		return "Name: " + this.name + "\n Length: " + this.convertMin() + "\n" + "Tomato Score: " + fresh + "\n";
	
	}
	
	private String convertMin() {
		int hours = this.minutes/ 60;
		int min = this.minutes - 60*hours;
		return hours + " hrs " + min + " min";
	}
	
	public boolean equals(Object other) {
		if (other instanceof Movie) {
			Movie movie = (Movie) other;
			if (movie != null && movie.getName().equalsIgnoreCase(this.name) && movie.getMinutes() == this.minutes) {
				return true;
			}
		}
		return false;
	}
}
