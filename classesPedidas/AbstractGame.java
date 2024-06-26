import java.util.*;

public abstract class AbstractGame implements Game {

    private int points = 0;
    private Random generator;
    private PlayArea grid;
    private Piece piece;

    public AbstractGame(int r, int c, int diff, Symbol empty, Symbol[] values, Random gen, Eliminator elim,
            Accomodator acc) {
        PlayArea newGrid = new PlayArea(r, c, diff, empty, values, gen, elim, acc);
        this.grid = newGrid;
        this.generator = gen;
    }

    public int linesInGrid() {
        return grid.gridDimensions()[1];
    }

    public int colsInGrid() {
        return grid.gridDimensions()[0];
    }

    public void permutatePiece(int n) {
        this.piece.permutation(n);
    }

    public void generatePiece() {
        this.piece = new Piece(this.generator, SIZE_OF_PIECE, this.grid.emptySymbol(), this.grid.allSymbols()).copy();
    }

    public void placePiece(int col) {
        this.grid.placePiece(this.piece, col - 1);
        List<Integer> eliminated = this.grid.eliminateAccomodateAll(SIZE_OF_PIECE);
        registerPlayScore(eliminated);
    }

    public int spaceInColumn(int col) {
        return this.grid.spaceInColumn(col - 1);
    }

    public String currentPiece() {
        return this.piece.toString();
    }

    public String toString() {
        return "Current grid:\n" + this.grid.currentGrid() + "\nCurrent piece:\n" + currentPiece();
    }

    public boolean finished() {
        return !this.grid.hasEnoughSpace(SIZE_OF_PIECE);
    }

    public abstract void registerPlayScore(List<Integer> eliminated);

    public abstract int score();
}