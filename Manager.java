import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface Manager<Task> {

    Optional<Task> createTask(Task task);

    long countTask();

}
