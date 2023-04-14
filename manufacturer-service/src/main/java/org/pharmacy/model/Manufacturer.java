package org.pharmacy.model;
/*
  @author emilia
  @project pharmacy
  @class Manufacturer
  @version 1.0.0
  @since 14.04.2023 - 14:56
*/

import java.sql.Date;


public class Manufacturer {
    private int id;
    private String manufacturerName;
    private String country;
    private String agentName;
    private String agentPhoneNum;
    private String description;
    private Date createdAt;
    private Date updatedAt;

    public Manufacturer(int id, String manufacturerName, String country, String agentName, String agentPhoneNum, String description) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.country = country;
        this.agentName = agentName;
        this.agentPhoneNum = agentPhoneNum;
        this.description = description;
    }

    public Manufacturer(String manufacturerName, String country, String agentName, String agentPhoneNum, String description) {
        this.manufacturerName = manufacturerName;
        this.country = country;
        this.agentName = agentName;
        this.agentPhoneNum = agentPhoneNum;
        this.description = description;
    }

    public Manufacturer(int id, String manufacturerName, String country, String agentName, String agentPhoneNum, String description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.country = country;
        this.agentName = agentName;
        this.agentPhoneNum = agentPhoneNum;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getAgentPhoneNum() {
        return agentPhoneNum;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setAgentPhoneNum(String agentPhoneNum) {
        this.agentPhoneNum = agentPhoneNum;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
