package fr.guizmov.bentosmpp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.jetbrains.annotations.NotNull;

public class KillCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        if(args.length != 1){
            commandSender.sendMessage("§3[BSMP] §c/kill <joueur>");
        } else{
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null){
                commandSender.sendMessage("§3[BSMP] §cCe joueur n'existe pas ou n'est pas connecté.");
            } else {
                target.setHealth(0);
                commandSender.sendMessage("§7§l" + target.getName() + "§7 a été tué !");
                target.sendMessage("§7Vous avez été tué par §c" + commandSender.getName());
            }
        }

        return true;
    }
}
