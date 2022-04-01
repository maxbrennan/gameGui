package com.max.gamegui.listeners;

import com.max.gamegui.CreateGui;
import com.max.gamegui.GameGui;
import com.max.gamegui.Itemstacks;
import me.TahaCheji.proxyData.SendPlayer;
import me.TahaCheji.proxyData.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

public class InventoryClick implements Listener {

    GameGui plugin;
    public InventoryClick(GameGui plugin) {
        this.plugin = plugin;
    }
    CreateGui gui;
    Itemstacks items = new Itemstacks();
    public boolean equals(String unknownText, String partialColoredText) {
        return unknownText.equals(ChatColor.translateAlternateColorCodes('&', partialColoredText));
    }
    boolean page(InventoryView view, int pageNumber) {
        return equals(view.getTitle(), ChatColor.DARK_GREEN.toString() + ChatColor.BOLD +
                "Server Selector: Page " + pageNumber);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (page(e.getView(), 1) && e.getCurrentItem() != null && e.getWhoClicked() instanceof Player) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            switch (e.getRawSlot()) {
                case 0:
                    e.getWhoClicked().closeInventory();
                    break;
                case 20:
                    new SendPlayer(player).send(Server.BRIDGE_WIZZERDS_HUB);
                    break;
                case 22:
                    new SendPlayer(player).send(Server.SKY_WARS_HUB);
                    break;
                case 24:
                    // MMORPG
                    player.closeInventory();
                    player.sendMessage(ChatColor.RED + "This server is down!");
                    break;
                case 44:
                    gui = new CreateGui(player);
                    gui.createPage(2, false, true, items.tagRun(), null, null);
                    player.openInventory(gui.getGui());
                    break;
            }
        } else if (page(e.getView(), 2) && e.getCurrentItem() != null) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            switch (e.getRawSlot()) {
                case 0:
                    e.getWhoClicked().closeInventory();
                    break;
                case 22:
                    new SendPlayer(player).send(Server.MAGIC_TAG_HUB);
                    break;
                case 36:
                    gui = new CreateGui(player);
                    gui.createPage(1, true, false, items.bridgeWizards(), items.skyWizards(), items.mmorpg());
                    player.openInventory(gui.getGui());
                    break;
            }
        }
    }

}
