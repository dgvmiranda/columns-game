public class FatalFallAccomodator implements Accomodator {
    private int fatalHeight;

    public FatalFallAccomodator(int fatalHeight) {
        this.fatalHeight = fatalHeight;
    }

    public void accomodate(Symbol[] sequence, Symbol nothing) {
        boolean needToAcomodate = true;
        while (needToAcomodate) {
            int howManyHoles = 0;
            int firstFilled = 0;
            for (int i = 0; i < sequence.length && sequence[i] == nothing; i++) {
                firstFilled++;
            }
            // firstFilled has the position of the first element different from this.nothing
            int firstEmpty = firstFilled;
            for (int i = firstFilled; i < sequence.length && sequence[i] != nothing; i++) {
                firstEmpty++;
            }
            // firstEmpty has the position of the first element equal to this.nothing
            int l = firstEmpty;
            while (l < sequence.length && sequence[l] == nothing) {
                howManyHoles++;
                l++;
            }
            if (howManyHoles >= this.fatalHeight) {
                for (int i = 0; i < firstEmpty; i++) {
                    sequence[i] = nothing;
                }
            }
            // howManyHoles has the number of positions in the sequence that are "holes"
            for (int i = firstEmpty + howManyHoles - 1; i >= howManyHoles; i--) {
                sequence[i] = sequence[i - howManyHoles];
            }
            for (int i = firstFilled + howManyHoles - 1; i >= 0; i--) {
                sequence[i] = nothing;
            }
            needToAcomodate = howManyHoles != 0;
        }
    }
}
