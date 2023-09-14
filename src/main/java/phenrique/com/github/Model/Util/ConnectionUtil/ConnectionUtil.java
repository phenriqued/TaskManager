package phenrique.com.github.Model.Util.ConnectionUtil;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionUtil {
    public EntityManager recoverEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("taskmanager");
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }

}
