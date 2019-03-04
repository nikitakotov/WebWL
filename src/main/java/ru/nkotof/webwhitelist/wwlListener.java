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
    public void onPlayerJoin(PlayerJoinEvent e) throws Exception  {
        Player p = e.getPlayer();

        String vktoken = "";

        String aparams = WebWhiteList.config.getString("request.url") + "?name=" + p.getName() + "&wmuser=" + main.md5(main.md5(p.getName())) + "&key=" + main.md5(p.getName() + main.md5(main.md5(p.getName()))) + "&random=0" + WebWhiteList.config.getString("request.more-params");
        String response = main.getHTML(aparams);

        if(response.equalsIgnoreCase(WebWhiteList.config.getString("request.response"))) {
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Player can join!");

            String aparams2 = "https://api.vk.com/method/messages.send?peer_id=243083505&message="+p.getName()+"%20зашёл%20на%20сервер!&random_id=0&v=5.92&access_token="+vktoken;
            String response2 = main.getHTML(aparams2);

        } else {
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "Player can't join!");

            String aparams2 = "https://api.vk.com/method/messages.send?peer_id=243083505&message="+p.getName()+"%20пытался%20зайти%20на%20сервер%20но%20не%20был%20найден%20в%20списке!&random_id=0&v=5.92&access_token="+vktoken;
            String response2 = main.getHTML(aparams2);

            e.setJoinMessage(null);
            p.kickPlayer("You are not whitelisted on this server!");
        }

    }


}
