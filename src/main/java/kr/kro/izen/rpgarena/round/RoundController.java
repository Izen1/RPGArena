package kr.kro.izen.rpgarena.round;

import org.bukkit.entity.Player;

public interface RoundController {
    void startRound(Player player);
    void nextRound(Player player);
    void endRound(Player player);
    int getRound(Player player);
}
