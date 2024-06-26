package kr.kro.izen.rpgarena.player;

import kr.kro.izen.rpgarena.game.GameSetup;
import kr.kro.izen.rpgarena.utill.SaveJson;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerEvent implements Listener {

    public boolean playerDeath = false;
    private final GameSetup setup = new GameSetup();
    private final SaveJson json = new SaveJson();

    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        if (setup.isStarting()) {
            setup.endGame(player);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        json.loadLog(player);
    }
}
