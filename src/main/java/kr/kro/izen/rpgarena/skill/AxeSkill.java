package kr.kro.izen.rpgarena.skill;

import kr.kro.izen.rpgarena.RPGArena;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AxeSkill implements SkillController{
    private boolean skillUse = false;
    private int time;
    @Override
    public void skill(Player player) {
        if (isUsed()) {
            player.sendMessage("스킬이 쿨타임 중입니다! 쿨타임 : " + time / 20 + " 초");
            return;
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 200, 10, true, false, true));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1, true, false, true));
        skillUse = true;
        time = 20 * 30;
        player.sendMessage("스킬이 발동 되었습니다 !");
        coolDown();
    }

    @Override
    public void coolDown() {
        Bukkit.getScheduler().runTaskTimer(RPGArena.plugin, task-> {
            if (time < 0) {
                skillUse = false;
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
