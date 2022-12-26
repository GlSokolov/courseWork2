import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Tasks implements Repeatable{
    public YearlyTask(String title, String description, boolean isPersonal, LocalDateTime dateTime) {
        super(title, description, isPersonal, dateTime);
    }

    @Override
    public boolean getNextDate(LocalDate date) {
        return date.getYear() == getDateTime().getYear() && date.getMonth() == getDateTime().getMonth() && date.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
}
