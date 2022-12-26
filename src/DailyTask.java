import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Tasks implements Repeatable{
    public DailyTask(String title, String description, boolean isPersonal, LocalDateTime dateTime) {
        super(title, description, isPersonal, dateTime);
    }

    @Override
    public boolean getNextDate(LocalDate date) {
        return true;
    }
}
