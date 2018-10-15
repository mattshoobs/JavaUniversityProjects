package lab6;

public class Account {

	private double balance = 0;

	public double getBalance() {
		return this.balance;

	}

	public boolean withdraw(double amount) {
		if (amount < 0) {
			return false;
		}
		balance -= amount;
		return true;

	}

	public void deposit(double amount) {
		if (amount < 0) {
			return;
		}
		balance += amount;
	}

}
