package kr.kro.izen.rpgarena.gui;

import kr.kro.izen.rpgarena.weapon.Axe;
import kr.kro.izen.rpgarena.weapon.Bow;
import kr.kro.izen.rpgarena.weapon.Sword;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class ChoseWeapon implements Listener {

    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9 * 3, "§6무기를 골라주세요!");
        inv.setItem(8 + 2, Sword.getSword());
        inv.setItem(8 + 5, Axe.getAxe());
        inv.setItem(8 + 8, Bow.getBow());
        player.openInventory(inv);
    }

}
