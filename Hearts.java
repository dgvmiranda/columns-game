/**
 * An implementation of the Symbol interface
 * 
 * @author PCO Team
 */
public enum Hearts implements Symbol {
	RED("R"),
	ORANGE("O"),
	YELLOW("Y"),
	GREEN("G"),
	BLUE("B"),
	EMPTY("-");

	private String rep;

	Hearts(String s) {
		this.rep = s;
	}

	public String toString() {
		return this.rep;
	}

	public Hearts[] symbols() {
		return this.values();
	}
}
