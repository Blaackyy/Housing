package dev.blacky.housing.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.table.DatabaseTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@DatabaseTable(tableName = "players")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class PlayerTable extends BaseDaoEnabled<PlayerTable, UUID> {
    @DatabaseField(id = true)
    private UUID playerId;
    @DatabaseField
    private String name;
    @DatabaseField
    private UUID memberOf;

    public PlayerTable(UUID playerId) {
        this.playerId = playerId;
    }

    public PlayerTable(UUID playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }
}
