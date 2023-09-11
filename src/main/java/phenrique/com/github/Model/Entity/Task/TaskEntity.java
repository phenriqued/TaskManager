package phenrique.com.github.Model.Entity.Task;

import phenrique.com.github.Exceptions.TaskException;
import phenrique.com.github.Model.Util.IdGenerator.IDGeneretor;
import phenrique.com.github.Model.Entity.Enum.Status.StatusTask;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class TaskEntity implements Comparable<TaskEntity> {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private Long id = IDGeneretor.generateValueId();
    private String description;
    private LocalDate creationDate;
    private Date endDate;
    private StatusTask status;

    public TaskEntity() {
    }
    public TaskEntity(String description, Date endDate) {
        this.description = description;
        this.endDate = endDate;
        this.creationDate = LocalDate.now();
        this.status = StatusTask.IN_PROGRESS;
    }

    public static Date parseFormat(String date){
        try {
            return simpleDateFormat.parse(date);
        }catch (Exception e){
            throw new TaskException(e.getMessage());
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
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
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
        if(this.endDate.before(otherTask.endDate)) return 1;

        if (this.endDate.after(otherTask.endDate)) return -1;

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
        return "Task{" +
                "description='" + description + '\'' +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
