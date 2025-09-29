package fr.guizmov.bentosmpp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        if(!(commandSender instanceof Player) && args.length == 0) {
            commandSender.sendMessage("§3[BSMP] §cSeul un joueur peut se soigné lui-même");

            return true;
        }
        if (args.length == 0) {
            Player player = (Player) commandSender;
            player.setHealth(player.getAttribute(Attribute.MAX_HEALTH).getBaseValue());
            player.setFoodLevel(20);
            player.sendMessage("§2Tu es désormais en pleine santé !");

            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            commandSender.sendMessage("§3[BSMP] §cCe joueur n'existe pas ou n'est pas connecté.");
            return true;
        }

        target.setHealth(target.getAttribute(Attribute.MAX_HEALTH).getBaseValue());
        target.setFoodLevel(20);
        target.sendMessage("§7Tu es désormais en pleine santé grâce à §l" + commandSender.getName());
        commandSender.sendMessage("§2" + target.getName() + "§7 a été soigné.");

        return true;
    }
}
