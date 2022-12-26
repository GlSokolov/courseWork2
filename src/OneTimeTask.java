import java.time.LocalDateTime;

public class OneTimeTask extends Tasks {
    public OneTimeTask(String title, String description, boolean isPersonal, LocalDateTime dateTime) {
        super(title, description, isPersonal, dateTime);
    }
}
