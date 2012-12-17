package ai.ilikeplaces.entities;

import ai.ilikeplaces.entities.etc.*;
import ai.scribble.License;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ravindranath Akila
 */

@License(content = "This code is licensed under GNU AFFERO GENERAL PUBLIC LICENSE Version 3")
@Table(name = "Human", schema = "KunderaKeyspace@ilpMainSchema")
@Entity
@EntityListeners({EntityLifeCycleListener.class})
public class Human extends HumanEquals implements HumanIdFace, Serializable, Clearance, HumansFriend {
// ------------------------------ FIELDS ------------------------------

    public static final String humansAuthenticationCOL = "humansAuthentication";
    public static final String humansIdentityCOL = "humansIdentity";
    public static final String humansPublicPhotoCOL = "humansPublicPhoto";
    public static final String humansPrivatePhotoCOL = "humansPrivatePhoto";
    public static final String humansNetCOL = "humansNet";
    public static final String humansPrivateLocationCOL = "humansPrivateLocation";
    public static final String humansPrivateEventCOL = "humansPrivateEvent";
    public static final String humansAlbumCOL = "humansAlbum";
    public static final String humansWallCOL = "humansWall";
    @Id
    @Column(name = "humanId")
    public String humanId;
    public static final String humanCOL = "humanId";

    /**
     * If the user is not active on the site, he is considered dead and the
     * account shall be false under humanAlive.
     * The motivation is to get all humansAlive to be true on ilikeplaces.com:-)
     * Important: This is also the switch for the privacy policy.
     */
    @Column(name = "humanAlive")
    public Boolean humanAlive;

    @Column(name = "clearance")
    public Long clearance = 0L;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanId")
    @Column(name = "humansAuthentication")
    public HumansAuthentication humansAuthentication;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanId")
    @Column(name = "humansIdentity")
    public HumansIdentity humansIdentity;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanId")
    @Column(name = "humansPublicPhoto")
    public HumansPublicPhoto humansPublicPhoto;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanId")
    @Column(name = "HumansPrivatePhoto")
    public HumansPrivatePhoto humansPrivatePhoto;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "humanId")
    @Column(name = "humansNet")
    public HumansNet humansNet;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanId")
    @Column(name = "humansPrivateLocation")
    public HumansPrivateLocation humansPrivateLocation;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanId")
    @Column(name = "humansPrivateEvent")
    public HumansPrivateEvent humansPrivateEvent;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanId")
    @Column(name = "humansAlbum")
    public HumansAlbum humansAlbum;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanId")
    @Column(name = "humansWall")
    public HumansWall humansWall;

// --------------------- GETTER / SETTER METHODS ---------------------

    @Override
    public Long getClearance() {
        return clearance;
    }

    @Override
    public void setClearance(final Long clearance) {
        this.clearance = clearance;
    }

    public Boolean getHumanAlive() {
        return humanAlive;
    }

    public void setHumanAlive(final Boolean humanAlive) {
        this.humanAlive = humanAlive;
    }

    public String getHumanId() {
        return humanId;
    }

    public void setHumanId(final String humanId__) {
        this.humanId = humanId__;
    }

    public HumansAlbum getHumansAlbum() {
        return humansAlbum;
    }

    public void setHumansAlbum(HumansAlbum humansAlbum) {
        this.humansAlbum = humansAlbum;
    }

    public HumansAuthentication getHumansAuthentication() {
        return humansAuthentication;
    }

    public void setHumansAuthentication(final HumansAuthentication humansAuthentications) {
        this.humansAuthentication = humansAuthentications;
    }

    public HumansIdentity getHumansIdentity() {
        return humansIdentity;
    }

    public void setHumansIdentity(final HumansIdentity humansIdentity) {
        this.humansIdentity = humansIdentity;
    }

    public HumansNet getHumansNet() {
        return humansNet;
    }

    public void setHumansNet(final HumansNet humansNet) {
        this.humansNet = humansNet;
    }

    public HumansPrivateEvent getHumansPrivateEvent() {
        return humansPrivateEvent;
    }

    public void setHumansPrivateEvent(final HumansPrivateEvent humansPrivateEvent) {
        this.humansPrivateEvent = humansPrivateEvent;
    }

    public HumansPrivateLocation getHumansPrivateLocation() {
        return humansPrivateLocation;
    }

    public void setHumansPrivateLocation(final HumansPrivateLocation humansPrivateLocation) {
        this.humansPrivateLocation = humansPrivateLocation;
    }

    public HumansPrivatePhoto getHumansPrivatePhoto() {
        return humansPrivatePhoto;
    }

    public void setHumansPrivatePhoto(final HumansPrivatePhoto humansPrivatePhoto) {
        this.humansPrivatePhoto = humansPrivatePhoto;
    }

    public HumansPublicPhoto getHumansPublicPhoto() {
        return humansPublicPhoto;
    }

    public void setHumansPublicPhoto(HumansPublicPhoto humansPublicPhoto) {
        this.humansPublicPhoto = humansPublicPhoto;
    }

    public HumansWall getHumansWall() {
        return humansWall;
    }

    public void setHumansWall(final HumansWall humansWall) {
        this.humansWall = humansWall;
    }

// ------------------------ CANONICAL METHODS ------------------------

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null) return false;

        if (getClass() == o.getClass()) {
            final Human that = (Human) o;
            return (!(this.getHumanId() == null || that.getHumanId() == null)) && this.getHumanId().equals(that.getHumanId());
        } else {
            return matchHumanId(o);
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "humanId='" + humanId + '\'' +
                ", clearance=" + clearance +
                ", humanAlive=" + humanAlive +
                '}';
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface HumansFriend ---------------------

    @Transient
    @Override
    public String getDisplayName() {
        return getHumansNet().getDisplayName();
    }

    /**
     * Checks friendsHumanId is a friend of this human
     *
     * @param friendsHumanId
     * @return if friendsHumanId is a friend of this human
     */
    @Override
    @Transient
    public boolean ifFriend(final String friendsHumanId) {
        return FriendUtil.checkIfFriend(new HumanId(this.humanId), new HumanId(friendsHumanId)).returnValueBadly();
    }

    /**
     * Checks friendsHumanId is NOT a friend of this human
     *
     * @param friendsHumanId
     * @return if friendsHumanId is NOT a friend of this human
     */
    @Override
    @Transient
    public boolean notFriend(final String friendsHumanId) {
        return !ifFriend(friendsHumanId);
    }

// -------------------------- OTHER METHODS --------------------------

    @Transient
    public Human getHuman() {
        return this;
    }
}
