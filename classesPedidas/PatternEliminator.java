import java.util.*;

public class PatternEliminator implements Eliminator {
    private List<Symbol[]> patterns;

    public PatternEliminator(List<Symbol[]> patterns) {
        this.patterns = patterns;
    }

    public int eliminateSequence(Symbol[] sequence, int blockSize, Symbol nothing) {
        int eliminated = 0;
        int z = 0;
        while (z < patterns.size() && eliminated == 0) {
            int i = 0;
            int idx = 0;
            eliminated = 0;
            Symbol[] patternToVerify = this.patterns.get(z);
            while (i < sequence.length && eliminated == 0) {
                if (patternToVerify[idx] == sequence[i]) {
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
                        sequence[j] = nothing;
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
