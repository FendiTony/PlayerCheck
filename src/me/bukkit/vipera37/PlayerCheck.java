package me.bukkit.vipera37;

import org.bukkit.permissions.Permission;

import org.bukkit.plugin.PluginManager;

import org.bukkit.plugin.java.JavaPlugin;

import me.bukkit.vipera37.commands.Check;
import me.bukkit.vipera37.commands.Info;
import me.bukkit.vipera37.commands.Uncheck;

public class PlayerCheck extends JavaPlugin {

	public Permission playerPermission = new Permission("check.use");

	@Override

	public void onEnable() {

		getLogger().info("PlayerCheck has been enabled correctly!");

		PluginManager pm = getServer().getPluginManager();

		pm.addPermission(playerPermission);

		new PlayerListener(this);
		getCommand("check").setExecutor(new Check());
		getCommand("uncheck").setExecutor(new Uncheck());
		getCommand("cinfo").setExecutor(new Info());

	}

	@Override

	public void onDisable() {

	}

}