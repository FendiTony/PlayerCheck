package me.bukkit.vipera37;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class PlayerListener implements Listener {

	public PlayerListener(PlayerCheck plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public void onCheckCommand(PlayerKickEvent event) {
		
	}
	
		
	
	
	
}
