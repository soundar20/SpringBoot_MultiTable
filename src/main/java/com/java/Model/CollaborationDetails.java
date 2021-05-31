package com.java.Model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CollaborationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ColId", nullable = false, unique = true)
    private int colId;
    private String colName;
    private Date creationDate;
    private String createdBy;
    private String colAdmin;
    private int colAdminId;
    private String colDescription;
    private int teamCapacity;

    public CollaborationDetails() {
    }

    public CollaborationDetails(int colId, String colName, Date creationDate, String createdBy, String colAdmin, int colAdminId, String colDescription, int teamCapacity) {
        this.colId = colId;
        this.colName = colName;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.colAdmin = colAdmin;
        this.colAdminId = colAdminId;
        this.colDescription = colDescription;
        this.teamCapacity = teamCapacity;
    }

    public int getColId() {
        return colId;
    }

    public void setColId(int colId) {
        this.colId = colId;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getColAdmin() {
        return colAdmin;
    }

    public void setColAdmin(String colAdmin) {
        this.colAdmin = colAdmin;
    }

    public int getColAdminId() {
        return colAdminId;
    }

    public void setColAdminId(int colAdminId) {
        this.colAdminId = colAdminId;
    }

    public String getColDescription() {
        return colDescription;
    }

    public void setColDescription(String colDescription) {
        this.colDescription = colDescription;
    }

    public int getTeamCapacity() {
        return teamCapacity;
    }

    public void setTeamCapacity(int teamCapacity) {
        this.teamCapacity = teamCapacity;
    }
    
    
}
