public class Week {
    private StrategyWeek strategy;

    public void setStrategy(StrategyWeek strategy) {
        this.strategy = strategy;
    }

    public void showStrategy() {
        strategy.toDoList();
    }
}