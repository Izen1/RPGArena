package kr.kro.izen.rpgarena.mob;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface MobController {
    void spawnMob(Location location, Integer round);
    void clearMob();
    boolean getMob();
}
