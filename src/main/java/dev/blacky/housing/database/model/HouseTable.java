package dev.blacky.housing.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@DatabaseTable(tableName = "houses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class HouseTable {
    @DatabaseField(id = true)
    private UUID houseId;
    @DatabaseField(index = true)
    private String houseName;
    @DatabaseField
    private String houseData;

    public HouseTable(String houseName) {
        this.houseName = houseName;
    }

    public HouseTable(UUID houseId, String houseName) {
        this.houseId = houseId;
        this.houseName = houseName;
    }
}
