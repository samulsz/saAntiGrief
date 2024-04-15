package me.samul.saantigrief.listeners;

import me.samul.saantigrief.utils.MessageUtils;
import me.samul.saantigrief.utils.PlayerController;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onjoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (p.hasPermission(PlayerController.perm)){
            p.setGameMode(GameMode.SURVIVAL);
        }
    }
}
