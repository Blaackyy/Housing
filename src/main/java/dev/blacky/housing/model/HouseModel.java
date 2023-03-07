package dev.blacky.housing.model;

import dev.blacky.housing.util.LocationUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.casperge.realisticseasons.api.SeasonsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public final class HouseModel {
    private UUID id;
    private String name;
    private String description;
    private String spawnLocation;
    private Map<UUID, String> members; // UUID, Role
    private Boolean isAdopting;
    private Integer foundationYear;

    public HouseModel(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = "";
        this.spawnLocation = "";
        this.members = new HashMap<>();
        this.isAdopting = false;
        foundationYear = SeasonsAPI.getInstance().getDate(Bukkit.getWorld("world")).getYear();
    }

    public void addMember(UUID uuid, String role) {
        this.members.put(uuid, role);
    }

    public void removeMember(UUID uuid) {
        this.members.remove(uuid);
    }

    public String getRole(UUID uuid) {
        return this.members.get(uuid);
    }

    public boolean hasMember(UUID uuid) {
        return this.members.containsKey(uuid);
    }

    public Location getSpawnLocation() {
        return LocationUtils.deserializeLocation(this.spawnLocation);
    }

    public void setSpawnLocation(Location location) {
        this.spawnLocation = LocationUtils.serializeLocation(location);
    }
}
