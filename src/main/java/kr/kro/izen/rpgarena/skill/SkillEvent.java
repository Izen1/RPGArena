package kr.kro.izen.rpgarena.skill;

import kr.kro.izen.rpgarena.weapon.Axe;
import kr.kro.izen.rpgarena.weapon.Bow;
import kr.kro.izen.rpgarena.weapon.Sword;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SkillEvent implements Listener {

    private SkillManager skillManager;

    public SkillEvent(SkillManager skillManager) {
        this.skillManager = skillManager;
    }

    @EventHandler
    public void onDropEvent(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§5특수 활")) {
            event.setCancelled(true);
        }
        if (!(event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§6아레나용 활"))) return;
        skillManager.getBowSkill().skill(player);
        event.getItemDrop().remove();
    }

    @EventHandler
    public void interact(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHand = player.getInventory().getItemInMainHand();

        if (mainHand.getItemMeta() == null) return;
        if (mainHand.getItemMeta().displayName() == null) return;
        if (!event.getAction().isRightClick()) return;
        if (mainHand.getItemMeta().getDisplayName().equalsIgnoreCase("§6아레나용 검")) {
            skillManager.getSwordSkill().skill(player);
        }
        if (mainHand.getItemMeta().getDisplayName().equalsIgnoreCase("§6바바리안 도끼")) {
            skillManager.getAxeSkill().skill(player);
        }
    }
}
