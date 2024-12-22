import java.util.Calendar;

class ConcreteStrategyFactory implements StrategyFactory {
  
  public StrategyWeek createStrategy(int dayOfWeek) {
    
    if (dayOfWeek == Calendar.SUNDAY) {
      return new SundayStrategy();
    } 
    else if (dayOfWeek == Calendar.SATURDAY) {
      return new SaturdayStrategy();
    } 
    else if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
      return new WeekdayStrategy();
    } 
    else {
      return new NullStrategy();
    }
    
  }
}
