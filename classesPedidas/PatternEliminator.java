import java.util.*;

/**
 * An implementation of the Eliminator interface.
 * A class which methods eliminate certain sequences (patterns) of symbols
 * 
 * @author PCO team 03
 * @author Duarte Miranda nº 58631
 * @author Fatma Ozel nº 57037
 * @author Luiza Maretto nº 58653
 */
public class PatternEliminator implements Eliminator {
    private List<Symbol[]> patterns;

    /**
     * Constructor
     * 
     * @param patterns The sequence (pattern) of symbols to be eliminated
     */
    public PatternEliminator(List<Symbol[]> patterns) {
        this.patterns = patterns;
    }

    /**
     * Searches in the seq sequence for any occurrences of any of the
     * patterns defined in the constructor and one is found the symbols
     * are replaced with the nothing symbol. blockSize is ignored.
     * 
     * @param seq       Array with symbols
     * @param blockSize The minimum size of the sequences to eliminate
     * @param nothing   The symbol corresponding to the empty position
     *                  in sequences to eliminate and accomodate
     * @return int The number of deleted symbols
     * @requires seq != null && nothing != null && blockSize >= 0
     */
    @Override
    public int eliminateSequence(Symbol[] seq, int blockSize, Symbol nothing) {
        int eliminated = 0;
        int z = 0;
        while (z < patterns.size() && eliminated == 0) {
            int i = 0;
            int idx = 0;
            eliminated = 0;
            Symbol[] patternToVerify = this.patterns.get(z);
            while (i < seq.length && eliminated == 0) {
                if (patternToVerify[idx] == seq[i]) {
                    idx++;
                } else {
                    if (idx == 1) {
                        i--;
                    } else {

                    }
                    idx = 0;
                }

                if (idx == patternToVerify.length) {
                    eliminated = idx;
                    int timesToElim = idx;
                    int j = i;
                    while (timesToElim != 0) {
                        seq[j] = nothing;
                        timesToElim--;
                        j--;
                    }
                    return eliminated;
                }
                i++;
            }
            z++;
        }
        return eliminated;
    }
}
