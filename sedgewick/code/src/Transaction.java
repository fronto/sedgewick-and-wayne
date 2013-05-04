public class Transaction {

	private final String who;
	private final Date when;
	private final double amount;
	
	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	
	
	public String who() {
		return who;
	}
	
	public Date when() {
		return when;
	}
	
	
	public double amount() {
		return amount;
	}
	
	
}
