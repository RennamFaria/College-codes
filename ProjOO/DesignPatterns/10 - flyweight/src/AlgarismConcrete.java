class AlgarismConcrete implements Algarism {
    private int value;

    public AlgarismConcrete(int value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}