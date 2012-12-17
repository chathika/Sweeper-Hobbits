package ai.ilikeplaces.entities;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA Ultimate.
 * User: http://www.ilikeplaces.com
 * Date: 20/11/12
 * Time: 12:14 AM
 */
@Test(enabled = true)
public class Read extends CRUD {

    String humanId;

    @BeforeClass
    public void before() {
        this.humanId = HumanID;
    }

    public void Human() {
        Assert.assertTrue(entityManager.find(Human.class, humanId).getHumanId().equals(humanId));
    }

    public void HumansAuthentication() {
        final HumansAuthentication _humansAuthentication = entityManager.find(HumansAuthentication.class, humanId);
        Assert.assertTrue(_humansAuthentication.getHumanId().equals(humanId));
    }

    public void HumansIdentity() {
        final HumansIdentity _humansIdentity = entityManager.find(HumansIdentity.class, humanId);
        Assert.assertTrue(_humansIdentity.getHumanId().equals(humanId));
    }

    public void HumansNetPeople() {
        final HumansNetPeople _humansNetPeople = entityManager.find(HumansNetPeople.class, humanId);
        Assert.assertTrue(_humansNetPeople.getHumanId().equals(humanId));
    }

    public void HumansNet() {
        final HumansNet _humansNet = entityManager.find(HumansNet.class, humanId);
        Assert.assertTrue(_humansNet.getHumanId().equals(humanId));
    }

    public void HumansPrivateLocation() {
        final HumansPrivateLocation _humansPrivateLocation = entityManager.find(HumansPrivateLocation.class, humanId);
        Assert.assertTrue(_humansPrivateLocation.getHumanId().equals(humanId));
    }

    public void HumansAlbum() {
        final HumansAlbum _humansAlbum = entityManager.find(HumansAlbum.class, humanId);
        Assert.assertTrue(_humansAlbum.getHumanId().equals(humanId));
    }

    public void HumansPrivatePhoto() {
        final HumansPrivatePhoto _humansPrivatePhoto = entityManager.find(HumansPrivatePhoto.class, humanId);
        Assert.assertTrue(_humansPrivatePhoto.getHumanId().equals(humanId));
    }

    public void HumansPublicPhoto() {
        final HumansPublicPhoto _humansPublicPhoto = entityManager.find(HumansPublicPhoto.class, humanId);
        Assert.assertFalse(_humansPublicPhoto.getHumanId().equals(humanId));
    }

    public void HumansWall() {
        final HumansWall _humansWall = entityManager.find(HumansWall.class, humanId);
        Assert.assertTrue(_humansWall.getHumanId().equals(humanId));
    }

}
