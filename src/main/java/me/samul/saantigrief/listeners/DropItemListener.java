package me.samul.saantigrief.listeners;

import me.samul.saantigrief.utils.MessageUtils;
import me.samul.saantigrief.utils.PlayerController;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItemListener implements Listener {

    @EventHandler
    public void ondro(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if (p.hasPermission(PlayerController.perm)
                && !PlayerController.islogged.contains(p.getUniqueId())){
            e.setCancelled(true);
            p.sendMessage(MessageUtils.BLOCKED);
        }
    }
}
