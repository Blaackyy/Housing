package dev.blacky.housing.manager;

import dev.blacky.housing.Housing;
import dev.blacky.housing.model.HouseModel;

import java.util.HashMap;
import java.util.Map;

public final class HouseManager {
    private final Housing plugin;
    private final Map<String, HouseModel> houses;

    public HouseManager(Housing plugin) {
        this.plugin = plugin;
        this.houses = new HashMap<>();
    }

    public void addHouse(HouseModel house) {
        this.houses.put(house.getName(), house);
    }

    public void removeHouse(String name) {
        this.houses.remove(name);
    }

    public boolean hasHouse(String name) {
        return this.houses.containsKey(name);
    }

    public HouseModel getHouse(String name) {
        return this.houses.get(name);
    }
}
