package phenrique.com.github.DAO;


import phenrique.com.github.Exceptions.TaskException;
import phenrique.com.github.Model.Entity.Task.TaskEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TaskDAO implements DAO<TaskEntity>{

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public TaskDAO(EntityManager entityManager){
        this.entityManager = entityManager;
        transaction = entityManager.getTransaction();
    }

    @Override
    public void save(TaskEntity object) {
        try{
            transaction.begin();
            entityManager.persist(object);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw new TaskException("[ERROR] Your task could not be saved!" + e.getMessage());
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void remove(TaskEntity objectId) {
        try{
            transaction.begin();
            TaskEntity removeTask = findById(objectId.getId());
            entityManager.remove(removeTask);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw new TaskException("[ERROR] Your task could not be removed!" + e.getMessage());
        }finally {
            entityManager.close();
        }
    }

    @Override
    public TaskEntity update(Long id, TaskEntity newTask) {
        TaskEntity updateTask = null;
        try{
            transaction.begin();
            updateTask = findById(id);
            updateTask.setDescription(newTask.getDescription());
            updateTask.setEndDate(newTask.getEndDate());
            transaction.commit();
            entityManager.merge(updateTask);
        }catch (Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.getMessage();
        }finally {
            entityManager.close();
        }
        return updateTask;
    }

    @Override
    public TaskEntity findById(Long id) {
        return entityManager.find(TaskEntity.class, id);
    }

    @Override
    public List<TaskEntity> toListAll() {
        String sqlSelect = "SELECT task FROM TaskEntity task";
        return entityManager.createQuery(sqlSelect, TaskEntity.class).getResultList();
    }

}
