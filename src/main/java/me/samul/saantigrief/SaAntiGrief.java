package me.samul.saantigrief;

import me.samul.saantigrief.commands.AntiGriefCommand;
import me.samul.saantigrief.listeners.*;
import me.samul.saantigrief.utils.MessageUtils;
import me.samul.saantigrief.utils.PlayerController;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SaAntiGrief extends JavaPlugin {

    public static JavaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        loadEvents();
        MessageUtils.loadmessages();
        Bukkit.getConsoleSender().sendMessage(MessageUtils.LOAD_PLUGIN);
        getCommand("antigrief").setExecutor(new AntiGriefCommand());
        getCommand("antigrief").setAliases(MessageUtils.aliases);
    }

    @Override
    public void onDisable() {
        PlayerController.islogged.clear();
    }

    private void loadEvents(){
        if (getConfig().getBoolean("Configuration.reset-gamemode")){
            Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        }
        if (getConfig().getBoolean("Configuration.prevent-break")){
            Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
        }
        if (getConfig().getBoolean("Configuration.prevent-place")){
            Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);
        }
        if (getConfig().getBoolean("Configuration.prevent-pickup")){
            Bukkit.getPluginManager().registerEvents(new PickupItemListener(), this);
        }
        if (getConfig().getBoolean("Configuration.prevent-drop")){
            Bukkit.getPluginManager().registerEvents(new DropItemListener(), this);
        }
        if (getConfig().getBoolean("Configuration.prevent-commands")){
            Bukkit.getPluginManager().registerEvents(new CmdPreprocessListener(), this);
        }
        if (getConfig().getBoolean("Configuration.prevent-teleport")){
            Bukkit.getPluginManager().registerEvents(new PlayerTeleportListener(), this);
        }
        if (getConfig().getBoolean("Configuration.prevent-chests")){
            Bukkit.getPluginManager().registerEvents(new OpenChestListener(), this);
        }
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
    }
}
