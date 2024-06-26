package kr.kro.izen.rpgarena.game;

import org.bukkit.entity.Player;

public interface GameController {
    void startGame(Player player);
    void endGame(Player player);
    boolean isStarting();
    void getLogs(Player player);
}
