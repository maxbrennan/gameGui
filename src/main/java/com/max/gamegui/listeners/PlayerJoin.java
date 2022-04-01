package com.max.gamegui.listeners;

import com.max.gamegui.GameGui;
import com.max.gamegui.Itemstacks;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerJoin implements Listener {

    GameGui plugin;
    public PlayerJoin(GameGui plugin) { this.plugin = plugin; }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().getInventory().clear();
        e.getPlayer().getInventory().setItem(0, new Itemstacks().serverSelector());
    }

}
