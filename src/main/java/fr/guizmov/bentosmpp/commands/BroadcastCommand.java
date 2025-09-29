package fr.guizmov.bentosmpp.commands;

import com.google.common.base.Joiner;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        if (args.length == 0) {
            commandSender.sendMessage("§3[BSMP] §c/broadcast <message>");
        } else {
            String message = Joiner.on(" ").join(args);
            for(Player player : Bukkit.getOnlinePlayers()){
                player.sendMessage("§3[BSMP] §7§l%s".formatted(message));
            }
        }

        return true;
    }
}
