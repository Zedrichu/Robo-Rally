public class GameSettings {
    private int numPlayers;
    private Complexity complexity;

    GameSettings(int m, Complexity comp) {
        this.numPlayers = m;
        this.complexity = comp;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity comp) {
        this.complexity = comp;
    }
}
