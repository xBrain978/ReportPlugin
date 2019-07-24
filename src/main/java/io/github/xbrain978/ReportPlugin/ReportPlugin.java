package io.github.xbrain978.ReportPlugin;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ReportPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("Report Plugin has been enabled");
		this.getCommand("report").setExecutor(new ReportPluginCommandExecutor(this));
		if (!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
}