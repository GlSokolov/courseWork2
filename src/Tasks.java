import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Tasks {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private String title;
    private String description;
    private boolean isPersonal;
    private int id;
    private static int counter;
    private LocalDateTime dateTime;
    private boolean isActive;

    public Tasks(String title, String description, boolean isPersonal, LocalDateTime dateTime) {
        this.title = title;
        this.description = description;
        this.isPersonal = isPersonal;
        this.dateTime = dateTime;
        this.id = ++counter;
        this.isActive = true;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPersonal() {
        return isPersonal;
    }

    public int getId() {
        return id;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return
                "Задача:"+isPersonal+ "[" + id +"." +
                title +
                " - " + description +
                " Сделать нужно - " + dateTime +
                ']';
    }
}
