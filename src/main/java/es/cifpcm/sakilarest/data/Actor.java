package es.cifpcm.sakilarest.data;

// Generated 25-nov-2016 10:20:27 by Hibernate Tools 4.3.1
import java.util.Date;

/**
 * Actor generated by hbm2java
 */
public class Actor implements java.io.Serializable {

    private Short actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    public Actor() {
    }

    public Actor(String firstName, String lastName, Date lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public Actor(Short actorId, String firstName, String lastName, Date lastUpdate) {
        this(firstName, lastName, lastUpdate);
        this.actorId = actorId;
    }

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Short getActorId() {
        return this.actorId;
    }

    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
