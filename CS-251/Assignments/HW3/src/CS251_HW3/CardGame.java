package CS251_HW3;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class CardGame {

	private static final String[] cardNumbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private static final String[] cardSuits = {"D","H","C","S"};
	private static final int defaultPlayers = 2;
	
	private boolean deck[];
	private String[][] players;
	private int cardsDealt;
	private boolean hasDealtCards;

	
	public CardGame (int totalPlayers) {
		
		totalPlayers = totalPlayers <= 8 && totalPlayers >= 2 ? totalPlayers : defaultPlayers;
		this.players = new String [totalPlayers][5];
		this.deck = new boolean[52];
		this.resetDeck();
	}
	
	public int getTotalCardsDealt() {
		return cardsDealt;
	}
	
	
	private void setHasDealtCards(boolean hasDealtCards) {
		this.hasDealtCards = hasDealtCards;
	}
	
	public boolean getHasDealtCards() {
		return hasDealtCards;
	}
	
	private void setCardsDealt(int cardsDealt) {
		this.cardsDealt = cardsDealt;
	}


	public void resetDeck(){	
		
		Arrays.fill(this.deck, Boolean.TRUE);
		this.setHasDealtCards(false);
		this.setCardsDealt(0);
		
	}
	
	public void dealHands(){
		
		if (!getHasDealtCards()) {
			for(int i = 0; i<this.players.length; i++){
				for(int k = 0; k<this.players[i].length; k++){
					 players[i][k] = dealCard();	
				}
			}	
		this.setHasDealtCards(true);
		}	
		else {
			System.out.println("Error - The cards have already been dealt. Can't deal more cards");
		}
	}

	
	private String dealCard(){
        
        while(true){
            int tempCard = ThreadLocalRandom.current().nextInt(0, 52);
            if(deck[tempCard]) {
                deck[tempCard] = false;
                return convertCard(tempCard);
            }
        }
    }

	
	private String convertCard(int card){
		return cardSuits[card%4] + cardNumbers[card%13];
	}


	public void displayHands(){

		String output = "";
		for(int i = 0; i<this.players.length; i++){
			output += String.format("\nPlayer %s hand: ", i+1); 
		    for( String card : this.players[i]) {
		        output += card + " ";
		    }
		    output += "\n";
		}
		System.out.print(output);
	}
	
	public void addPlayers(int playersToAdd) {
		if (playersToAdd < 0 || this.players.length + playersToAdd > 8) {
			System.out.print("Error - Can't add negative players or exceed 8 total players.");
			return;
		}
		//this.newPlayers = new String [playersToAdd][5];
		players = Arrays.copyOf(this.players,this.players.length + playersToAdd);
		for(int i = this.players.length - (playersToAdd); i < players.length ; i++){
			this.players[i] = new String[5];
			for(int k = 0; k<players[i].length; k++){
				 this.players[i][k] = dealCard();
			}
		}
	}
	
	
}
