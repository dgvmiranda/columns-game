import java.util.*;

public class MultipleRewardGame extends AbstractGame {
    private int playPoints = 0;
    private int elimPoints = 0;
    static final int PLAY_SCORES = 10;
    static final int BASE_ELIM_POINTS = 200;
    static final int EXTRA_ELIM_POINTS = 50;

    public MultipleRewardGame(int r, int c, int diff, Symbol empty, Symbol[] values, Random gen, Eliminator elim,
            Accomodator acc) {
        super(r, c, diff, empty, values, gen, elim, acc);
    }

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

    public int score() {
        return this.playPoints + this.elimPoints;
    }

    public String toString() {
        return super.toString() + "Score of plays: " + this.playPoints + "  "
                + "Score of eliminations: " + this.elimPoints;
    }
}
