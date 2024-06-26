package kr.kro.izen.rpgarena.arena;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface ArenaCreate {
    void setup(Location location, Player player);
    void clear();
    void worldBorder(Location location, Integer size);
    void resetWorldBorder(Location location);
}
