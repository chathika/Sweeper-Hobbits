package ai.feasibility.kundera;

import ai.ilikeplaces.entities.*;
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

    @Test
    public void test() {
        System.out.println("\n=====================================================================================\n");
        System.out.println("Testing");
        System.out.println("\n-------------------------------------------------------------------------------------\n");

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ilpMainSchema");
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
        ha.setHumanId(newUser.getHumanId());
        ha.setHumanAuthenticationSalt("");
        ha.setHumanAuthenticationHash("");
        newUser.setHumansAuthentications(ha);
        newUser.setHumanAlive(false);

        setHumansIdentityInfo:
        {
            final HumansIdentity hid = new HumansIdentity();
            hid.setHumanId(newUser.getHumanId());
            hid.setUrl(new Url().setUrlR("dfsdf"));//Yes, the default url is his/her email

            entityManager.persist(hid);

            newUser.setHumansIdentity(hid);
        }

        //HumansNet has as many internal primarykeyjoin entities
        tricky:
        {
            final HumansNetPeople hnp = new HumansNetPeople();
            hnp.setHumanId(newUser.getHumanId());

            final HumansNet hn = new HumansNet();
            hn.setDisplayName(newUser.getHumanId().split("@")[0]);
            hn.setHumanId(newUser.getHumanId());

            entityManager.persist(hnp);
            hn.setHumansNetPeople(hnp);

            entityManager.persist(hn);
            newUser.setHumansNet(hn);
        }


        final HumansPrivateLocation hpl = new HumansPrivateLocation();
        hpl.setHumanId(newUser.getHumanId());
        entityManager.persist(hpl);
        newUser.setHumansPrivateLocation(hpl);

        final HumansPrivateEvent hpe = new HumansPrivateEvent();
        hpe.setHumanId(newUser.getHumanId());
        entityManager.persist(hpe);
        newUser.setHumansPrivateEvent(hpe);

        final HumansAlbum hal = new HumansAlbum();
        hal.setHumanId(newUser.getHumanId());
        entityManager.persist(hal);
        newUser.setHumansAlbum(hal);

        final HumansPrivatePhoto hprp = new HumansPrivatePhoto();
        hprp.setHumanId(newUser.getHumanId());
        entityManager.persist(hprp);
        newUser.setHumansPrivatePhoto(hprp);

        final HumansPublicPhoto hpup = new HumansPublicPhoto();
        hpup.setHumanId(newUser.getHumanId());
        entityManager.persist(hpup);
        newUser.setHumansPublicPhoto(hpup);

        final HumansWall hw = new HumansWall();
        hw.setHumanId(newUser.getHumanId());
        hw.setWall(new Wall().setWallTypeR(Wall.wallTypeHuman));
        entityManager.persist(hw);
        newUser.setHumansWall(hw);

        final HumansAlbum halbum = new HumansAlbum();
        halbum.setHumanId(newUser.getHumanId());

        entityManager.persist(halbum);
        newUser.setHumansAlbum(halbum);

        entityManager.persist(newUser);

        entityManager.getTransaction().commit();

        System.out.println("\n-------------------------------------------------------------------------------------\n");
        System.out.println("Test Complete");
        System.out.println("\n=====================================================================================\n");


    }
}
