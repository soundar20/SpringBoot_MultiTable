package com.java.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CollaborationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserCollId", nullable = false, unique = true)
    private int userCollId;
    private String userCollMail;
    private int collUserId;
    private String collTeamName;

    public CollaborationUser() {
    }

    public CollaborationUser(int userCollId, String userCollMail, int collUserId, String collTeamName) {
        this.userCollId = userCollId;
        this.userCollMail = userCollMail;
        this.collUserId = collUserId;
        this.collTeamName = collTeamName;
    }

    public int getUserCollId() {
        return userCollId;
    }

    public void setUserCollId(int userCollId) {
        this.userCollId = userCollId;
    }

    public String getUserCollMail() {
        return userCollMail;
    }

    public void setUserCollMail(String userCollMail) {
        this.userCollMail = userCollMail;
    }

    public int getCollUserId() {
        return collUserId;
    }

    public void setCollUserId(int collUserId) {
        this.collUserId = collUserId;
    }

    public String getCollTeamName() {
        return collTeamName;
    }

    public void setCollTeamName(String collTeamName) {
        this.collTeamName = collTeamName;
    }
    
    
}
