import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
  public static void main(String[] args) {
    Week week = new Week();

    GregorianCalendar GregCalendar = new GregorianCalendar();
    int day = GregCalendar.get(Calendar.DAY_OF_WEEK);

    switch (day) {
      case Calendar.SUNDAY:
        week.setStrategy(new SundayStrategy());
        break;
      case Calendar.SATURDAY:
        week.setStrategy(new SaturdayStrategy());
        break;
      default:
        week.setStrategy(new WeekdayStrategy());
    }

    week.showStrategy();
  }
}