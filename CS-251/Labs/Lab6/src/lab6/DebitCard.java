package lab6;

public class DebitCard extends PaymentMethod {

	private Account account;

	public DebitCard(Account account) {
		this.account = account;

	}

	public boolean depositDebitFunds(double amount) {
		this.account.deposit(amount);
		return true;
	}

	public double getDebitBalance() {
		return this.account.getBalance();
	}

	@Override
	public boolean charge(double amount) {
		if (amount < 0 || amount > getDebitBalance()) {
			return false;
		}
		this.account.withdraw(amount);
		return true;
	}

}
