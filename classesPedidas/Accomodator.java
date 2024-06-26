public interface Accomodator {
	/**
	 * Accomodates a sequence of symbols in order to "close"
	 * all the "holes" it has, that is, all the internal sequences
	 * containing the nothing symbol
	 * 
	 * @param seq Array with symbols
	 * @requires seq != null && nothing != null
	 */
	public void accomodate(Symbol[] seq, Symbol nothing);
}
