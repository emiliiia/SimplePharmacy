package org.pharmacy.model;
/*
  @author emilia
  @project pharmacy
  @class Drug
  @version 1.0.0
  @since 23.04.2023 - 23:09
*/

import java.sql.Date;

public class Drug {
    private int id;
    private final String drugName;
    private final Date expirationDate;
    private final Double volume;
    private final Double price;
    private final int inStock;
    private final int manufacturerId;
    private final String description;

    public Drug(int id, String drugName, Date expirationDate, Double volume, Double price, int inStock, int manufacturerId, String description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.drugName = drugName;
        this.expirationDate = expirationDate;
        this.volume = volume;
        this.price = price;
        this.inStock = inStock;
        this.manufacturerId = manufacturerId;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDrugName() {
        return drugName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Double getVolume() {
        return volume;
    }

    public Double getPrice() {
        return price;
    }

    public int getInStock() {
        return inStock;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public String getDescription() {
        return description;
    }
}
