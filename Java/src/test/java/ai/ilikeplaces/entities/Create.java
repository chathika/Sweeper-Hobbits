package ai.ilikeplaces.entities;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        this.humanId = HumanID;
    }

    public void Human() {
        final Human _human = new Human();
        _human.setHumanId(humanId);
        _human.setHumanAlive(false);
        entityManager.persist(_human);
    }

    public void HumansAuthentication() {
        final HumansAuthentication _humansAuthentication = new HumansAuthentication();
        _humansAuthentication.setHumanId(humanId);
        _humansAuthentication.setHumanAuthenticationSalt("salt");
        _humansAuthentication.setHumanAuthenticationHash("hash");
        entityManager.persist(_humansAuthentication);
    }

    public void HumansIdentity() {
        final HumansIdentity _humansIdentity = new HumansIdentity();
        _humansIdentity.setHumanId(humanId);
        _humansIdentity.setUrl(new Url().setUrlR(humanId));
        entityManager.persist(_humansIdentity);
    }

    public void HumansNetPeople() {
        final HumansNetPeople _humansNetPeople = new HumansNetPeople();
        _humansNetPeople.setHumanId(humanId);
        entityManager.persist(_humansNetPeople);
    }

    public void HumansNet() {
        final HumansNet _humansNet = new HumansNet();
        _humansNet.setDisplayName(humanId.split("@")[0]);
        _humansNet.setHumanId(humanId);
        entityManager.persist(_humansNet);
    }

    public void HumansPrivateLocation() {
        final HumansPrivateLocation _humansPrivateLocation = new HumansPrivateLocation();
        _humansPrivateLocation.setHumanId(humanId);
        entityManager.persist(_humansPrivateLocation);
    }

    public void HumansAlbum() {
        final HumansAlbum _humansAlbum = new HumansAlbum();
        _humansAlbum.setHumanId(humanId);
        entityManager.persist(_humansAlbum);
    }

    public void HumansPrivatePhoto() {
        final HumansPrivatePhoto _humansPrivatePhoto = new HumansPrivatePhoto();
        _humansPrivatePhoto.setHumanId(humanId);
        entityManager.persist(_humansPrivatePhoto);
    }

    public void HumansPublicPhoto() {
        final HumansPublicPhoto _humansPublicPhoto = new HumansPublicPhoto();
        _humansPublicPhoto.setHumanId(humanId);
        entityManager.persist(_humansPublicPhoto);
    }

    @Test(enabled = false)
    public void HumansWall() {
        final HumansWall _humansWall = new HumansWall();
        _humansWall.setHumanId(humanId);
        _humansWall.setWall(new Wall().setWallTypeR(Wall.wallTypeHuman));
        entityManager.persist(_humansWall);
    }
}
