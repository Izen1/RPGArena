package kr.kro.izen.rpgarena.gui;

import kr.kro.izen.rpgarena.difficulty.Difficulty;
import kr.kro.izen.rpgarena.reward.Reward;
import kr.kro.izen.rpgarena.weapon.Axe;
import kr.kro.izen.rpgarena.weapon.Bow;
import kr.kro.izen.rpgarena.weapon.Sword;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GUIevent implements Listener {
    private static Difficulty difficulty;
    @EventHandler
    public void clickEvent(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        if (event.getClickedInventory() == null) return;
        ItemStack item = event.getCurrentItem();
        if (item == null) return;
        switch (event.getView().getTitle()) {
            case "§6무기를 골라주세요!" -> {
                event.setCancelled(true);
                switch (item.getItemMeta().getDisplayName()) {
                    case "§6아레나용 검" -> {
                        player.getInventory().addItem(Sword.getSword());
                        player.getInventory().addItem(new ItemStack(Material.SHIELD));
                        player.closeInventory();
                    }
                    case "§6바바리안 도끼" -> {
                        player.getInventory().addItem(Axe.getAxe());
                        player.getInventory().addItem(new ItemStack(Material.SHIELD));
                        player.closeInventory();
                    }
                    case "§6아레나용 활" -> {
                        player.getInventory().addItem(Bow.getBow());
                        player.getInventory().addItem(new ItemStack(Material.ARROW));
                        player.closeInventory();
                    }
                }
            }
            case "§5보상 획득 !!" -> {
                event.setCancelled(true);
                Reward reward = new Reward();
                if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a모두 획득")) {
                    player.getInventory().addItem(reward.food());
                    player.getInventory().addItem(reward.potion());
                    player.closeInventory();
                }
            }
            case "난이도 선택" -> {
                event.setCancelled(true);
                switch (item.getItemMeta().getDisplayName()) {
                    case "§a이지" -> {
                        difficulty = Difficulty.EASY;
                        player.closeInventory();
                        player.sendMessage("난이도가 §a쉬움 §f으로 지정 되었습니다");
                    }
                    case "§7노말" -> {
                        difficulty = Difficulty.NORMAL;
                        player.closeInventory();
                        player.sendMessage("난이도가 §7보통 §f으로 지정 되었습니다");
                    }
                    case "§4하드" -> {
                        difficulty = Difficulty.HARD;
                        player.closeInventory();
                        player.sendMessage("난이도가 §4어려움 §f으로 지정 되었습니다");
                    }
                }
            }
        }
    }

    public static Difficulty getDifficulty() {
        return difficulty;
    }
}
