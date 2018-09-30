package CS251_HW3;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CardGame {

	private static final String[] cardNumbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private static final String[] cardSuits = {"D","H","C","S"};
    private static final int DEFAULT_PLAYERS = 2;
	
	private boolean deck[];
	private String[][] players;
	private int cardsdealt;
	private boolean hasDealtCards;
	

	public CardGame (int totalPlayers) {
		totalPlayers          = totalPlayers <= 8 && totalPlayers >= 2 ? totalPlayers : DEFAULT_PLAYERS;
		this.players          = totalPlayers;
		this.deck             = new boolean[52];
		this.players          = new String[totalPlayers][5];
		this.cardsdealt       = 0;
		this.resetDeck(this.deck);
	}

    /**
     * Private setter for hasCardsDealt
     * @param hasDealtCards
     */
    private void setHasDealtCards(boolean hasDealtCards) {
        this.hasDealtCards = hasDealtCards;
    }

    /**
	 * Reset the deck for the next round.
	 * Think of this as collecting all the cards.
	 * A card is in the deck if it's value is true.
	 * 
	 * @param boolean [] deck
	 */
	public static void resetDeck(boolean[] deck){	

	    Arrays.fill(deck, Boolean.FALSE);
	    this.setHasDealtCards(false);
	}

	
	/**
	 * Deal out the cards to each player.
	 * The 2D String array called players will hold the card values.
	 * See the assignment description for a visual of how this will work.
	 * You will need to call dealCard and use a double for loop to fill the 2D String array.
	 * 
	 * @param players
	 * @param deck
	 */
	public static void dealHands(String[][] players, boolean[] deck){
		
		for(int i = 0; i<players.length; i++){
			for(int k = 0; k<players[i].length; k++){
				 players[i][k] = dealCard(deck);	
			}
		}
	}

	
	/**
	 * Deal one card from the deck.
	 * Use the boolean array to tell if a card has been dealt yet.
	 * You will need to call convertCard to convert the index of an available card to it's correct card representation.
	 * You will need to use a random number generator to simulate an actual shuffled deck.
	 * Remember, Math.random() returns a number from 0 to .99999....
	 * 
	 * @param deck
	 * @return String
	 */
	public static String dealCard(boolean[] deck){
			
		while(true){
		    int tempCard = ThreadLocalRandom.current().nextInt(0, 52);
		    if(deck[tempCard] == true)
		        return convertCard(tempCard);
		}
		
	}

	
	/**
	 * Given a number between 0 and 51, convert that number to the correct format.
	 * It is up to you how each card is converted, just make sure that each number is mapped to a unique card.
	 * Just make sure a mapping is 1 to 1, meaning if 4 converts to "4C", it will always convert to "4C"
	 * Also make sure it is possible for each card to be dealt.
	 * 
	 * I have provided two arrays at the top, cardNumbers and cardSuits you may use if you wish.
	 * There is clever way to convert a number using modulus and division, and this method can be done in one line.
	 * 
	 * @param card
	 * @return String representing a card in correct format
	 */
	public static String convertCard(int card){
		
		return cardSuits[card%4] + cardNumbers[card%13];
	}


	/**
	 * Display all the players hands to the console.
	 * You will need a double for loop.
	 * 
	 * @param players
	 */
	public static void displayHands(String[][] players){

		String output = "";
		for(int i = 0; i<players.length; i++){
			output += String.format("\nPlayer %s hand: ", i+1); 
		    for( String card : players[i]){
		        output += card + " ";
		    }
		    output += "\n";
		}
		System.out.print(output);
	}
	
	
	
}
