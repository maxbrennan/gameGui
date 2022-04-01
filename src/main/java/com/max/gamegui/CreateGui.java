package com.max.gamegui;

import com.max.gamegui.listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public class CreateGui {

    Player player;
    public CreateGui(Player owner) {
        player = owner;
    }

    int i;
    int itemsNumber = 3;
    boolean isOpen = false;
    List<Integer> frames = new ArrayList<>(Arrays.asList(17, 18, 26, 27, 35));

    Inventory gui;
    Itemstacks items = new Itemstacks();

    public void createPage(int pageNumber, boolean isFirstPage, boolean isLastPage,
                           ItemStack item1, @Nullable ItemStack item2, @Nullable ItemStack item3) {
        try {
            gui.clear();
        } catch (Exception ignored) {}
        gui = Bukkit.createInventory(player, 45,
                ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "Server Selector: Page " + pageNumber);
        gui.setItem(0, items.close());

        // SET FRAME SLOTS

        for (i = 9; i >= 1; i--) {
            gui.setItem(i, items.frame());
        }
        for (i = 43; i >= 37; i--) {
            gui.setItem(i, items.frame());
        }
        if (isFirstPage) {
            gui.setItem(36, items.first());
            gui.setItem(44, items.next());
        } else if (isLastPage) {
            gui.setItem(36, items.back());
            gui.setItem(44, items.last());
        } else {
            gui.setItem(36, items.back());
            gui.setItem(44, items.next());
        }

        // CUSTOMIZE FRAME SLOTS

        if (item3 == null) {
            Collections.addAll(frames, 10, 16, 19, 25, 28, 34);
            itemsNumber = 2;
        }
        if (item2 == null) {
            Collections.addAll(frames, 11, 15, 20, 24, 29, 33);
            itemsNumber = 1;
        }
        for (int i : frames) {
            gui.setItem(i, items.frame());
        }
        switch (itemsNumber) {
            case 1:
                gui.setItem(22, item1);
                break;
            case 2:
                gui.setItem(21, item1);
                gui.setItem(23, item2);
                break;
            case 3:
                gui.setItem(20, item1);
                gui.setItem(22, item2);
                gui.setItem(24, item3);
                break;
        }
    }

    public Inventory getGui() {
        return gui;
    }

}
