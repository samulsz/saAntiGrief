package me.samul.saantigrief.listeners;

import me.samul.saantigrief.SaAntiGrief;
import me.samul.saantigrief.utils.MessageUtils;
import me.samul.saantigrief.utils.PlayerController;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;
import java.util.stream.Collectors;

public class CmdPreprocessListener implements Listener {

    List<String> allowedCommands = null;
    public CmdPreprocessListener() {
        List<String> commands = SaAntiGrief.instance.getConfig().getStringList("Configuration.blocked-commands");
        allowedCommands = commands.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String[] commandParts = e.getMessage().substring(1).split(" ");
        String command = commandParts[0].toLowerCase();
        if (allowedCommands.contains("/" + command)) {
            e.setCancelled(true);
            p.sendMessage(MessageUtils.BLOCKED);
        }

    }
}