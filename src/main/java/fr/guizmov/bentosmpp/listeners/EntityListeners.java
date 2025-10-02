package fr.guizmov.bentosmpp.listeners;

import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;

public class EntityListeners implements Listener {

    @EventHandler
    public void onItemMerge(ItemMergeEvent event)
    {
        Item source = event.getEntity();
        Item target = event.getTarget();

        if(source.getWorld().getName().equals("world"))
        {
            event.setCancelled(true);
        }
    }
}
