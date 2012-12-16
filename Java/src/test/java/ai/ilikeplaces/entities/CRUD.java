package ai.ilikeplaces.entities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA Ultimate.
 * User: http://www.ilikeplaces.com
 * Date: 16/12/12
 * Time: 8:12 AM
 */
abstract public class CRUD {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public CRUD() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("ilpMainSchema");
    }

    @BeforeMethod
    public void beginTransactionWithNewEntityManager() {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
    }

    @AfterMethod
    public void endTransactionAndCloseEntityManager() {
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    abstract public void Human();

    abstract public void HumansAuthentication();

    abstract public void HumansIdentity();

    abstract public void HumansNetPeople();

    abstract public void HumansNet();

    abstract public void HumansPrivateLocation();

    abstract public void HumansAlbum();

    abstract public void HumansPrivatePhoto();

    abstract public void HumansPublicPhoto();

    abstract public void HumansWall();
}
