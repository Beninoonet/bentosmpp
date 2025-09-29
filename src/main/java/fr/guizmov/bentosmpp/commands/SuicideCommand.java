package fr.guizmov.bentosmpp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class SuicideCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if(commandSender instanceof Player player){
            player.setHealth(0);
            player.sendMessage("§3[BSMP] §cVous vous êtes suicidé.");
        } else
        {
            commandSender.sendMessage("§cVous devez être un joueur");
        }

        return true;
    }
}
