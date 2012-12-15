package ai.feasibility.kundera;

import ai.ilikeplaces.entities.*;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA Ultimate.
 * User: http://www.ilikeplaces.com
 * Date: 20/11/12
 * Time: 12:14 AM
 */
public class KunderaHbaseTest {

    private EntityManagerFactory entityManagerFactory;
    private String humanId;

    @Before
    public void initEntityManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("ilpMainSchema");
        this.humanId = "" + System.currentTimeMillis() + "@ilikeplaces.com";
    }

    @Test
    public void Human() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        final Human newUser = new Human();
        newUser.setHumanId(humanId + "@ilikeplaces.com");
        newUser.setHumanAlive(false);//Wait for signup confirmation click by email
        entityManager.persist(newUser);

        entityManager.getTransaction().commit();

    }

    @Test
    public void HumansAuthentication() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        final HumansAuthentication ha = new HumansAuthentication();
        ha.setHumanId(humanId);
        ha.setHumanAuthenticationSalt("");
        ha.setHumanAuthenticationHash("");
        entityManager.persist(ha);

        entityManager.getTransaction().commit();

    }

    @Test
    public void HumansIdentity() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        final HumansIdentity hid = new HumansIdentity();
        hid.setHumanId(humanId);
        hid.setUrl(new Url().setUrlR("dfsdf"));//Yes, the default url is his/her email
        entityManager.persist(hid);

        entityManager.getTransaction().commit();

    }

    @Test
    public void HumansNetPeople() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        final HumansNetPeople hnp = new HumansNetPeople();
        hnp.setHumanId(humanId);
        entityManager.persist(hnp);

        entityManager.getTransaction().commit();

    }

    @Test
    public void HumansNet() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        final HumansNet hn = new HumansNet();
        hn.setDisplayName(humanId.split("@")[0]);
        hn.setHumanId(humanId);
        entityManager.persist(hn);

        entityManager.getTransaction().commit();

    }

    @Test
    public void HumansPrivateLocation() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        final HumansPrivateLocation hpl = new HumansPrivateLocation();
        hpl.setHumanId(humanId);
        entityManager.persist(hpl);

        entityManager.getTransaction().commit();

    }

    @Test
    public void HumansAlbum() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        final HumansAlbum hal = new HumansAlbum();
        hal.setHumanId(humanId);
        entityManager.persist(hal);


        entityManager.getTransaction().commit();

    }

    @Test
    public void HumansPrivatePhoto() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        final HumansPrivatePhoto hprp = new HumansPrivatePhoto();
        hprp.setHumanId(humanId);
        entityManager.persist(hprp);

        entityManager.getTransaction().commit();

    }

    @Test
    public void HumansPublicPhoto() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        final HumansPublicPhoto hpup = new HumansPublicPhoto();
        hpup.setHumanId(humanId);
        entityManager.persist(hpup);

        entityManager.getTransaction().commit();

    }

    @Test
    public void HumansWall() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        final HumansWall hw = new HumansWall();
        hw.setHumanId(humanId);
        hw.setWall(new Wall().setWallTypeR(Wall.wallTypeHuman));
        entityManager.persist(hw);

        entityManager.getTransaction().commit();

    }

    //@Test
    public void test() {
        System.out.println("\n=====================================================================================\n");
        System.out.println("Testing");
        System.out.println("\n-------------------------------------------------------------------------------------\n");

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final Msg msg = new Msg();
        msg.setMsgId(1L);
        msg.setMsgTypeR(Msg.msgTypeHUMAN)
                .setMsgContentR("YureekA!")
                .setMsgMetadata("Okie!");

        entityManager.persist(msg);


        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();


        final Human newUser = new Human();
        newUser.setHumanId("asdfsdfsd@fs.com");
        newUser.setHumanAlive(false);//Wait for signup confirmation click by email

        final HumansAuthentication ha = new HumansAuthentication();
        ha.setHumanId(humanId);
        ha.setHumanAuthenticationSalt("");
        ha.setHumanAuthenticationHash("");
        newUser.setHumansAuthentications(ha);
        newUser.setHumanAlive(false);

        setHumansIdentityInfo:
        {
            final HumansIdentity hid = new HumansIdentity();
            hid.setHumanId(humanId);
            hid.setUrl(new Url().setUrlR("dfsdf"));//Yes, the default url is his/her email

            entityManager.persist(hid);

            newUser.setHumansIdentity(hid);
        }

        //HumansNet has as many internal primarykeyjoin entities
        tricky:
        {
            final HumansNetPeople hnp = new HumansNetPeople();
            hnp.setHumanId(humanId);

            final HumansNet hn = new HumansNet();
            hn.setDisplayName(humanId.split("@")[0]);
            hn.setHumanId(humanId);

            entityManager.persist(hnp);
            hn.setHumansNetPeople(hnp);

            entityManager.persist(hn);
            newUser.setHumansNet(hn);
        }


        final HumansPrivateLocation hpl = new HumansPrivateLocation();
        hpl.setHumanId(humanId);
        entityManager.persist(hpl);
        newUser.setHumansPrivateLocation(hpl);

        final HumansPrivateEvent hpe = new HumansPrivateEvent();
        hpe.setHumanId(humanId);
        entityManager.persist(hpe);
        newUser.setHumansPrivateEvent(hpe);

        final HumansAlbum hal = new HumansAlbum();
        hal.setHumanId(humanId);
        entityManager.persist(hal);
        newUser.setHumansAlbum(hal);

        final HumansPrivatePhoto hprp = new HumansPrivatePhoto();
        hprp.setHumanId(humanId);
        entityManager.persist(hprp);
        newUser.setHumansPrivatePhoto(hprp);

        final HumansPublicPhoto hpup = new HumansPublicPhoto();
        hpup.setHumanId(humanId);
        entityManager.persist(hpup);
        newUser.setHumansPublicPhoto(hpup);

        final HumansWall hw = new HumansWall();
        hw.setHumanId(humanId);
        hw.setWall(new Wall().setWallTypeR(Wall.wallTypeHuman));
        entityManager.persist(hw);
        newUser.setHumansWall(hw);

        entityManager.persist(newUser);

        entityManager.getTransaction().commit();

        System.out.println("\n-------------------------------------------------------------------------------------\n");
        System.out.println("Test Complete");
        System.out.println("\n=====================================================================================\n");


    }
}
