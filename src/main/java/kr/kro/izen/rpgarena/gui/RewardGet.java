package kr.kro.izen.rpgarena.gui;

import kr.kro.izen.rpgarena.reward.Reward;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class RewardGet implements Listener {


    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9 * 3, "§5보상 획득 !!");
        Reward reward = new Reward();
        inv.setItem(8 + 4, reward.food());
        inv.setItem(8 + 6, reward.potion());
        inv.setItem(8 * 3 + 2, reward.all());
        player.openInventory(inv);
    }

}
