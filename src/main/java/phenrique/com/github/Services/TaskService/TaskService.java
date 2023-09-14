package phenrique.com.github.Services.TaskService;

import phenrique.com.github.DAO.TaskDAO;
import phenrique.com.github.Model.Entity.Task.TaskEntity;
import phenrique.com.github.Model.Util.ConnectionUtil.ConnectionUtil;
import phenrique.com.github.Repositories.TaskRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class TaskService implements TaskRepository {

    private ConnectionUtil connection;

    public TaskService() {
        connection = new ConnectionUtil();
    }

    @Override
    public void save(TaskEntity object) {
        EntityManager conn = connection.recoverEntityManager();
        new TaskDAO(conn).save(object);
    }

    @Override
    public void remove(TaskEntity object) {
        EntityManager conn = connection.recoverEntityManager();
        new TaskDAO(conn).remove(object);
    }

    @Override
    public TaskEntity update(Long id, TaskEntity task) {
        EntityManager conn = connection.recoverEntityManager();
        return new TaskDAO(conn).update(id, task);
    }

    @Override
    public TaskEntity findById(Long id) {
        EntityManager conn = connection.recoverEntityManager();
        return new TaskDAO(conn).findById(id);
    }

    @Override
    public List<TaskEntity> toListAll() {
        EntityManager conn = connection.recoverEntityManager();
        return new TaskDAO(conn).toListAll();
    }
}
