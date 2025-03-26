
import java.util.Optional;

public interface Manager<Task> {
     void createTask();

    Optional<Task> createTask(Task task);

}
