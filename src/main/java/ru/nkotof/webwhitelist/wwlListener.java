package ru.nkotof.webwhitelist;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.nkotof.webwhitelist.dev.main;

import static org.bukkit.Bukkit.getServer;

public class wwlListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        String md5name = main.md5(p.getName());
        String params = WebWhiteList.config.getString("request.url")
                + "?name=" + p.getName()
                + "&wmuser=" + main.md5(md5name)
                + "&key=" + main.md5(p.getName() + main.md5(md5name))
                + "&random=0"
                + WebWhiteList.config.getString("request.more-params");
        String response = main.get(params);

        if(response.equalsIgnoreCase(WebWhiteList.config.getString("request.response"))) {
            getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Player " + ChatColor.GREEN + " [ " + p.getName() + " ] " + ChatColor.LIGHT_PURPLE + " can join!");
        } else {
            getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Player " + ChatColor.RED + " [ " + p.getName() + " ] " + ChatColor.LIGHT_PURPLE + " can't join!");
            e.setJoinMessage(null);
            p.kickPlayer("You are not whitelisted on this server!");
        }

    }


}
