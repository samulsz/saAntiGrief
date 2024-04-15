package me.samul.saantigrief.utils;

import me.samul.saantigrief.SaAntiGrief;
import org.bukkit.Bukkit;

import java.util.List;

public class MessageUtils {

    public static String WRONG_PASS;
    public static String SUCCESS_PASS;
    public static String NO_PERM;
    public static String NO_LOGGED;
    public static String INCORRECTLY;
    public static String RELOADED;
    public static String ALREADY_LOGGED;
    public static String PREVENTION;
    public static String CONSOLE_ERROR;
    public static String LOAD_PLUGIN;
    public static String BLOCKED;

    public static void loadmessages(){
        WRONG_PASS = replaced(getString("Messages.login-failure"));
        SUCCESS_PASS = replaced(getString("Messages.login-success"));
        NO_PERM = replaced(getString("Messages.no-permission"));
        NO_LOGGED = replaced(getString("Messages.is-not-logged"));
        INCORRECTLY = replaced(getString("Messages.incorrectly-usage"));
        RELOADED = replaced(getString("Messages.reloaded"));
        ALREADY_LOGGED = replaced(getString("Messages.already-logged"));
        PREVENTION = replaced(getString("Messages.staff-wrong-pass"));
        CONSOLE_ERROR = replaced(getString("Messages.only-players"));
        LOAD_PLUGIN = replaced("&a[saAntiGrief] This plugin has bem initialized!");
        BLOCKED = replaced(getString("Messages.blocked-message"));
        Bukkit.getConsoleSender().sendMessage("§a[saAntigrief] Messages uploaded successfully!");

    }

    public static String getString(String path) {
        return SaAntiGrief.instance.getConfig().getString(path);
    }
    public static String replaced(String replace){
        return replace.replace("&", "§");
    }
    public static List<String> aliases = SaAntiGrief.instance.getConfig().getStringList("Configuration.aliases");
}
