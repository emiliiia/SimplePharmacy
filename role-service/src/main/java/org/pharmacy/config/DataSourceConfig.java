package org.pharmacy.config;
/*
  @author emilia
  @project pharmacy
  @class DataSourceConfig
  @version 1.0.0
  @since 05.04.2023 - 17:55
*/

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSourceConfig {
    private static final String CONFIG_FILE = "config.properties";

    public DataSourceConfig() throws ConfigurationException, SQLException {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<PropertiesConfiguration> builder =
                new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(CONFIG_FILE));
        Configuration config = builder.getConfiguration();

        // читаємо налаштування з файлу config.properties
        String dbUrl = config.getString("db.url");
        String username = config.getString("db.username");
        String password = config.getString("db.password");
        int port = config.getInt("server.port");

        // далі використовуємо отримані дані для налаштування сервісу та бази даних
        Connection conn = DriverManager.getConnection(dbUrl, username, password);
    }

}