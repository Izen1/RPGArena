package kr.kro.izen.rpgarena.round;

import com.google.common.collect.Maps;
import io.lumine.mythic.core.mobs.ActiveMob;
import kr.kro.izen.rpgarena.gui.RewardGet;
import kr.kro.izen.rpgarena.mob.MobSpawner;
import kr.kro.izen.rpgarena.utill.SaveJson;
import org.bukkit.entity.Player;

import java.util.Iterator;
import java.util.Map;

public class Round implements RoundController{
    public static Map<String, Integer> roundMap = Maps.newHashMap();
    private final SaveJson json = new SaveJson();
    private final MobSpawner mobSpawner = new MobSpawner();

    @Override
    public void startRound(Player player) {
        roundMap.put(player.getName(), 1);
    }

    @Override
    public void nextRound(Player player) {
        RewardGet.open(player);
        roundMap.put(player.getName(), roundMap.getOrDefault(player.getName(), 1) + 1);
        mobSpawner.spawnMob(player.getLocation(), roundMap.get(player.getName()));
    }

    @Override
    public void endRound(Player player) {
        json.saveLog(player);
        roundMap.remove(player.getName());
        mobSpawner.clearMob();
    }

    @Override
    public int getRound(Player player) {
        return roundMap.getOrDefault(player.getName(), 1);
    }

}
