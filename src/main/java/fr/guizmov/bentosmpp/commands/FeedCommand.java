package fr.guizmov.bentosmpp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if(commandSender instanceof Player player){
            player.setFoodLevel(20);
            player.setSaturation(20);

            commandSender.sendMessage("§3[BSMP] §3Vous êtes désormais rassassier !");

        } else {
            commandSender.sendMessage("§c Vous devez être un joueur");
        }

        return true;
    }
}
