package fr.guizmov.bentosmpp.commands;

import com.google.common.base.Joiner;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


import java.util.Arrays;
import java.util.Map;
import java.util.UUID;


public class MessageCommand implements CommandExecutor {

    private final Map<UUID, UUID> lastMessager;

    public MessageCommand(Map<UUID, UUID> lastMessager) {
        this.lastMessager = lastMessager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

            if(args.length < 2){
                commandSender.sendMessage("§3[BSMP] §c/msg <joueur> <message>");
                return true;
            }

            Player p = (Player) commandSender;

            Player target = Bukkit.getPlayer(args[0]);
            String message = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

            if(target == null || !target.isOnline()) {

                // MESSAGE D'ERREUR
                p.sendMessage("§3[BSMP] §cCe joueur n'existe pas ou n'est pas connecté.");
            } else{
                // MESSAGE ENVOYER
                target.sendMessage(Component.text("§3[%s] ".formatted(p.getName()) + "§r" +message)
                        .clickEvent(ClickEvent.suggestCommand("/r " + target.getName()))
                        .hoverEvent(Component.text("§7Répondre à §5%s".formatted(p.getName())))

                );
                // MESSAGE DE CONFIRMATION D'ENVOI
                p.sendMessage(Component.text("§6[Envoyé à %s] ".formatted(target.getName()) + "§r" + message)
                        .clickEvent(ClickEvent.suggestCommand("/r " + target.getName()))
                        .hoverEvent(Component.text("§7Renvoyer un message à §5%s".formatted(target.getName())))

                );
                lastMessager.put(p.getUniqueId(), p.getUniqueId());
                lastMessager.put(target.getUniqueId(), target.getUniqueId());
            }

        return true;
    }
}
