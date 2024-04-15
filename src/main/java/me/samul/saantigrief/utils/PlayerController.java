package me.samul.saantigrief.utils;

import me.samul.saantigrief.SaAntiGrief;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerController{

    public static List<UUID> islogged = new ArrayList<>();
    public static int attempts =  SaAntiGrief.instance.getConfig().getInt("Configuration.attempts");
    public static String pass = SaAntiGrief.instance.getConfig().getString("Configuration.password");
    public static String perm = SaAntiGrief.instance.getConfig().getString("Configuration.permission");
    public static List<String> commands = SaAntiGrief.instance.getConfig().getStringList("Configuration.wrong-pass-commands");


}
