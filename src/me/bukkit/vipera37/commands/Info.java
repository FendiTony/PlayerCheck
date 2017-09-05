package me.bukkit.vipera37.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Info implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("cinfo") && sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Plugin written by: " + ChatColor.RED + " FendiTony777");
			player.sendMessage(ChatColor.GOLD + "PlayerCheck version: " + ChatColor.RED + " 2.1.3");
			player.sendMessage(ChatColor.GOLD + "New features will come soon!");
			return true;
		}
		return false;
	}

}
