package io.github.xbrain978.ReportPlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportPluginCommandExecutor implements CommandExecutor {
	private final ReportPlugin plugin;

	public ReportPluginCommandExecutor(ReportPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player user = (Player) sender;
		String reported = args[0];
		String reason = args[1 - 10];
		if (cmd.getName().equalsIgnoreCase("report")) {
			if (args.length < 2) {
				sender.sendMessage("Not enough arguments!");
				return false;
			} else {
				sender.sendMessage("Reported" + args[0]);
				WriteFiles.create(reported, user, reason);
				return true;
			}
		}
		return false;
	}
}