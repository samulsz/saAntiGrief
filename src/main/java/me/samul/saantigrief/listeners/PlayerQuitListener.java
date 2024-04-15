package me.samul.saantigrief.listeners;

import me.samul.saantigrief.utils.PlayerController;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onquit(PlayerQuitEvent e){
        PlayerController.islogged.remove(e.getPlayer().getUniqueId());
    }
}
