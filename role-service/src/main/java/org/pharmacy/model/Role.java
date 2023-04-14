package org.pharmacy.model;
/*
  @author emilia
  @project pharmacy
  @class Role
  @version 1.0.0
  @since 05.04.2023 - 17:43
*/

public class Role {
    private int id;

    private String roleName;

    public Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
