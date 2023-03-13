package dev.blacky.housing.database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dev.blacky.housing.database.model.HouseTable;
import dev.blacky.housing.database.model.PlayerTable;
import dev.blacky.housing.setting.Config;
import dev.blacky.housing.util.ChatUtils;
import lombok.Getter;

import java.sql.SQLException;

public final class DatabaseConnector {
    @Getter
    private static ConnectionSource connectionSource;

    public DatabaseConnector() throws SQLException {
        connectionSource = new JdbcConnectionSource(Config.DB_URL);
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
