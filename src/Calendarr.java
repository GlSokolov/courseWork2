import java.time.LocalDate;
import java.util.*;

public class Calendarr {
    private final Map<Integer, Tasks> mapOfTasks;

    public Calendarr() {
        mapOfTasks = new HashMap<>();
    }

    public boolean addTask (Tasks tasks) {
        mapOfTasks.put(tasks.getId(), tasks);
        return false;
    }

    public boolean removeTask(int id){
        if (mapOfTasks.containsKey(id)) {
            mapOfTasks.get(id).setActive(false);
            return true;
        }
        return false;
    }

    public List<Tasks> getTasksForOneDay(LocalDate date){
        List<Tasks> result = new ArrayList<>();
        for (Map.Entry<Integer, Tasks> entry : mapOfTasks.entrySet()){
            if (entry.getValue() instanceof Repeatable
                    && ((Repeatable) entry.getValue()).getNextDate(date)) {
                result.add(entry.getValue());
            } else if (entry.getValue().getDateTime().toLocalDate().equals(date)) {
                result.add(entry.getValue());
            }
        }
        result.sort(Comparator.comparing(Tasks::getDateTime));
        return result;
    }
}
