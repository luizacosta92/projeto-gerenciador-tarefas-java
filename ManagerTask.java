import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerTask implements Manager {
    private List<Task> tasks;

    public ManagerTask() {
        this.tasks = new ArrayList<>();
    }

    public Task createTask(Task task) {
        if (task.getTitle() == null || task.getTitle().length() < 10) {
            System.out.println("Erro: Título muito curto, escreva, pelo menos 10 caracteres.");
            return null;
        }

        if (task.getDeadline().isBefore(LocalDate.now())) {
            System.out.println("Erro: A data de vencimento não pode ser antes de hoje.");
            return null;
        }


        if (task.getStatus() == null) {
            System.out.println("Erro: O status não pode ser nulo. Digite 1 para Pendente, 2 para Em Andamento e 3 para Concluída");
            return null;
        }

        tasks.add(task);
        return task;
    }

        public List<Task> listTasks() {
            return new ArrayList<>(tasks);
        }


    @Override
    public long countTask() {
        return tasks.size();
    }

    public List<Task> filterStatus(StatusTask status) {
        return
                tasks.stream()
                        .filter(task -> task.getStatus() == status)
                        .collect(Collectors.toList());
    }

    public List<Task> orderDeadline(){
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDeadline))
                .collect(Collectors.toList());
    }
}
