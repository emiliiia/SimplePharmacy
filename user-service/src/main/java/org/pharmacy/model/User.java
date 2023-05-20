package org.pharmacy.model;
/*
  @author emilia
  @project pharmacy
  @class User
  @version 1.0.0
  @since 15.04.2023 - 3:17
*/

import java.sql.Date;

public class User {
    private int id;
    private final String userName;
    private final Date userDateBirth;
    private final String userPhoneNum;
    private final String userEmail;
    private final int roleId;

    public User(int id, String userName, Date userDateBirth, String userPhoneNum, String userEmail, int roleId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.userName = userName;
        this.userDateBirth = userDateBirth;
        this.userPhoneNum = userPhoneNum;
        this.userEmail = userEmail;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public Date getUserDateBirth() {
        return userDateBirth;
    }
    public String getUserPhoneNum() {
        return userPhoneNum;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public int getRoleId() {
        return roleId;
    }

}
