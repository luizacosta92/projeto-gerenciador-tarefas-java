import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ManagerTask implements Manager, Filter, Order {
    private List<Task> tasks;

    public ManagerTask() {
        this.tasks = new ArrayList<>();
    }


public Optional<Task> createTask(Task task) {
    Predicate<Task> validateTitle = newTask -> {
        boolean isValid = newTask.getTitle() != null && newTask.getTitle().length() >= 5;
            if (!isValid) {
                System.out.println("Erro: o título deve ter no mínimo 5 caracteres.");
            }
            return isValid;
            };

    Predicate<Task> validateDeadline = newTask -> {
        boolean isValid = newTask.getDeadline().isAfter(LocalDate.now().minusDays(1));
                if (!isValid){
                    System.out.println("Erro: a data limite deve ser posterior à data atual");
                };
                return isValid;
    };

    Predicate<Task> validateStatus = newTask -> {
        boolean isValid = newTask.getStatus() != null;
            if (!isValid) {
                System.out.println("Erro: o status da tarefa é obrigatório.");
            }
            return isValid;
            };

    if (validateTitle.and(validateDeadline).and(validateStatus).test(task)) {
        tasks.add(task);
        return Optional.of(task);
    }
    return
            Optional.empty();
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

    public List<Task> deadlineSoon(LocalDate deadline){
        return
                tasks.stream()
                        .filter(task -> task.getDeadline().isAfter(LocalDate.now().minusDays(1)))
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
    public void createTask() {

    }

    @Override
    public Optional createTask(Object o) {
        return Optional.empty();
    }

}
