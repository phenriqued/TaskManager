package phenrique.com.github.Model.Entity.Task;

import phenrique.com.github.Exceptions.TaskException;
import phenrique.com.github.Model.Entity.Enum.Status.StatusTask;
import phenrique.com.github.Model.Util.IdGenerator.IDGeneretor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;


public class TaskEntity implements Comparable<TaskEntity> {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long id = IDGeneretor.generateValueId();
    private String description;
    private LocalDate creationDate = LocalDate.now();
    private LocalDate endDate;
    private StatusTask status;

    public TaskEntity() {
    }
    public TaskEntity(String description, LocalDate endDate) {
        Objects.requireNonNull(description, "The description cannot be null!");
        if(description.isEmpty()) throw new TaskException("The description cannot be empty!");
        validationEndDate(endDate);
        this.description = description;
        this.endDate = endDate;
        this.status = StatusTask.IN_PROGRESS;
    }

    public static LocalDate parseFormat(String date){
        try {
            return LocalDate.parse(date, dateTimeFormatter);
        }catch (Exception e){
            throw new TaskException(e.getMessage());
        }
    }

    public static String formatStyle(LocalDate date){
        return dateTimeFormatter.format(date);
    }

    private void validationEndDate(LocalDate dueDate) {
        if(dueDate.isBefore(creationDate)){
            throw new TaskException("The date must be the same or later: " + formatStyle(creationDate));
        }
    }

    public Long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public StatusTask getStatus() {
        return status;
    }
    public void setStatus(StatusTask status) {
        this.status = status;
    }



    @Override
    public int compareTo(TaskEntity otherTask) {
        if(this.endDate.isBefore(otherTask.endDate)) return 1;

        if (this.endDate.isAfter(otherTask.endDate)) return -1;

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskEntity taskEntity)) return false;

        return id.equals(taskEntity.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "\nTarefa " + getId() +":\n"+
                "Description: [" + description + "]\n" +
                "Data Limite: " + formatStyle(endDate) +
                "  -  Status: " + status;
    }
}
