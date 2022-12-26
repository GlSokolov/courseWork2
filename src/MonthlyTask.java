import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Tasks implements Repeatable{
    public MonthlyTask(String title, String description, boolean isPersonal, LocalDateTime dateTime) {
        super(title, description, isPersonal, dateTime);
    }

    @Override
    public boolean getNextDate(LocalDate date) {
        return date.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
}
