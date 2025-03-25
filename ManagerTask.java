import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Scanner;

public class ManagerTask implements Manager, Filter, Order {
    private List<Task> tasks;

    public ManagerTask() {
        this.tasks = new ArrayList<>();
    }


public Optional<Task> createTask(Task task) {
    Predicate<Task> validateTitle = newTask -> newTask.getTitle() != null && newTask.getTitle().length() >= 5;

    Predicate<Task> validateDeadline = newTask -> newTask.getDeadline().isAfter(LocalDate.now().minusDays(1));

    Predicate<Task> validateStatus = newTask -> newTask.getStatus() != null;

    if (validateTitle.and(validateDeadline).and(validateStatus).test(task)) {
        tasks.add(task);
        return Optional.of(task);
    }
    return
            Optional.empty();
}

    public List<Task> listTasks(){
        return List.copyOf(tasks);
    }

    public List<Task> getList(){
        return List.copyOf(tasks);
    }

    /*public List<Task> filterTasks(Predicate<Task> criterium){
        return tasks.stream()
                .filter(criterium)
                .collect(Collectors.toList());
    }*/

    public List<Task> filterStatus(StatusTask status) {
        return
                tasks.stream()
                        .filter(task -> task.getStatus() == status)
                        .collect(Collectors.toList());
    }

    @Override
    public List orderTasks(Comparator comparator) {
        return List.of();
    }

    public List<Task> orderDeadline(){
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDeadline))
                .collect(Collectors.toList());
    }

    @Override
    public Optional createTask(Object o) {
        return Optional.empty();
    }

    @Override
    public long countTask() {
        return tasks.size();
    }

}
