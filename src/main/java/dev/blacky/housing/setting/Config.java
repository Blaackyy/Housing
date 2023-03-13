package dev.blacky.housing.setting;

import dev.blacky.housing.Housing;

public final class Config {
    private final Housing plugin;
    public static String DB_URL;

    public Config(Housing plugin) {
        this.plugin = plugin;

        this.init();
    }

    private void init() {
        this.plugin.saveDefaultConfig();
        this.plugin.reloadConfig();

        DB_URL = this.plugin.getConfig().getString("database_url");
    }
}
