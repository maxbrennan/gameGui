package com.max.gamegui.listeners;

import com.max.gamegui.GameGui;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItem implements Listener {

    GameGui plugin;
    public PlayerDropItem(GameGui plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        if (new InventoryClick(plugin).equals(e.getItemDrop().getItemStack().getItemMeta().getDisplayName(),
                ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "Server Selector")) {
            e.setCancelled(true);
        }
    }

}
