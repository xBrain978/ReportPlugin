package io.github.xbrain978.ReportPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class WriteFiles {
	static File cfile;
	static FileConfiguration config;

	public static void create(String reported, Player user, String reason) {
		if (!cfile.exists()) {
			try {
				cfile.createNewFile();
			} catch (Exception e) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error creating " + cfile.getName() + "!");
			}
		}
		String u = user.toString();
		String[] reportee = { u, reason };
		config = YamlConfiguration.loadConfiguration(cfile);
		config.set(reported, Arrays.asList(reportee));
		try {
			config.save(cfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static File getfile() {
		return cfile;
	}
}
