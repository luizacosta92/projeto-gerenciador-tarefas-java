import java.util.List;

public interface Filter {
    List<Task> filterStatus(StatusTask status);
}
