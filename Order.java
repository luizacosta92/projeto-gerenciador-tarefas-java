import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public interface Order<Task> {
    List<Task> orderTasks(Comparator<Task> comparator);

    List<Task> orderDeadline();


}
