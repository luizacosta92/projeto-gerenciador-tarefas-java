import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private String title;
    private String description;
    private StatusTask status;
    private LocalDate deadline;

    public Task(String title, String description, StatusTask status, LocalDate deadline){
        this.title = title;
        this.description = description;
        this.status = status;
        this.deadline = deadline;

    }

    public String getTitle(){
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

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Título" + title +
                "\nDescrição: " + description +
                "\nData Limite: " + deadline.format(formatter) +
                "\nStatus: " + status.getStatus();
    }


}
