package CS251_HW3;

public class CardGameDriver {

	public static void main(String[] args) {

		for (int i = -1; i < 10; i++) {
			CardGame g1 = new CardGame(i);
			System.out.print("________________________________________");
			g1.resetDeck(); // make it so all cards available
			g1.dealHands(); // deal out hands to each player
			g1.displayHands();
			g1.dealHands(); // can not do this, will print error message
			g1.addPlayers(1);
			g1.displayHands();
		}

		CardGame g2 = new CardGame(3);
		System.out.print("________________________________________");
		g2.resetDeck(); // make it so all cards available
		g2.dealHands(); // deal out hands to each player
		g2.displayHands();
		g2.dealHands(); // can not do this, will print error message
		g2.addPlayers(-1);
		g2.displayHands();

	}
}
