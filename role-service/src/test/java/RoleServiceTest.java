/*
  @author emilia
  @project pharmacy
  @class DrugServiceTest
  @version 1.0.0
  @since 21.05.2023 - 22:50
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.pharmacy.model.Role;
import org.pharmacy.service.RoleServiceImpl;
import org.pharmacy.repository.RoleRepository;

public class RoleServiceTest {
    // Підключення до бази даних
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "55fm74rml");
    RoleRepository roleRepository = new RoleRepository(conn);

    public RoleServiceTest() throws SQLException {
    }

    @Test
    public void testCreateRole() throws SQLException {
        Role role = new Role(10, "Example");

        Assertions.assertDoesNotThrow(() -> {
            roleRepository.addRole(role);
        });
    }

    @Test
    public void testGetRoleById() throws SQLException {
        RoleServiceImpl roleService = new RoleServiceImpl(roleRepository);
        int id = 10;

        Assertions.assertDoesNotThrow(() -> {
            Role role = roleService.getRoleById(id);
        });
    }

    @Test
    public void testGetAllRoles() throws SQLException {
        RoleServiceImpl roleService = new RoleServiceImpl(roleRepository);

        Assertions.assertDoesNotThrow(() -> {
            List<Role> roles = roleService.getAllRoles();
        });
    }

    @Test
    public void testUpdateRole() throws SQLException {
        RoleServiceImpl roleService = new RoleServiceImpl(roleRepository);
        Role role = new Role(10, "Example");

        Assertions.assertDoesNotThrow(() -> {
            roleService.updateRole(role);
        });
    }

    @Test
    public void testDeleteRole() throws SQLException {
        RoleServiceImpl roleService = new RoleServiceImpl(roleRepository);
        int id = 10;

        Assertions.assertDoesNotThrow(() -> {
            roleService.deleteRole(id);
        });
    }
}
