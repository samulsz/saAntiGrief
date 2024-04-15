package me.samul.saantigrief.listeners;

import me.samul.saantigrief.utils.MessageUtils;
import me.samul.saantigrief.utils.PlayerController;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

public class OpenChestListener implements Listener {
    @EventHandler
    public void onopen(InventoryOpenEvent e){
        if (e.getInventory().getType().equals(InventoryType.CHEST)
        && e.getPlayer() instanceof Player
        || e.getInventory().getType().equals(InventoryType.ENDER_CHEST)
        && e.getPlayer() instanceof Player ){
            Player p = (Player) e.getPlayer();
            if (p.hasPermission(PlayerController.perm)
                    && !PlayerController.islogged.contains(p.getUniqueId())){
                e.setCancelled(true);
                p.sendMessage(MessageUtils.BLOCKED);
            }
        }
    }
}
