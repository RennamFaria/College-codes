public class AlgarismFactory {
    private final Algarism[] algarismCache;

    public AlgarismFactory() {
        algarismCache = new Algarism[10];
    }

    public Algarism getAlgarism(int algarism) {
        if (algarismCache[algarism] == null) {
            algarismCache[algarism] = new AlgarismConcrete(algarism);
        }
        return algarismCache[algarism];
    }
}