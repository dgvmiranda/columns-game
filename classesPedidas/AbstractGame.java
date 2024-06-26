import java.util.*;

/**
 * An abstract implementation of the Game interface.
 * Abstract Class which objects represent games.
 * 
 * @author PCO team 03
 * @author Duarte Miranda nº 58631
 * @author Fatma Ozel nº 57037
 * @author Luiza Maretto nº 58653
 */
public abstract class AbstractGame implements Game {

    private int points = 0;
    private Random generator;
    private PlayArea grid;
    private Piece piece;

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
    public AbstractGame(int r, int c, int diff, Symbol empty, Symbol[] values, Random gen, Eliminator elim,
            Accomodator acc) {
        PlayArea newGrid = new PlayArea(r, c, diff, empty, values, gen, elim, acc);
        this.grid = newGrid;
        this.generator = gen;
    }

    /**
     * Number of lines in the grid
     * 
     * @return int Number of lines
     */
    @Override
    public int linesInGrid() {
        return grid.gridDimensions()[1];
    }

    /**
     * Number of columns in the grid
     * 
     * @return int Number of columns
     */
    @Override
    public int colsInGrid() {
        return grid.gridDimensions()[0];
    }

    /**
     * Permutates the piece by n positions
     * 
     * @param n Number of positions to permutate
     * @requires n >= 0
     */
    @Override
    public void permutatePiece(int n) {
        this.piece.permutation(n);
    }

    /**
     * Generates a new piece which becomes the current piece
     */
    @Override
    public void generatePiece() {
        this.piece = new Piece(this.generator, SIZE_OF_PIECE, this.grid.emptySymbol(), this.grid.allSymbols()).copy();
    }

    /**
     * Places piece in the column, making the necessary eliminations and
     * accommodations,
     * and calculates and updates the score
     * 
     * @param col The column
     */
    @Override
    public void placePiece(int col) {
        this.grid.placePiece(this.piece, col - 1);
        List<Integer> eliminated = this.grid.eliminateAccomodateAll(SIZE_OF_PIECE);
        registerPlayScore(eliminated);
    }

    /**
     * Number of empty spaces in the column col
     * 
     * @param col The column
     * @return int Number of empty spaces in col
     * @requires col >= 0
     */
    @Override
    public int spaceInColumn(int col) {
        return this.grid.spaceInColumn(col - 1);
    }

    /**
     * Textual representation of the current piece
     * 
     * @return String Textual representation of the current piece
     */
    @Override
    public String currentPiece() {
        return this.piece.toString();
    }

    /**
     * Textual representation of the game
     * 
     * @return String Textual representation of the game
     */
    @Override
    public String toString() {
        return "Current grid:\n" + this.grid.currentGrid() + "\nCurrent piece:\n" + currentPiece();
    }

    /**
     * Verifies if the game has already finished
     * 
     * @return boolean True if the game has finished, False otherwise
     */
    @Override
    public boolean finished() {
        return !this.grid.hasEnoughSpace(SIZE_OF_PIECE);
    }

    /**
     * Updates the score accordingly to the results of a play
     * 
     * @param eliminated List of the number df symbols that were eliminated from
     *                   the game in multiple eliminations during a play
     * @requires eliminated != null
     */
    @Override
    public abstract void registerPlayScore(List<Integer> eliminated);

    /**
     * Current score of the game
     * 
     * @return int Current score
     */
    @Override
    public abstract int score();
}