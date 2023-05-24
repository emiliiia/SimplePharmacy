/*
  @author emilia
  @project pharmacy
  @class DrugServiceTest
  @version 1.0.0
  @since 21.05.2023 - 22:50
*/

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.pharmacy.controller.DrugController;
import org.pharmacy.model.Drug;
import org.pharmacy.service.DrugServiceImpl;
import org.pharmacy.repository.DrugRepository;

public class DrugServiceTest {
    // Підключення до бази даних
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simplePhamacy", "postgres", "55fm74rml");
    DrugRepository drugRepository = new DrugRepository(conn);

    public DrugServiceTest() throws SQLException {
    }

    @Test
    public void testCreateDrug() throws SQLException {
        Drug drug = new Drug(12, "drug", new Date(1,1,2020), 1.0, 1.0, 1, 1,
                "hello", new Date(1,1,2020), new Date(1,1,2020));

        Assertions.assertDoesNotThrow(() -> {
            drugRepository.addDrug(drug);
        });
    }

    @Test
    public void testGetDrugById() throws SQLException {
        DrugServiceImpl drugService = new DrugServiceImpl(drugRepository);
        int id = 1;

        Assertions.assertDoesNotThrow(() -> {
            Drug drug = drugService.getDrugById(id);
        });
    }

    @Test
    public void testGetAllDrugs() throws SQLException {
        DrugServiceImpl drugService = new DrugServiceImpl(drugRepository);

        Assertions.assertDoesNotThrow(() -> {
            List<Drug> drugs = drugService.getAllDrugs();
        });
    }

    @Test
    public void testUpdateDrug() throws SQLException {
        DrugServiceImpl drugService = new DrugServiceImpl(drugRepository);
        Drug drug = new Drug(12, "drug", new Date(1,1,2020), 1.0, 1.0, 1, 1,
                "hello", new Date(1,1,2020), new Date(1,1,2020));

        Assertions.assertDoesNotThrow(() -> {
            drugService.updateDrug(drug);
        });
    }

    @Test
    public void testDeleteDrug() throws SQLException {
        DrugServiceImpl drugService = new DrugServiceImpl(drugRepository);
        int id = 12;

        Assertions.assertDoesNotThrow(() -> {
            drugService.deleteDrug(id);
        });
    }
}
