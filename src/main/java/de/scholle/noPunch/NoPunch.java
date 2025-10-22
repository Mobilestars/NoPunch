package de.scholle.noPunch;

import org.bukkit.plugin.java.JavaPlugin;

public class NoPunch extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PunchEnchantBlocker(this), this);
        getLogger().info("NoPunch plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoPunch plugin disabled!");
    }
}
