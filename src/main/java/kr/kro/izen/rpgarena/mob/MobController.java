package kr.kro.izen.rpgarena.mob;

import org.bukkit.Location;

public interface MobController {
    void spawnMob(Location location, Integer round);
    void clearMob();
    boolean isAlive();
}
