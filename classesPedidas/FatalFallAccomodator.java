
/**
 * An implementation of the Accomodator interface.
 * A class which methods accommodate a given sequence of symbols
 * 
 * @author PCO team 03
 * @author Duarte Miranda nº 58631
 * @author Fatma Ozel nº 57037
 * @author Luiza Maretto nº 58653
 */
public class FatalFallAccomodator implements Accomodator {
    private int fatalHeight;

    /**
     * Constructor
     * 
     * @param fatalHeight The “height” from which it is considered that the
     *                    accommodation brings about the “death” of all symbols
     *                    “above” those that are accommodated
     */
    public FatalFallAccomodator(int fatalHeight) {
        this.fatalHeight = fatalHeight;
    }

    /**
     * Accommodates all nothing symbols in the sequence seq. If the number of
     * symbols
     * to accommodate is greater than the “fatal height” defined in the constructor,
     * then symbols that are “above” (at the previous positions in the sequence)
     * those who are accommodated must disappear.
     * 
     * @param seq     Array with symbols
     * @param nothing The symbol corresponding to the empty position
     *                in sequences to eliminate and accomodate
     * @requires seq != null && nothing != null
     */
    @Override
    public void accomodate(Symbol[] seq, Symbol nothing) {
        boolean needToAcomodate = true;
        while (needToAcomodate) {
            int howManyHoles = 0;
            int firstFilled = 0;
            for (int i = 0; i < seq.length && seq[i] == nothing; i++) {
                firstFilled++;
            }
            int firstEmpty = firstFilled;
            for (int i = firstFilled; i < seq.length && seq[i] != nothing; i++) {
                firstEmpty++;
            }
            int l = firstEmpty;
            while (l < seq.length && seq[l] == nothing) {
                howManyHoles++;
                l++;
            }
            if (howManyHoles >= this.fatalHeight) {
                for (int i = 0; i < firstEmpty; i++) {
                    seq[i] = nothing;
                }
            }
            for (int i = firstEmpty + howManyHoles - 1; i >= howManyHoles; i--) {
                seq[i] = seq[i - howManyHoles];
            }
            for (int i = firstFilled + howManyHoles - 1; i >= 0; i--) {
                seq[i] = nothing;
            }
            needToAcomodate = howManyHoles != 0;
        }
    }
}
