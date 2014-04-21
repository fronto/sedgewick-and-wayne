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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Transaction that = (Transaction) obj;
		if (!this.who.equals(that.who)) {
			return false;
		}
		if (!this.when.equals(that.when)) {
			return false;
		}
		if (!(this.amount != that.amount)) {
			return false;
		}
		return true;
	}
}
