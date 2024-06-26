package kr.kro.izen.rpgarena.mob;

import com.google.common.collect.Sets;
import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.bukkit.events.MythicMobDeathEvent;
import io.lumine.mythic.core.mobs.ActiveMob;
import kr.kro.izen.rpgarena.RPGArena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.*;

public class MobSpawner implements MobController, Listener {
    public Map<UUID, ActiveMob> activeMobMap = new HashMap<>();


    @Override
    public void spawnMob(Location location, Integer round) {
        MythicMob mob = MythicBukkit.inst().getMobManager().getMythicMob("card-soldier").orElse(null);
        Random random = new Random();
        int randomMob = random.nextInt(2);
        if (randomMob < 1) {
            mob = MythicBukkit.inst().getMobManager().getMythicMob("card-soldier-color").orElse(null);
        }
        if (mob == null) return;
        MythicMob finalMob = mob;
        Bukkit.getScheduler().runTaskLater(RPGArena.plugin, () -> {
            for (int i = 0; i < round; i++) {
                ActiveMob spawn = finalMob.spawn(BukkitAdapter.adapt(location), 1);
                activeMobMap.put(spawn.getUniqueId(), spawn);
            }
        }, 100L);

    }

    @Override
    public void clearMob() {
        activeMobMap.values().forEach(ActiveMob::remove);
        activeMobMap.clear();
    }

    @EventHandler
    public void onMythicMobDeath(MythicMobDeathEvent event) {
        ActiveMob activeMob = event.getMob();
        activeMobMap.remove(activeMob.getUniqueId());
        if (event.getKiller() instanceof Player player) {
            player.sendMessage(activeMobMap.toString());
        }
    }

    @Override
    public boolean getMob() {
        return !activeMobMap.isEmpty();
    }
}
