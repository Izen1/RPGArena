package kr.kro.izen.rpgarena.skill;

import kr.kro.izen.rpgarena.RPGArena;
import kr.kro.izen.rpgarena.weapon.Bow;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BowSkill implements SkillController{
    public static boolean skillUse = false;

    @Override
    public void skill(Player player) {
        ItemStack bow = Bow.getBow();
        if (isUsed()) {
            player.sendMessage("스킬이 이미 발동 되었습니다.");
            player.getInventory().addItem(bow);
            return;
        }
        ItemStack skillBow = Bow.getEnchantedBow();
        player.getInventory().remove(bow);
        player.getInventory().addItem(skillBow);

        Bukkit.getScheduler().runTaskLater(RPGArena.plugin, () -> {
            player.getInventory().remove(skillBow);
            player.getInventory().addItem(bow);
        }, 200L);

        skillUse = true;
    }

    @Override
    public void coolDown() {
        skillUse = false;
    }

    @Override
    public Boolean isUsed() {
        return skillUse;
    }
}
