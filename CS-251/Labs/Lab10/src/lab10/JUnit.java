package lab10;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnit {

	MovieCollection a;

	@Before
	public void setUp() {
		a = new MovieCollection();
	}

	Movie crazyRichAsians = new Movie("Crazy Rich Asians",120,93);
	Movie oceans8 = new Movie("Oceans 8",110,68);
	Movie happytimeMurders = new Movie("The Happytime Murders",91,22);

	@After
	public void tearDown(){
		a = null;

	}

	//TODO
	//Add three method calls to MovieCollection "a" that would throw each of the three exceptions you created.
	//Add try and test blocks for each of the three exceptions you created.
	//Output the correct message for each exception thrown to the console.
	@Test
	public void testExceptions() {

		a.addMovie(crazyRichAsians);
		a.addMovie(oceans8);
		a.addMovie(happytimeMurders);
		
		try {
			a.removeMovieAt(-1);
		}
		catch(InvalidRemoveMovieAtIndexException e) {
			System.out.println(e.getMessage());
			
		}
		
		try {
			a.addMovieAt(crazyRichAsians, -1);
		}
		catch(InvalidAddMovieAtException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			a.getMovieAt(-1);
		}
		catch(InvalidGetMovieAtException e) {
			System.out.println(e.getMessage());
		}

	}
}