package kr.kro.izen.rpgarena.skill;

import kr.kro.izen.rpgarena.RPGArena;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SwordSkill implements SkillController{

    private boolean skillUse = true;
    private int time;

    @Override
    public void skill(Player player) {
        if (!isUsed()) {
            player.sendMessage("스킬이 쿨타임 중입니다! 쿨타임 : " + time / 20 + " 초");
            return;
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 3, true, false, true));
        skillUse = false;
        time = 20 * 30;
        coolDown();
        player.sendMessage("스킬이 발동 되었습니다 !");
    }

    @Override
    public void coolDown() {
        Bukkit.getScheduler().runTaskTimer(RPGArena.plugin, task -> {
            if (time < 1) {
                skillUse = true;
                task.cancel();
                return;
            }
            time--;
        }, 0L,1L);
    }

    @Override
    public Boolean isUsed() {
        return skillUse;
    }
}
