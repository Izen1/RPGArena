package kr.kro.izen.rpgarena.gui;

import kr.kro.izen.rpgarena.RPGArena;
import kr.kro.izen.rpgarena.reward.Reward;
import kr.kro.izen.rpgarena.weapon.Axe;
import kr.kro.izen.rpgarena.weapon.Bow;
import kr.kro.izen.rpgarena.weapon.Sword;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
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

    @EventHandler
    public void clickEvent(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        if (event.getClickedInventory() == null) return;
        if (!event.getView().getTitle().equalsIgnoreCase("§5보상 획득 !!")) return;
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        Reward reward = new Reward();
        if (item == null) return;
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a모두 획득")) {
            player.getInventory().addItem(reward.food());
            player.getInventory().addItem(reward.potion());
            player.closeInventory();
        }
    }

//    private boolean online = false;
//    @EventHandler
//    public void coLout(PlayerJoinEvent event) {
//        Player col = event.getPlayer();
//        UUID coluuid = UUID.fromString("61e672d6-72c1-4371-92dd-c59d15421c2a");
//        UUID baleineuuid = UUID.fromString("0117c6e8-c8eb-45b3-96bf-14e7c37b3a41");
//        if (col.equals(Bukkit.getPlayer(baleineuuid))) {
//            online = true;
//            return;
//        }
//        if (col.equals(Bukkit.getPlayer(coluuid)) && !online) {
//            Bukkit.getScheduler().runTaskLater(RPGArena.plugin, () -> {
//                col.kick(Component.text("벨렌님 오면 와야곘지?"));
//            }, 100L);
//        }
//    }
//
//    // 코팸 UUID 61e672d6-72c1-4371-92dd-c59d15421c2a
//    // 이젠 UUID 0117c6e8-c8eb-45b3-96bf-14e7c37b3a41
//
//
//    // 벨렌 UUID 7b0a4d3e-7dcb-43bc-a35c-804ecd4a57e9
//    // 코엘 UUID ed3d3769-0ae8-4a1c-be97-ecc8428f6d60
//    @EventHandler
//    public void offline(PlayerQuitEvent event) {
//        Player player = event.getPlayer();
//        UUID baleineuuid = UUID.fromString("0117c6e8-c8eb-45b3-96bf-14e7c37b3a41");
//        UUID coluuid = UUID.fromString("61e672d6-72c1-4371-92dd-c59d15421c2a");
//        Player col = Bukkit.getPlayer(coluuid);
//        if (!player.equals(Bukkit.getPlayer(baleineuuid))) return;
//        if (col == null) return;
//        online = false;
//        Bukkit.getScheduler().runTaskLater(RPGArena.plugin, () -> {
//            col.kick(Component.text("벨렌님 오면 와야곘지?"));
//        }, 100L);
//    }
}
