package com.max.gamegui.listeners;

import com.max.gamegui.CreateGui;
import com.max.gamegui.GameGui;
import com.max.gamegui.Itemstacks;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

public class PlayerInteract implements Listener {

    GameGui plugin;
    public CreateGui gui;
    Itemstacks items = new Itemstacks();
    public PlayerInteract(GameGui plugin) { this.plugin = plugin; }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Action action = e.getAction();
        if ((action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) &&
                new InventoryClick(plugin).equals(e.getItem().getItemMeta().getDisplayName(),
                        ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "Server Selector")) {
            gui = new CreateGui(e.getPlayer());
            e.getPlayer().closeInventory();
            gui.createPage(1, true, false, items.bridgeWizards(), items.skyWizards(), items.mmorpg());
            e.getPlayer().openInventory(gui.getGui());
        }
    }

}
