package kr.kro.izen.rpgarena.game;

import kr.kro.izen.rpgarena.RPGArena;
import kr.kro.izen.rpgarena.arena.ArenaField;
import kr.kro.izen.rpgarena.difficulty.Difficulty;
import kr.kro.izen.rpgarena.gui.ChoseWeapon;
import kr.kro.izen.rpgarena.gui.DifficultySelect;
import kr.kro.izen.rpgarena.gui.GUIevent;
import kr.kro.izen.rpgarena.gui.RewardGet;
import kr.kro.izen.rpgarena.mob.MobSpawner;
import kr.kro.izen.rpgarena.round.Round;
import kr.kro.izen.rpgarena.skill.BowSkill;
import kr.kro.izen.rpgarena.utill.SaveJson;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class GameSetup implements GameController{
    private final ArenaField arenaField = new ArenaField();
    private final Round round = new Round();
    private final MobSpawner mobSpawner = new MobSpawner();
    private Map<Player, Location> playerMap = new HashMap<>();

    private boolean starting = false;

    @Override
    public void startGame(Player player) {
        if (isStarting()) return;
        starting = true;
        playerMap.put(player, player.getLocation());
        Location location = player.getLocation().clone().add(0, 20, 0);
        arenaField.setup(location, player);
        ChoseWeapon.open(player);
        player.sendMessage("5초후 라운드가 시작됩니다.");
        round.startRound(player);
        mobSpawner.spawnMob(location, round.getRound(player));
    }

    @Override
    public void endGame(Player player) {
        starting = false;
        arenaField.clear();
        arenaField.resetWorldBorder(player.getLocation());
        player.teleport(playerMap.get(player));
        playerMap.remove(player);
        round.endRound(player);
        player.sendMessage("당신의 현재 난이도는 라운드는 " + round.getRound(player) + " 이고 최종 라운드는 " + Round.MAXroundMap.get(player.getName()) + " 입니다.");
    }

    @Override
    public void setDifficulty(Player p) {
        DifficultySelect.open(p);
    }

    @Override
    public boolean isStarting() {
        return starting;
    }

    @Override
    public void getLogs(Player player) {
        player.sendMessage("당신의 최대 라운드 수는 " + round.getMaxRound(player) + " 입니다.");
    }
}
