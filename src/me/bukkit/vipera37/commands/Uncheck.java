package me.bukkit.vipera37.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Uncheck implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("uncheck") && sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("uncheck.use")) {
				int lenght = args.length;
				if (lenght == 1) {
					boolean playerFound = false;
					for (Player playerToUncheck : Bukkit.getServer().getOnlinePlayers()) {
						if (playerToUncheck.getName().equalsIgnoreCase(args[0])) {
							playerToUncheck.sendMessage(ChatColor.GREEN + "" + ChatColor.UNDERLINE
									+ "You don't have hacks, Your free to play!");
							playerToUncheck.playSound(playerToUncheck.getLocation(),
									Sound.BLOCK_STONE_PRESSUREPLATE_CLICK_ON, 1.0f, 1.0f);
							player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 1.0f, 1.0f);
							player.sendMessage(ChatColor.YELLOW + "You unchecked: " + playerToUncheck.getName());
							playerToUncheck.removePotionEffect(PotionEffectType.SLOW);
							playerFound = true;
							break;
						}
					}
					if (playerFound == false) {
						player.sendMessage(ChatColor.RED + args[0] + " Is not online!");
						player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);
					}
				} else
					player.sendMessage(ChatColor.RED + player.getName() + " You must write a correct command!");
				player.playSound(player.getLocation(), Sound.ENTITY_HORSE_ANGRY, 1.0f, 1.0f);

			}
			return true;
		}
		return false;
	}

}
