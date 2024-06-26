import java.util.*;

/**
 * A concrete implementation of the AbstractGame abstract class.
 * A class which objects represent games.
 * 
 * @author PCO team 03
 * @author Duarte Miranda nº 58631
 * @author Fatma Ozel nº 57037
 * @author Luiza Maretto nº 58653
 */

public class MultipleRewardGame extends AbstractGame {
    private int playPoints = 0;
    private int elimPoints = 0;
    static final int PLAY_SCORES = 10;
    static final int BASE_ELIM_POINTS = 200;
    static final int EXTRA_ELIM_POINTS = 50;

    /**
     * Constructor.
     * 
     * @param r      Number of lines in the game´s grid
     * @param c      Number of columns in the game´s grid
     * @param diff   Number of lines already filled by simbols
     * @param empty  The empty symbol
     * @param values Collection of symbols ???
     * @param gen    Random generator
     * @param elim   Eliminator
     * @param acc    Accommodator
     */
    public MultipleRewardGame(int r, int c, int diff, Symbol empty, Symbol[] values, Random gen, Eliminator elim,
            Accomodator acc) {
        super(r, c, diff, empty, values, gen, elim, acc);
    }

    /**
     * Updates the score accordingly to the results of a play
     * 
     * @param eliminated List of the number df symbols that were eliminated from
     *                   the game in multiple eliminations during a play
     * @requires eliminated != null
     */
    @Override
    public void registerPlayScore(List<Integer> eliminated) {
        int idx = 1;
        int points = 0;
        this.playPoints += PLAY_SCORES;
        for (Integer i : eliminated) {
            points += ((200 + ((i - SIZE_OF_PIECE) * 50)) * (idx));
            idx++;
        }
        this.elimPoints += points;
    }

    /**
     * Returns the current score of the game
     * 
     * @return int Current score
     */
    @Override
    public int score() {
        return this.playPoints + this.elimPoints;
    }

    /**
     * Returns the textual representation of the game with the scores
     * 
     * @return String Textual representation of the game with the scores
     */
    @Override
    public String toString() {
        return super.toString() + "Score of plays: " + this.playPoints + "  "
                + "Score of eliminations: " + this.elimPoints;
    }
}
