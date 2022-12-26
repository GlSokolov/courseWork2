import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Tasks implements Repeatable{
    public WeeklyTask(String title, String description, boolean isPersonal, LocalDateTime dateTime) {
        super(title, description, isPersonal, dateTime);
    }

    @Override
    public boolean getNextDate(LocalDate date) {
        return date.getDayOfWeek() == getDateTime().getDayOfWeek();
    }
}
