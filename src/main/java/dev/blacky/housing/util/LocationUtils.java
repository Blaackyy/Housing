package dev.blacky.housing.util;

import org.bukkit.Location;

public final class LocationUtils {
    public static String serializeLocation(Location location) {
        return location.getWorld().getName() + "," + location.getX() + "," + location.getY() + "," + location.getZ();
    }

    public static Location deserializeLocation(String location) {
        String[] split = location.split(",");
        return new Location(
                org.bukkit.Bukkit.getWorld(split[0]),
                Double.parseDouble(split[1]),
                Double.parseDouble(split[2]),
                Double.parseDouble(split[3])
        );
    }
}
