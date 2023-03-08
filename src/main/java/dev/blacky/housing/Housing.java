package dev.blacky.housing;

import dev.blacky.housing.manager.HouseManager;
import dev.blacky.housing.manager.PlayerManager;
import dev.blacky.housing.manager.RoleManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Housing extends JavaPlugin {
    @Getter
    private HouseManager houseManager;
    @Getter
    private RoleManager roleManager;
    @Getter
    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        this.houseManager = new HouseManager(this);
        this.roleManager = new RoleManager(this);
        this.playerManager = new PlayerManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
