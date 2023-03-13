package dev.blacky.housing;

import dev.blacky.housing.command.CommandProcessor;
import dev.blacky.housing.database.DatabaseConnector;
import dev.blacky.housing.manager.HouseManager;
import dev.blacky.housing.manager.PlayerManager;
import dev.blacky.housing.manager.RoleManager;
import dev.blacky.housing.setting.Config;
import dev.blacky.housing.util.ChatUtils;
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
        new Config(this);

        try {
            new DatabaseConnector();
            ChatUtils.logSuccess("Database connection established");
        } catch (Exception e) {
            ChatUtils.logError("Database connection failed");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.houseManager = new HouseManager(this);
        this.roleManager = new RoleManager(this);
        this.playerManager = new PlayerManager(this);

        getServer().getCommandMap().register("housing", new CommandProcessor(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
