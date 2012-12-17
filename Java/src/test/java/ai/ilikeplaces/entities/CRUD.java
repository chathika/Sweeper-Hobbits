package ai.ilikeplaces.entities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    public static final String HumanID = "" + System.currentTimeMillis() + "@ilikeplaces.com";
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

    @AfterSuite
    public void closeEntityManagerFactory() {
        //entityManagerFactory.close();
    }

    @Test
    abstract public void Human();

    @Test
    abstract public void HumansAuthentication();

    @Test
    abstract public void HumansIdentity();

    @Test
    abstract public void HumansNetPeople();

    @Test
    abstract public void HumansNet();

    @Test
    abstract public void HumansPrivateLocation();

    @Test
    abstract public void HumansAlbum();

    @Test
    abstract public void HumansPrivatePhoto();

    @Test
    abstract public void HumansPublicPhoto();

    @Test
    abstract public void HumansWall();
}
