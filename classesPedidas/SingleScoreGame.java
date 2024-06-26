import java.util.*;

/**
 * A concrete implementation of the AbstractGame abstract class.
 * Class which objects represent games.
 * 
 * @author PCO team 03
 * @author Duarte Miranda nº 58631
 * @author Fatma Ozel nº 57037
 * @author Luiza Maretto nº 58653
 */
public class SingleScoreGame extends AbstractGame {
    private int points = 0;

    /**
     * Constructor.
     * 
     * @param r      Number of lines in the game´s grid
     * @param c      Number of columns in the game´s grid
     * @param diff   Number of lines already filled by simbols
     * @param empty  The empty symbol
     * @param values Array of symbols
     * @param gen    Random generator
     * @param elim   Eliminator
     * @param acc    Accommodator
     */
    public SingleScoreGame(int r, int c, int diff, Symbol empty, Symbol[] values, Random gen, Eliminator elim,
            Accomodator acc) {
        super(r, c, diff, empty, values, gen, elim, acc);
    }

    /**
     * Verifies if the game has already finished. The game is finished if the game
     * grid is completely empty.
     * 
     * @return boolean True if the game has finished, False otherwise
     */
    @Override
    public boolean finished() {
        for (int i = 1; i < colsInGrid(); i++) {
            if (linesInGrid() > spaceInColumn(i)) {
                return false;
            }
        }
        return true;
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
        this.points += 10;
    }

    /**
     * Current score of the game
     * 
     * @return int Current score
     */
    @Override
    public int score() {
        return this.points;
    }

    /**
     * Textual representation of the game with the scores
     * 
     * @return String Textual representation of the game with the scores
     */
    @Override
    public String toString() {
        return super.toString() + "\nScore: " + this.points;
    }
}
