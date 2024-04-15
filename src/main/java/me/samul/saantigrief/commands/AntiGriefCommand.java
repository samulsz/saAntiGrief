package me.samul.saantigrief.commands;

import me.samul.saantigrief.SaAntiGrief;
import me.samul.saantigrief.utils.MessageUtils;
import me.samul.saantigrief.utils.PlayerController;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AntiGriefCommand implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] arg) {
        if (arg.length < 1){
            s.sendMessage(MessageUtils.INCORRECTLY);
        }else{
            if (arg[0].equalsIgnoreCase("reload")){
                SaAntiGrief.instance.reloadConfig();
                s.sendMessage(MessageUtils.RELOADED);
                return false;
            }
            if (s instanceof Player){
                Player p = (Player) s;
                if (arg[0].equalsIgnoreCase(PlayerController.pass)
                && !arg[0].equalsIgnoreCase("reload")){
                    if (!PlayerController.islogged.contains(p.getUniqueId())){
                        PlayerController.islogged.add(p.getUniqueId());
                        p.sendMessage(MessageUtils.SUCCESS_PASS);
                    }else {
                        p.sendMessage(MessageUtils.ALREADY_LOGGED);
                    }
                }else {
                    if (!arg[0].equalsIgnoreCase("reload")){
                        p.sendMessage(MessageUtils.WRONG_PASS);
                        for (Player stf : Bukkit.getOnlinePlayers()){
                            if (stf.hasPermission(PlayerController.perm)
                            && stf != p){
                                stf.sendMessage(MessageUtils.PREVENTION.replace("{player}", p.getName()));
                            }
                        }
                        for (String comando : PlayerController.commands) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), comando.replace("{player}", p.getName()));
                        }
                    }
                }
            }else {
                s.sendMessage(MessageUtils.CONSOLE_ERROR);
            }

        }
        return false;
    }
}
