package fr.guizmov.bentosmpp.commands;

import com.google.common.base.Joiner;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

public class ReplyCommand implements CommandExecutor {

    private final Map<UUID, UUID> lastMessager;

    public ReplyCommand(Map<UUID, UUID> lastMessager) {
        this.lastMessager = lastMessager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        Player player = (Player) commandSender;

        if (args.length < 1) {
            player.sendMessage("§cUsage: /reply <message>");
            return true;
        }

        UUID last = lastMessager.get(player.getUniqueId());
        if (last == null) {
            player.sendMessage("§3[BSMP] §cAucune personne trouver");
            return true;
        }

        Player target = Bukkit.getPlayer(last);
        if (target == null || !target.isOnline()) {
            player.sendMessage("§3[BSMP] §cCe joueur n'existe pas ou n'est pas connecté.");
            return true;
        }

        String message = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

        // MESSAGE ENVOYER
        target.sendMessage(Component.text("§3[%s] ".formatted(player.getName()) + "§r" + message)
                .clickEvent(ClickEvent.suggestCommand("/r " + target.getName()))
                .hoverEvent(Component.text("§7Répondre à §5%s".formatted(player.getName())))

        );
        // MESSAGE DE CONFIRMATION D'ENVOI
        player.sendMessage(Component.text("§6[Envoyé à %s] ".formatted(target.getName()) + "§r" + message)
                .clickEvent(ClickEvent.suggestCommand("/r " + target.getName()))
                .hoverEvent(Component.text("§7Renvoyer un message à §5%s".formatted(target.getName())))

        );

        return true;
    }
}
