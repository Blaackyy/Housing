package dev.blacky.housing.database;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dev.blacky.housing.database.model.HouseTable;
import dev.blacky.housing.database.model.PlayerTable;
import dev.blacky.housing.setting.Config;
import dev.blacky.housing.util.ChatUtils;
import lombok.Getter;

import java.sql.SQLException;

public final class DatabaseConnector {
    @Getter
    private static JdbcPooledConnectionSource connectionSource;

    public DatabaseConnector() throws SQLException {
        connectionSource = new JdbcPooledConnectionSource(Config.DB_URL);
        connectionSource.setCheckConnectionsEveryMillis(60 * 1000);
        connectionSource.setMaxConnectionAgeMillis(5 * 60 * 1000);

        this.init();
    }

    private void init() {
        try {
            ChatUtils.logInfo("Attempting to create tables if not exists");
            TableUtils.createTableIfNotExists(connectionSource, HouseTable.class);
            TableUtils.createTableIfNotExists(connectionSource, PlayerTable.class);
        } catch (Exception e) {
            ChatUtils.logError("Failed to create tables: " + e.getMessage());
        }
    }
}
