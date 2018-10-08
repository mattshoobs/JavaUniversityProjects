package CS251_HW4;

public class MovieCollection {

	private Movie[] movies;
	private int movieCount;

	public MovieCollection() {
		movies = new Movie[10];
	}

	public int getTotalMovies() {

		return this.movieCount;
	}

	/**
	 * @param movie
	 * @return boolean
	 */
	public boolean addMovie(Movie movie) {
		if (movie == null || this.movieCount >= 10) {
			System.out.print("Error - You have 10 movies. Please Remove a movie before adding one.");
			return false;
		}
		for (int i = 0; i < movieCount; i++) {
			Movie m = movies[i];
			if (m == null || m.equals(movie)) {
				System.out.print("Error - movie alreay exists or movie is undefined.");
				return false;

			}
		}
		movies[this.movieCount] = movie;
		movieCount++;
		return true;

	}

	/**
	 * @param movie
	 * @param index
	 * @return boolean
	 */
	public boolean addMovieAt(Movie movie, int index) {

		if (index < 0 || index >= 10 || index > movieCount || movieCount == 10) {
			System.out.print("Error - Index is not in range, or movies are full.");
			return false;
		}
		for (int i = 0; i < movieCount; i++) {
			Movie m = movies[i];
			if (m == null || m.equals(movie)) {
				System.out.print("Error - movie alreay exists or movie is undefined.");
				return false;

			}
		}
		if (movies[index] != null) {

			shiftCollectionRight(index);
		}

		movies[index] = movie;
		movieCount++;
		return true;
	}

	/**
	 * @param index
	 */
	private void shiftCollectionRight(int index) {
		for (int i = movieCount - 1; i >= index; i--) {
			movies[i + 1] = movies[i];

		}

	}

	/**
	 * @param movie
	 * @return int
	 */
	public int findMovie(Movie movie) {

		for (int i = 0; i < movieCount; i++) {
			Movie temp = movies[i];
			if (movie.equals(temp)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param index
	 * @return Movie
	 */
	public Movie getMovieAt(int index) {
		if (index < 0 || index >= 10) {
			return null;
		}
		return movies[index];
	}

	/**
	 * @param movie
	 * @return boolean
	 */
	public boolean removeMovie(Movie movie) {

		if (movie == null) {
			System.out.print("Error - Invalid Movie.");
			return false;
		}
		boolean movieRemoved = false;
		for (int i = 0; i < movieCount; i++) {
			Movie m = movies[i];
			if (m != null && m.equals(movie)) {
				movieRemoved = true;

				shiftCollectionLeft(i);

			}
		}
		if (movieRemoved) {
			movieCount--;
			return true;
		}
		return false;
	}

	/**
	 * @param index
	 * @return Movie
	 */
	public Movie removeMovieAt(int index) {

		if (index < 0 || index >= 10 || index > movieCount) {
			System.out.print("Error - Index is not in range.");
			return null;
		}

		Movie m = movies[index];
		if (m != null) {
			Movie retval = new Movie(m.getName(), m.getMinutes(), m.getTomatoScore());
			shiftCollectionLeft(index);
			movieCount--;
			return retval;

		}

		return null;
	}

	/**
	 * @param index
	 */
	private void shiftCollectionLeft(int index) {

		for (int i = index; i < movieCount; i++) {
			if (i == movieCount - 1) {
				movies[i] = null;
				continue;

			}
			movies[i] = movies[i + 1];
		}
	}

	/**
	 * Find the best movie according to Rotten Tomato score and return it. If the
	 * array is empty, meaning there are no movies, it returns null.
	 * 
	 * @return Movie or null
	 */
	public Movie findBestMovie() {
		Movie highScore = null;
		for (int i = 0; i < movieCount; i++) {
			Movie m = movies[i];
			if (m == null) {
				continue;
			}
			if (highScore == null || m.getTomatoScore() > highScore.getTomatoScore()) {
				highScore = m;
			}

		}
		return highScore;
	}

	/**
	 * Print out all movies that are considered rotten in the array. Remember you
	 * can use methods in the Movie class to determine this. Refer to driver and
	 * handout for output format.
	 * 
	 */
	public void moviesToAvoid() {
		int badMovies = 1;
		for (int i = 0; i < movieCount; i++) {
			Movie m = movies[i];

			if (m == null) {
				continue;
			}
			if (!m.isFresh()) {
				System.out.print("Movie " + (badMovies) + ":\n");
				System.out.print(m.toString());
				badMovies++;
			}

		}
	}

	/**
	 * Print out all movies that are considered fresh in the array. Remember you can
	 * use methods in the Movie class to determine this. Refer to driver and handout
	 * for output format.
	 * 
	 */
	public void moviesToWatch() {
		int goodMovies = 1;
		for (int i = 0; i < movieCount; i++) {
			Movie m = movies[i];

			if (m == null) {
				continue;
			}
			if (m.isFresh()) {
				System.out.print("Movie " + (goodMovies) + ":\n");
				System.out.print(m.toString());
				goodMovies++;
			}
		}

	}

	/**
	 * Print out all movies in the array. You only need to print out the name of the
	 * movie, nothing more. Refer to driver and handout for output format.
	 * 
	 */
	public void printOutMovieList() {

		for (int i = 0; i < movieCount; i++) {
			Movie m = movies[i];

			if (m == null) {
				continue;
			}

			System.out.print("Movie " + (i + 1) + ":" + m.getName() + "\n");

		}

	}

}
