package lab6;


public class Lab6_Driver {

	public static void  main(String[] args){

		//test gift card
		System.out.println("Test GiftCard  Class ");
		GiftCard giftCard= new GiftCard(100);
		System.out.println("Balance of Gift Card is : $"+giftCard.getBalance());
		System.out.print("The gift card has been charged $200.00? It was ");
		if (giftCard.charge(200)){
			System.out.println("successful.");
		}
		else {
			System.out.println("unsuccessful. ");
		}

		System.out.print("The gift card has been charged $-50.00? It was ");
		if (giftCard.charge(-50)){
			System.out.println("successful. ");
		}
		else{
			System.out.println("unsuccessful.");
		}
		
		System.out.print("The gift card has been charged $100.00? It was ");
		if (giftCard.charge(100)){
			System.out.println("successful. ");
		}
		else{
			System.out.println("unsuccessful.");
		}
		
		System.out.print("Charging $100.00 again was ");
		if (giftCard.charge(100)){
			System.out.println("successful. ");
		}
		else{
			System.out.println("unsuccessful.");
		}

		System.out.println("The remaining balance of this Gift Card is $"+giftCard.getBalance());

		
		//test DebitCard1
		System.out.println("\n\n");
		System.out.println("Test DebitCard Class");

		DebitCard debitCard = new DebitCard(new Account());			//important step here
																	//can anyone outside DebitCard debitCard access the account now?
		
		System.out.println("Current balance is: $" + debitCard.getDebitBalance());
		System.out.print("Can I charge $200 to my debit card?  ");

		if(debitCard.charge(200)){
			System.out.println("Success.");
		} else {
			System.out.println("Nope, you have no money.");
		}

		debitCard.depositDebitFunds(500);
		System.out.println("Added money to my account linked to debit card.  Debit card has : $" + debitCard.getDebitBalance());

		System.out.print("Can I charge -$2,000?  ");

		if(debitCard.charge(-2000)){
			System.out.println("Success. I was able to fool the system.");
		} else {
			System.out.println("Nope, amount was negative.  No free money today.");
		}
		
		System.out.println("Balance is: $" + debitCard.getDebitBalance());
		
		System.out.print("Charging $1000 to this account was ");
		if (debitCard.charge(1000)){
			System.out.println("successful. ");
		}
		else {
			System.out.println("unsuccessful. ");
		}

		System.out.println("Balance is: $" + debitCard.getDebitBalance());

		System.out.print("Charging $100 to this account was ");
		if (debitCard.charge(100)){
			System.out.println("successful. ");
		}
		else {
			System.out.println("unsuccessful. ");
		}
		
		System.out.println("Balance is: $" + debitCard.getDebitBalance());

		System.out.print("Charging $400 to this account was ");
		if (debitCard.charge(400)){
			System.out.println("successful. ");
		}
		else {
			System.out.println("unsuccessful. ");
		}

		System.out.println("Debit card balance is: $"+debitCard.getDebitBalance());

		System.out.println("Depositing $8,000,000.00 to account.");
		debitCard.depositDebitFunds(8000000);
		System.out.println("Debitcard balance is now $"+debitCard.getDebitBalance() + " and I am retiring.");


	}

}
