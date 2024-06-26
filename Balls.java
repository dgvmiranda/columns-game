/**
 * An implementation of the Symbol interface
 * 
 * @author PCO Team
 */
public enum Balls implements Symbol {
	RED("R"),
	ORANGE("O"),
	YELLOW("Y"),
	GREEN("G"),
	BLUE("B"),
	EMPTY("-");

	private String rep;

	Balls(String s) {
		this.rep = s;
	}

	public String toString() {
		return this.rep;
	}

	public Balls[] symbols() {
		return this.values();
	}

}
