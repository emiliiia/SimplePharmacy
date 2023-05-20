package org.pharmacy.model;
/*
  @author emilia
  @project pharmacy
  @class Order
  @version 1.0.0
  @since 24.04.2023 - 1:00
*/

import java.sql.Date;

public class Order {
    private int id;
    private final int clientId;
    private final int drugId;
    private final int drugQuantity;
    private final Double price;
    private final String orderStatus;
    private final Boolean orderGo;

    public Order(int id, int clientId, int drugId, int drugQuantity, Double price, String orderStatus, Boolean orderGo, Date createdAt, Date updatedAt) {
        this.id = id;
        this.clientId = clientId;
        this.drugId = drugId;
        this.drugQuantity = drugQuantity;
        this.price = price;
        this.orderStatus = orderStatus;
        this.orderGo = orderGo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public int getDrugId() {
        return drugId;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Boolean getOrderGo() {
        return orderGo;
    }
}
