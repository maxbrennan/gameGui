package com.max.gamegui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;

public class Itemstacks {

    ItemStack is;
    ItemMeta im;

    private ItemStack createStack(Material itemType, boolean isShiny, @Nullable String name, @Nullable String lore) {
        is = new ItemStack(itemType);
        im = is.getItemMeta();
        if (isShiny) {
            im.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if (name != null) {
            im.setDisplayName(ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + name);
        } else {
            im.setDisplayName("");
        }
        if (lore != null) {
            im.setLore(Arrays.asList(ChatColor.RED + lore));
        }
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        is.setItemMeta(im);
        return is;
    }

    public ItemStack skyWizards() {
        return createStack(Material.ARROW, true, "Sky Wizards", "Battle to be the sky god!");
    }

    public ItemStack bridgeWizards() {
        return createStack(Material.RED_WOOL, true, "Bridge Wizards", "Fight along a narrow bridge!");
    }

    public ItemStack mmorpg() {
        return createStack(Material.PLAYER_HEAD, true, "MMORPG", "Role play!");
    }

    public ItemStack tagRun() {
        return createStack(Material.DIAMOND_BOOTS, true, "Tagger vs. Runner", "Tag! You're it!");
    }

    public ItemStack serverSelector() {
        return createStack(Material.STICK, true, "Server Selector", "Select your minigame!");
    }
    public ItemStack frame() {
        return createStack(Material.BLACK_STAINED_GLASS_PANE, false, " ", null);
    }

    public ItemStack close() {
        return createStack(Material.BARRIER, true, "Close", "Close the GUI");
    }

    public ItemStack next() {
        return createStack(Material.ARROW, true, "Next", "Go to the next page...");
    }

    public ItemStack back() {
        return createStack(Material.ARROW, true, "Back", "Go back a page...");
    }

    public ItemStack first() {
        return createStack(Material.PAPER, false, "First Page", "You can't go back anymore!");
    }

    public  ItemStack last() {
        return createStack(Material.PAPER, false, "Last Page", "You can't go forward anymore!");
    }

}
