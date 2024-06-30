package kr.kro.izen.rpgarena.mob;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.bukkit.events.MythicMobDeathEvent;
import io.lumine.mythic.core.mobs.ActiveMob;
import kr.kro.izen.rpgarena.RPGArena;
import kr.kro.izen.rpgarena.gui.GUIevent;
import kr.kro.izen.rpgarena.round.Round;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class MobSpawner implements MobController, Listener {
    public static Map<UUID, Entity> activeMobMap = new HashMap<>();

    @Override
    public void spawnMob(Location location, Integer round) {
        String mobName = getMobName();
        System.out.println(mobName);
        MythicMob mob = MythicBukkit.inst().getMobManager().getMythicMob(mobName).orElse(null);
        if (mob == null) return;
        MythicMob finalMob = mob;
        Bukkit.getScheduler().runTaskLater(RPGArena.plugin, () -> {
            for (int i = 0; i < round; i++) {
                ActiveMob spawn = finalMob.spawn(BukkitAdapter.adapt(location), 1);
                Entity entity = spawn.getEntity().getBukkitEntity();
                activeMobMap.put(spawn.getUniqueId(), entity);
            }
        }, 100L);

    }

    @Nullable
    private static String getMobName() {
        Random random = new Random();
        int randomMob = random.nextInt(2);
        String mobName = null;
        switch (GUIevent.getDifficulty()) {
            case EASY -> {
                if (randomMob < 1) mobName = "card-soldier-easy";
                else mobName = "card-soldier-color-easy";
            }
            case NORMAL -> {
                if (randomMob < 1) mobName = "card-soldier-normal";
                else mobName = "card-soldier-color-normal";
            }
            case HARD -> {
                if (randomMob < 1) mobName = "card-soldier-hard";
                else mobName = "card-soldier-color-hard";
            }
        }
        return mobName;
    }

    @Override
    public void clearMob() {
        activeMobMap.values().forEach(Entity::remove);
        activeMobMap.clear();
    }

    @EventHandler
    public void onMythicMobDeath(MythicMobDeathEvent event) {
        ActiveMob activeMob = event.getMob();
        Round round = new Round();
        activeMobMap.remove(activeMob.getUniqueId());
        if (!(event.getKiller() instanceof Player player)) return;
        if (isAlive()) return;
        round.nextRound(player);
    }

    @Override
    public boolean isAlive() {
        return !activeMobMap.isEmpty();
    }
}
