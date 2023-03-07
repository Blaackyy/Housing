package dev.blacky.housing.setting;

import com.osiris.dyml.Yaml;

public final class Settings {
    private final Yaml yaml;

    public Settings() {
        this.yaml = new Yaml(System.getProperty("user.dir") + "/plugins/Housing/config.yml");
        this.init();
    }

    private void init() {
        
    }


}
