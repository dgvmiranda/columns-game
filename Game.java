import java.util.List;

public interface Game {

    static final int SIZE_OF_PIECE = 3;

    public int linesInGrid();

    public int colsInGrid();

    public void permutatePiece(int col);

    public void placePiece(int col);

    public void generatePiece();

    public int spaceInColumn(int col);

    public String currentPiece();

    public String toString();

    public void registerPlayScore(List<Integer> eliminated);

    public boolean finished();

    public int score();
}
