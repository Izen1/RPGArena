package kr.kro.izen.rpgarena.gui;

import kr.kro.izen.rpgarena.item.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class DifficultySelect {
    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 36, "난이도 선택");
        inv.setItem(8 + 2, new ItemBuilder(Material.EMERALD_BLOCK).setDisplayName("§a이지").build());
        inv.setItem(8 + 5, new ItemBuilder(Material.LAPIS_BLOCK).setDisplayName("§7노말").build());
        inv.setItem(8 + 8, new ItemBuilder(Material.REDSTONE_BLOCK).setDisplayName("§4하드").build());
        player.openInventory(inv);
    }
}
