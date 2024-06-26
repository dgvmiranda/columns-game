import java.util.List;

/**
 * @author PCO team 03
 * @author Duarte Miranda nº 58631
 * @author Fatma Ozel nº 57037
 * @author Luiza Maretto nº 58653
 */
public interface Game {

    static final int SIZE_OF_PIECE = 3;

    /**
     * Number of lines in the grid
     * 
     * @return int Number of lines
     */
    public int linesInGrid();

    /**
     * Number of columns in the grid
     * 
     * @return int Number of columns
     */
    public int colsInGrid();

    /**
     * Permutates the piece by n positions
     * 
     * @param n Number of positions to permutate
     * @requires n >= 0
     */
    public void permutatePiece(int n);

    /**
     * Places piece in the column, making the necessary eliminations and
     * accommodations,
     * and calculates and updates the score
     * 
     * @param col The column
     */
    public void placePiece(int col);

    /**
     * Generates a new piece which becomes the current piece
     */
    public void generatePiece();

    /**
     * Number of empty spaces in the column col
     * 
     * @param col The column
     * @return int Number of empty spaces in col
     * @requires col >= 0
     */
    public int spaceInColumn(int col);

    /**
     * Textual representation of the current piece
     * 
     * @return String Textual representation of the current piece
     */
    public String currentPiece();

    /**
     * Textual representation of the game
     * 
     * @return String Textual representation of the game
     */
    public String toString();

    /**
     * Updates the score accordingly to the results of a play
     * 
     * @param eliminated List of the number df symbols that were eliminated from
     *                   the game in multiple eliminations during a play
     * @requires eliminated != null
     */
    public void registerPlayScore(List<Integer> eliminated);

    /**
     * Verifies if the game has already finished
     * 
     * @return boolean True if the game has finished, False otherwise
     */
    public boolean finished();

    /**
     * Returns the current score of the game
     * 
     * @return int Current score
     */
    public int score();
}
