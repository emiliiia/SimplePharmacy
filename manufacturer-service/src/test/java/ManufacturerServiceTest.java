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

import org.pharmacy.model.Manufacturer;
import org.pharmacy.service.ManufacturerServiceImpl;
import org.pharmacy.repository.ManufacturerRepository;

public class ManufacturerServiceTest {
    // Підключення до бази даних
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "55fm74rml");
    ManufacturerRepository manufacturerRepository = new ManufacturerRepository(conn);

    public ManufacturerServiceTest() throws SQLException {
    }

    @Test
    public void testCreateManufacturer() throws SQLException {
        Manufacturer manufacturer = new Manufacturer(10, "Pfizerqwq", "USA", "Helen", "552482",
                "hello", new Date(1,1,2020), new Date(1,1,2020));

        Assertions.assertDoesNotThrow(() -> {
            manufacturerRepository.addManufacturer(manufacturer);
        });
    }

    @Test
    public void testGetManufacturerById() throws SQLException {
        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);
        int id = 10;

        Assertions.assertDoesNotThrow(() -> {
            Manufacturer manufacturer = manufacturerService.getManufacturerById(id);
        });
    }

    @Test
    public void testGetAllManufacturers() throws SQLException {
        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);

        Assertions.assertDoesNotThrow(() -> {
            List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        });
    }

    @Test
    public void testUpdateManufacturer() throws SQLException {
        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);
        Manufacturer manufacturer = new Manufacturer(10, "Pfizerqwq", "USA", "Helen", "552482S",
                "hello", new Date(1,1,2020), new Date(1,1,2020));

        Assertions.assertDoesNotThrow(() -> {
            manufacturerService.updateManufacturer(manufacturer);
        });
    }

    @Test
    public void testDeleteManufacturer() throws SQLException {
        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);
        int id = 10;

        Assertions.assertDoesNotThrow(() -> {
            manufacturerService.deleteManufacturer(id);
        });
    }
}
