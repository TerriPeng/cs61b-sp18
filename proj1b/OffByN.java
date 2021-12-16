public class OffByN implements CharacterComparator{

    public int difference;

    public OffByN(int N) {
        difference = N;
    }

    public boolean equalChars(char x, char y) {
        return x - y == difference || x - y == -difference;
    }

}
