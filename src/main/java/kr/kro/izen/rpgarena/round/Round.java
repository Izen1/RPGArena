package kr.kro.izen.rpgarena.round;

import com.google.common.collect.Maps;
import io.lumine.mythic.core.mobs.ActiveMob;
import kr.kro.izen.rpgarena.gui.GUIevent;
import kr.kro.izen.rpgarena.gui.RewardGet;
import kr.kro.izen.rpgarena.mob.MobSpawner;
import kr.kro.izen.rpgarena.skill.BowSkill;
import kr.kro.izen.rpgarena.utill.SaveJson;
import org.bukkit.entity.Player;

import java.util.Iterator;
import java.util.Map;

public class Round implements RoundController{
    public static Map<String, Integer> roundMap = Maps.newHashMap();
    public static Map<String, Integer> MAXroundMap = Maps.newHashMap();
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
        player.sendMessage(roundMap.get(player.getName()) + " 라운드를 시작합니다!");
        BowSkill.skillUse = false;
        mobSpawner.spawnMob(player.getLocation(), roundMap.get(player.getName()));
    }

    @Override
    public void endRound(Player player) {
        if (MAXroundMap.getOrDefault(player.getName(), 1) < roundMap.getOrDefault(player.getName(), 1)) {
            MAXroundMap.put(player.getName(), roundMap.getOrDefault(player.getName(), 1));
        }
        json.saveLog(player);
        roundMap.remove(player.getName());
        mobSpawner.clearMob();
    }

    @Override
    public int getRound(Player player) {
        return roundMap.getOrDefault(player.getName(), 1);
    }

    @Override
    public int getMaxRound(Player player) {
        return MAXroundMap.getOrDefault(player.getName(), 1);
    }

}
