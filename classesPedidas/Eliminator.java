/**
 * @author PCO team 03
 * @author Duarte Miranda nº 58631
 * @author Fatma Ozel nº 57037
 * @author Luiza Maretto nº 58653
 */
public interface Eliminator {
    /**
     * Searches in the seq array for contiguous sequences of symbols and if one is
     * found the symbols are replaced with the nothing symbol.
     * 
     * @param seq       Array with symbols
     * @param blockSize The minimum size of the sequences to eliminate
     * @param nothing   The symbol corresponding to the empty position
     *                  in sequences to eliminate and accomodate
     * @requires seq != null && nothing != null
     * @return int The number of deleted symbols
     */
    public int eliminateSequence(Symbol[] seq, int blockSize, Symbol nothing);
}
