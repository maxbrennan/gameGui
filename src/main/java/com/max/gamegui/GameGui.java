package com.max.gamegui;

import com.max.gamegui.listeners.InventoryClick;
import com.max.gamegui.listeners.PlayerDropItem;
import com.max.gamegui.listeners.PlayerInteract;
import com.max.gamegui.listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class GameGui extends JavaPlugin {

    public final String RED = "\033[31m";
    public final String GREEN = "\033[32m";
    public final String RESET = "\033[0m";

    @Override
    public void onEnable() {
        System.out.println(GREEN + "===========================================" + RESET);
        System.out.println(GREEN + "|                                         |" + RESET);
        System.out.println(GREEN + "|          Game GUI has started!          |" + RESET);
        System.out.println(GREEN + "|                                         |" + RESET);
        System.out.println(GREEN + "===========================================" + RESET);

        // REGISTER EVENTS
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDropItem(this), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println(RED + "===========================================" + RESET);
        System.out.println(RED + "|                                         |" + RESET);
        System.out.println(RED + "|           Game GUI has ended!           |" + RESET);
        System.out.println(RED + "|                                         |" + RESET);
        System.out.println(RED + "===========================================" + RESET);

        saveConfig();
    }

}
