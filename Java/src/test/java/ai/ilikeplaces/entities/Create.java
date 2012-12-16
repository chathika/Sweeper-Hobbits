package ai.ilikeplaces.entities;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA Ultimate.
 * User: http://www.ilikeplaces.com
 * Date: 20/11/12
 * Time: 12:14 AM
 */
public class Create extends CRUD {

    String humanId;

    @BeforeClass
    public void before() {
        this.humanId = "" + System.currentTimeMillis() + "@ilikeplaces.com";
    }

    @Test
    public void Human() {
        final Human newUser = new Human();
        newUser.setHumanId(humanId + "@ilikeplaces.com");
        newUser.setHumanAlive(false);//Wait for signup confirmation click by email
        entityManager.persist(newUser);
        //Assert.assertTrue(entityManager.find(Human.class, humanId).equals(newUser));
    }

    @Test
    public void HumansAuthentication() {
        final HumansAuthentication ha = new HumansAuthentication();
        ha.setHumanId(humanId);
        ha.setHumanAuthenticationSalt("");
        ha.setHumanAuthenticationHash("");
        entityManager.persist(ha);
        //Assert.assertTrue(entityManager.find(Human.class, humanId).equals(ha));
    }

    @Test
    public void HumansIdentity() {
        final HumansIdentity hid = new HumansIdentity();
        hid.setHumanId(humanId);
        hid.setUrl(new Url().setUrlR("dfsdf"));//Yes, the default url is his/her email
        entityManager.persist(hid);
        //Assert.assertTrue(entityManager.find(Human.class, humanId).equals(hid));
    }

    @Test
    public void HumansNetPeople() {
        final HumansNetPeople hnp = new HumansNetPeople();
        hnp.setHumanId(humanId);
        entityManager.persist(hnp);
        //Assert.assertTrue(entityManager.find(Human.class, humanId).equals(hnp));
    }

    @Test
    public void HumansNet() {
        final HumansNet hn = new HumansNet();
        hn.setDisplayName(humanId.split("@")[0]);
        hn.setHumanId(humanId);
        entityManager.persist(hn);
        //Assert.assertTrue(entityManager.find(Human.class, humanId).equals(hn));
    }

    @Test
    public void HumansPrivateLocation() {
        final HumansPrivateLocation hpl = new HumansPrivateLocation();
        hpl.setHumanId(humanId);
        entityManager.persist(hpl);
        //Assert.assertTrue(entityManager.find(Human.class, humanId).equals(hpl));
    }

    @Test
    public void HumansAlbum() {
        final HumansAlbum hal = new HumansAlbum();
        hal.setHumanId(humanId);
        entityManager.persist(hal);
        //Assert.assertTrue(entityManager.find(HumansAlbum.class, humanId).getHumanId().equals(hal.getHumanId()));
    }

    @Test
    public void HumansPrivatePhoto() {
        final HumansPrivatePhoto hprp = new HumansPrivatePhoto();
        hprp.setHumanId(humanId);
        entityManager.persist(hprp);
        //Assert.assertTrue(entityManager.find(Human.class, humanId).equals(hprp));
    }

    @Test
    public void HumansPublicPhoto() {

        final HumansPublicPhoto hpup = new HumansPublicPhoto();
        hpup.setHumanId(humanId);
        entityManager.persist(hpup);
        //Assert.assertTrue(entityManager.find(Human.class, humanId).equals(hpup));
    }

    //@Test
    public void HumansWall() {
        final HumansWall hw = new HumansWall();
        hw.setHumanId(humanId);
        hw.setWall(new Wall().setWallTypeR(Wall.wallTypeHuman));
        entityManager.persist(hw);
        //Assert.assertTrue(entityManager.find(Human.class, humanId).equals(hw));

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
        String humanId = "full" + System.currentTimeMillis() + "ilikeplaces.com.com";
        newUser.setHumanId(humanId);
        newUser.setHumanAlive(false);//Wait for signup confirmation click by email

        final HumansAuthentication ha = new HumansAuthentication();
        ha.setHumanId(this.humanId);
        ha.setHumanAuthenticationSalt("");
        ha.setHumanAuthenticationHash("");
        newUser.setHumansAuthentications(ha);
        newUser.setHumanAlive(false);

        setHumansIdentityInfo:
        {
            final HumansIdentity hid = new HumansIdentity();
            hid.setHumanId(this.humanId);
            hid.setUrl(new Url().setUrlR("dfsdf"));//Yes, the default url is his/her email

            entityManager.persist(hid);

            newUser.setHumansIdentity(hid);
        }

        //HumansNet has as many internal primarykeyjoin entities
        tricky:
        {
            final HumansNetPeople hnp = new HumansNetPeople();
            hnp.setHumanId(this.humanId);

            final HumansNet hn = new HumansNet();
            hn.setDisplayName(this.humanId.split("@")[0]);
            hn.setHumanId(this.humanId);

            entityManager.persist(hnp);
            hn.setHumansNetPeople(hnp);

            entityManager.persist(hn);
            newUser.setHumansNet(hn);
        }


        final HumansPrivateLocation hpl = new HumansPrivateLocation();
        hpl.setHumanId(this.humanId);
        entityManager.persist(hpl);
        newUser.setHumansPrivateLocation(hpl);

        final HumansPrivateEvent hpe = new HumansPrivateEvent();
        hpe.setHumanId(this.humanId);
        entityManager.persist(hpe);
        newUser.setHumansPrivateEvent(hpe);

        final HumansAlbum hal = new HumansAlbum();
        hal.setHumanId(this.humanId);
        entityManager.persist(hal);
        newUser.setHumansAlbum(hal);

        final HumansPrivatePhoto hprp = new HumansPrivatePhoto();
        hprp.setHumanId(this.humanId);
        entityManager.persist(hprp);
        newUser.setHumansPrivatePhoto(hprp);

        final HumansPublicPhoto hpup = new HumansPublicPhoto();
        hpup.setHumanId(this.humanId);
        entityManager.persist(hpup);
        newUser.setHumansPublicPhoto(hpup);

        final HumansWall hw = new HumansWall();
        hw.setHumanId(this.humanId);
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
