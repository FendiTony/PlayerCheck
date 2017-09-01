package me.bukkit.vipera37;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;

import org.bukkit.Sound;

import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

import org.bukkit.permissions.Permission;

import org.bukkit.plugin.PluginManager;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.potion.PotionEffect;

import org.bukkit.potion.PotionEffectType;

public class PlayerCheck extends JavaPlugin {

	public Permission playerPermission = new Permission("check.use");

	@Override

	public void onEnable() {

		getLogger().info("PlayerCheck has been enabled correctly!");

		PluginManager pm = getServer().getPluginManager();

		pm.addPermission(playerPermission);

		new PlayerListener(this);

	}

	@Override

	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("check") && sender instanceof Player) {

			Player player = (Player) sender;

			if (player.hasPermission("check.use")) {

				int lenght = args.length;

				if (lenght == 1) {

					boolean playerFound = false;

					for (Player playerToCheck : Bukkit.getServer().getOnlinePlayers()) {

						if (playerToCheck.getName().equalsIgnoreCase(args[0])) {

							playerToCheck.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20000, 9));

							playerToCheck.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD

									+ "Stop RIGHT NOW! Admins will check if you're using hacks.");

							playerToCheck.sendMessage(ChatColor.DARK_RED + " You're going to be checked by: "

									+ ChatColor.GOLD + player.getName() + ChatColor.RESET + "" + ChatColor.DARK_RED + ""

									+ " If you disconnect you will get banned!!");
							playerToCheck.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD
									+ "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-");
							player.sendMessage(ChatColor.YELLOW + player.getName() + "You succesfully adverted " + playerToCheck.getName());

							playerFound = true;

							break;

						}

					}

					if (playerFound == false) {

						player.sendMessage(ChatColor.RED + args[0] + " Is not online");

						player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);

					}

				} else

					player.sendMessage(ChatColor.RED + player.getName() + " You must write a correct command!");

				player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);

			}

			return true;

		}

		return false;

	}

}