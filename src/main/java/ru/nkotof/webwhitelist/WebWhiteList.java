package ru.nkotof.webwhitelist;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class WebWhiteList extends JavaPlugin {
    
    public static FileConfiguration config;
    ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public void onEnable() {
        config = getConfig();
        this.getServer().getPluginManager().registerEvents(new wwlListener(), this);
        this.saveDefaultConfig();

        console.sendMessage(ChatColor.GREEN + "WebWL loaded!");
    }

    @Override
    public void onDisable() {
        console.sendMessage(ChatColor.GOLD + "WebWL unloaded!");
    }
}
