import java.util.*;

public class SingleScoreGame extends AbstractGame {
    private int points = 0;

    public SingleScoreGame(int r, int c, int diff, Symbol empty, Symbol[] values, Random gen, Eliminator elim,
            Accomodator acc) {
        super(r, c, diff, empty, values, gen, elim, acc);
    }

    @Override
    public boolean finished() {
        for (int i = 1; i < colsInGrid(); i++) {
            if (linesInGrid() > spaceInColumn(i)) {
                return false;
            }
        }
        return true;
    }

    public void registerPlayScore(List<Integer> eliminated) {
        this.points += 10;
    }

    public int score() {
        return this.points;
    }

    public String toString() {
        return super.toString() + "\nScore: " + this.points;
    }
}
