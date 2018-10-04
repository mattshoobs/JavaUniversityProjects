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
		
	}
	
	public boolean equals(Object other) {
		
	}
}
