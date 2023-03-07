package dev.blacky.housing.manager;

import dev.blacky.housing.Housing;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class PlayerManager {
    private final Housing plugin;
    private final Map<UUID, String> playerHouses;

    public PlayerManager(Housing plugin) {
        this.plugin = plugin;
        this.playerHouses = new HashMap<>();
    }

    public void addPlayer(UUID uuid, String house) {
        this.playerHouses.put(uuid, house);
    }

    public void removePlayer(UUID uuid) {
        this.playerHouses.remove(uuid);
    }

    public boolean hasPlayerAHouse(UUID uuid) {
        return this.playerHouses.containsKey(uuid);
    }

    public String getPlayerHouse(UUID uuid) {
        return this.playerHouses.get(uuid);
    }
}
