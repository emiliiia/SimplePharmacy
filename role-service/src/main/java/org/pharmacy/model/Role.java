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

    private final String roleName;

    public Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
