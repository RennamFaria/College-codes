public class Week {
  private StrategyWeek strategy;

  public Week(StrategyWeek strategy) {
    this.strategy = strategy;
  }

  public void showStrategy() {
    strategy.toDoList();
  }
}