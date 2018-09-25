package lab3;

public class Movie {
	// TODO
	// See handout
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

	public void setName(String name) {
		this.name = name;
	}

	public int getMinutes() {
		return this.minutes;
	}

	public void setMinutes(int minutes) {
		if (minutes < 0) {
			return;
		}
		this.minutes = minutes;
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

	public void display() {
		System.out.print("\nMovie: " + this.name);
		System.out.print("\nLength: " + this.minutes + " min.");
		if (isFresh() == false) {
			System.out.print("\nTomatoScore: Rotten!\n");
		} else {
			System.out.print("\nTomatoScore: Fresh!\n");
		}
	}
}
