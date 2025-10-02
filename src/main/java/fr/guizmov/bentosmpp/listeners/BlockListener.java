package fr.guizmov.bentosmpp.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

    // CE QUI N'ONT PAS LA PERMISSION NE PEUVENT PAS POSER DE TNT

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if(!player.hasPermission("bsmp.placetnt")) {
            event.setCancelled(true);
            player.sendMessage("§5[BSMP] §7Vous ne pouvez pas poser de TNT");
        }

    }
}
