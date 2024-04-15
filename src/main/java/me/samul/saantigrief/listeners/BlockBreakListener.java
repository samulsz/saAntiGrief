package me.samul.saantigrief.listeners;

import me.samul.saantigrief.utils.MessageUtils;
import me.samul.saantigrief.utils.PlayerController;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onbreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if (p.hasPermission(PlayerController.perm)
        && !PlayerController.islogged.contains(p.getUniqueId())){
            e.setCancelled(true);
            p.sendMessage(MessageUtils.BLOCKED);
        }
    }
}
