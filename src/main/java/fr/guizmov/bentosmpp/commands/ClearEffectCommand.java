package fr.guizmov.bentosmpp.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearEffectCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        if(!(commandSender instanceof Player) && args.length == 0) {
            commandSender.sendMessage("§3[BSMP] §cSeul un joueur se retirer les effets de potions lui-même.");

            return true;
        }
        if (args.length == 0) {
            Player player = (Player) commandSender;
            player.clearActivePotionEffects();
            player.sendMessage("§2Tu n'as désormais plus d'effets de potions!");

            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            commandSender.sendMessage("§3[BSMP] §cCe joueur n'existe pas ou n'est pas connecté.");
            return true;
        }

        target.clearActivePotionEffects();
        target.sendMessage("§7Tu n'as désormais plus d'effets de potions grâce à §l" + commandSender.getName());
        commandSender.sendMessage("§2" + target.getName() + "§7 n'as plus d'effets de potions!.");

        return true;
    }
}
