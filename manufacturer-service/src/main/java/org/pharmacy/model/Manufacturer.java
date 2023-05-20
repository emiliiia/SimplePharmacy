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
    private final String manufacturerName;
    private final String country;
    private final String agentName;
    private final String agentPhoneNum;
    private final String description;

    public Manufacturer(int id, String manufacturerName, String country, String agentName, String agentPhoneNum, String description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.country = country;
        this.agentName = agentName;
        this.agentPhoneNum = agentPhoneNum;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
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
}
