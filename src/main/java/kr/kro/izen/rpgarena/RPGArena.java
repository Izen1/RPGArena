package kr.kro.izen.rpgarena;

import kr.kro.izen.rpgarena.command.ArenaCommands;
import kr.kro.izen.rpgarena.game.GameSetup;
import kr.kro.izen.rpgarena.gui.ChoseWeapon;
import kr.kro.izen.rpgarena.gui.GUIevent;
import kr.kro.izen.rpgarena.gui.RewardGet;
import kr.kro.izen.rpgarena.mob.MobSpawner;
import kr.kro.izen.rpgarena.player.PlayerEvent;
import kr.kro.izen.rpgarena.skill.SkillEvent;
import kr.kro.izen.rpgarena.skill.SkillManager;
import kr.kro.izen.rpgarena.utill.SaveJson;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class RPGArena extends JavaPlugin {

    public static RPGArena plugin;
    private GameSetup gameSetup;
    private final SaveJson json = new SaveJson();

    @Override
    public void onEnable() {
        plugin = this;
        SkillManager skillManager = new SkillManager();
        gameSetup = new GameSetup();
        Bukkit.getCommandMap().register("", new ArenaCommands("arena", gameSetup));
        Bukkit.getPluginManager().registerEvents(new SkillEvent(skillManager), this);
        Bukkit.getPluginManager().registerEvents(new GUIevent(), this);
        Bukkit.getPluginManager().registerEvents(new MobSpawner(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerEvent(gameSetup), this);
    }

    @Override
    public void onDisable() {
        if (!gameSetup.isStarting()) return;
        for (Player player : Bukkit.getOnlinePlayers()) {
            gameSetup.endGame(player);
        }
    }
}
