package lab6;

public class GiftCard extends PaymentMethod {

	private double balance;
	
	
	public GiftCard(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	@Override
	public boolean charge(double amount) {
		if (amount < 0 || amount > this.balance) {
			return false;
		}
		this.balance -= amount;
		return true;
		
	}
	
}
