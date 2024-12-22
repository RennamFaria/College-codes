import java.util.Calendar;
import java.util.GregorianCalendar;

/*
Como tratar o caso de estados ou estratégia nula?
Qual padrão de resolve isso?
R:
  Para resolver o problema de nula pode ser resolvida usando o Factory Method, criando uma corpo para o algoritimo e espaços vazios para ser preenchidos e outros vazios caso não seja o estado ou estratégia prevista, lidando com casos onde a estratégia não é encontrada.

*/

public class Main {
  public static void main(String[] args) {
    StrategyFactory factory = new ConcreteStrategyFactory();

    GregorianCalendar GregCalendar = new GregorianCalendar();
    int day = GregCalendar.get(Calendar.DAY_OF_WEEK);

    StrategyWeek strategy = factory.createStrategy(day);

    Week week = new Week(strategy);
    week.showStrategy();

    // Testing null
    System.out.println("\nTest a day with NULL state:");
    StrategyWeek nullStrategy = factory.createStrategy(0);
    Week testWeek = new Week(nullStrategy);
    testWeek.showStrategy();
  }
}
