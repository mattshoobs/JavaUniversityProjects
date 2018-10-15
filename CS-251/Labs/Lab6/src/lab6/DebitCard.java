package lab6;

public class DebitCard extends PaymentMethod {
	
	private Account account;
	
	
	public DebitCard(Account account) {
		this.account = account;
		
	}
	
	public boolean depositDebitFunds(double amount) {
		deposit(account)
	}
	
	public double getDebitBalance() {
		
	}
	
	@Override
	public boolean charge(double amount) {
		
	}

}
