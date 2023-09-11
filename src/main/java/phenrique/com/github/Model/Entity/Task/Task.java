package phenrique.com.github.Model.Entity.Task;

import phenrique.com.github.Model.Util.IdGenerator.IDGeneretor;
import phenrique.com.github.Model.Entity.Enum.Status.StatusTask;

import java.util.Date;

public class Task {

    private Long id = IDGeneretor.generateValueId();
    private String description;
    private Date creationDate;
    private Date endDate;
    private StatusTask status;

    public Task() {
    }
    public Task(String description, Date endDate) {
        this.description = description;
        this.endDate = endDate;
    }
    public Task(String description, Date creationDate, Date endDate, StatusTask status) {
        this.description = description;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.status = status;
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
    public Date getCreationDate() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;

        return id.equals(task.id);
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
