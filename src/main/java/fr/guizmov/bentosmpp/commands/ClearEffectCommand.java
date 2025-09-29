package fr.guizmov.bentosmpp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearEffectCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if(commandSender instanceof Player player){
            player.clearActivePotionEffects();

            player.sendMessage("§3[BSMP] §3Effet de potions supprimés !");

        } else {
            commandSender.sendMessage("§cVous devez être un joueur");
        }

        return true;
    }
}
