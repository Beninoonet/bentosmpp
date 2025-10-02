package fr.guizmov.bentosmpp;

import fr.guizmov.bentosmpp.commands.*;
import fr.guizmov.bentosmpp.listeners.BlockListener;
import fr.guizmov.bentosmpp.listeners.EntityListeners;
import fr.guizmov.bentosmpp.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class Bentosmpp extends JavaPlugin {

    private final Map<UUID, UUID> lastMessager = new HashMap<>();

    @Override
    public void onEnable() {
        this.getLogger().info("[Bentosmpp] Plugin has been enabled!");

        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("feed").setExecutor(new FeedCommand());
        this.getCommand("suicide").setExecutor(new SuicideCommand());
        this.getCommand("kill").setExecutor(new KillCommand());
        this.getCommand("cleareffect").setExecutor(new ClearEffectCommand());
        this.getCommand("broadcast").setExecutor(new BroadcastCommand());
        this.getCommand("message").setExecutor(new MessageCommand(lastMessager));
        this.getCommand("reply").setExecutor(new ReplyCommand(lastMessager));

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BlockListener(), this);
        pm.registerEvents(new EntityListeners(), this);
        pm.registerEvents(new PlayerListener(), this);


    }

    public static Bentosmpp getInstance() {
        return Bentosmpp.getPlugin(Bentosmpp.class);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("§3[Bentosmpp] §cPlugin has been disabled!");
    }
}
