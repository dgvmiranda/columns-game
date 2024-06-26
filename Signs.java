/**
 * An implementation of the Symbol interface
 * 
 * @author PCO Team
 */
public enum Signs implements Symbol {
	CROSS("C"),
	CIRCLE("I"),
	BALL("B"),
	BANGS("A"),
	CANNOT("N"),
	EMPTY("-");

	private String rep;

	Signs(String s) {
		this.rep = s;
	}

	public String toString() {
		return this.rep;
	}

	public Signs[] symbols() {
		return this.values();
	}
}
