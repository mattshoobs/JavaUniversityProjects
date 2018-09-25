package lab3;


public class MovieDriver {

	public static void main (String [] args){

		Movie[] myCollection = new Movie[5];
		myCollection[0] = new Movie("Batman The Dark Knight", 152, 94);
		myCollection[1] = new Movie("Guardians of the Galaxy", 125, 91);
		myCollection[2] = new Movie("The GodFather", 178, 98);
		myCollection[3] = new Movie("Suicide Squad", 137, 27);

		//TODO
		//Initialize the variable below and add it to myCollection at index 4.
		//You can pick any movie you wish.
		Movie yourMovie = new Movie("Tangled", 100, 89);
		myCollection[4] =  yourMovie;


		System.out.println("Here are all the movies in my collection of movies.\n");
		for(int i = 0; i < myCollection.length; i++) {
			if(myCollection[i] != null)
				myCollection[i].display();
		}

		System.out.println("_______________________________________________");

		
		System.out.println("\nHere are the Fresh movies.");

		for(int i = 0; i < myCollection.length; i++) {
			if(myCollection[i] != null && myCollection[i].isFresh()) {
				System.out.println(myCollection[i].getName() + " is fresh.");
			}
		}

		System.out.println();
		System.out.println("Here are the Rotten movies.");

		for(Movie movieTmp: myCollection){
			if (movieTmp != null && !movieTmp.isFresh())
				System.out.println(movieTmp.getName() + " is rotten.");
		}

		System.out.println("_______________________________________________\n");
		
		Movie harryPotter = new Movie("Harry Potter and the Prisoner of Azkaban", 144, 91);
		System.out.println("The movie " + harryPotter.getName() + " was created.\n");
		
		System.out.println("Is " + harryPotter.getName() + " a long movie?");
		
		if(harryPotter.getMinutes() > 120) {
			System.out.println("Yes, it is a bit long.\n");
		} else {
			System.out.println("Nope, that isn't too bad.\n");
		}
		
		System.out.println("Can I set the minutes of " + harryPotter.getName() + " to a negative number?");
		harryPotter.setMinutes(-5);

		if(harryPotter.getMinutes() == -5) {
			System.out.println("It worked. The runtime is -5 minutes.\n");
		} else {
			System.out.println("It did NOT work.  Negative runtimes are not allowed.\n");
		}

		System.out.println("Can I set tomato score of " + harryPotter.getName() + " to a negative number?");
		harryPotter.setTomatoScore(-100);

		if(harryPotter.getTomatoScore() == -100) {
			System.out.println("It worked. The score is -100.  This movie is terrible according to the site.\n");
		} else {
			System.out.println("It did NOT work.  Negative scores are not allowed.\n");
		}
		
		System.out.println("Can I set tomato score of " + harryPotter.getName() + " to a number greater than 100?");
		harryPotter.setTomatoScore(101);

		if(harryPotter.getTomatoScore() == 101) {
			System.out.println("It worked. The score is 101.  Best Harry Potter movie ever!\n");
		} else {
			System.out.println("It did NOT work.  Still the best Harry Potter movie out all the movies though.\n");
		}


	}

}
