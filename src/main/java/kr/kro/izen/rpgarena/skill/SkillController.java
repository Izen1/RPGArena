package kr.kro.izen.rpgarena.skill;

import org.bukkit.entity.Player;

public interface SkillController {
    void skill(Player player);
    void coolDown();
    Boolean isUsed();
}
