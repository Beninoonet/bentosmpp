package fr.guizmov.bentosmpp.listeners;

import fr.guizmov.bentosmpp.Bentosmpp;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.eclipse.sisu.launch.Main;

public class PlayerListener implements Listener {

    // JOIN MESSAGE

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.joinMessage(
                Component.text(p.getName())
                        .color(NamedTextColor.DARK_PURPLE)
                        .clickEvent(ClickEvent.suggestCommand("/msg " + p.getName()))
                        .hoverEvent(Component.text("§7Envoyer un message à §5%s".formatted(p.getName())))
                        .append(Component.text("§7 a rejoint le serveur."))
        );
    }

    // QUIT MESSAGE

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.quitMessage(
                Component.text(p.getName())
                    .color(NamedTextColor.DARK_PURPLE)

                    .append(Component.text("§7 a quitter le serveur."))
        );
    }

    // DEATH PLAYER MESSAGE

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        if(p.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.deathMessage(Component.text("§c[Mort] §5%s §7viens de tomber de très haut !".formatted(p.getName())));
        } else {
            e.deathMessage(Component.text("§c[Mort] §5%s §7est simplement mort !".formatted(p.getName())));
        }


    }

    // Annule la téléportation de CHORUS_FRUIT

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e){
        Player p = e.getPlayer();
        if(e.getCause() == PlayerTeleportEvent.TeleportCause.CONSUMABLE_EFFECT) {
            e.setCancelled(true);
        }
    }
}
