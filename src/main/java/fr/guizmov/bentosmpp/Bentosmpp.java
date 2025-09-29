package fr.guizmov.bentosmpp;

import fr.guizmov.bentosmpp.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bentosmpp extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().info("[Bentosmpp] Plugin has been enabled!");

        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("feed").setExecutor(new FeedCommand());
        this.getCommand("suicide").setExecutor(new SuicideCommand());
        this.getCommand("kill").setExecutor(new KillCommand());
        this.getCommand("cleareffect").setExecutor(new ClearEffectCommand());
        this.getCommand("broadcast").setExecutor(new BroadcastCommand());


    }

    @Override
    public void onDisable() {
        this.getLogger().info("[Bentosmpp] Plugin has been disabled!");
    }
}
