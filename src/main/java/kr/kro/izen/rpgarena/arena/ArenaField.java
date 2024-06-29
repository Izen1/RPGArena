package kr.kro.izen.rpgarena.arena;

import com.google.common.collect.Lists;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.List;

public class ArenaField implements ArenaCreate{

    private final List<Block> arenaBlocks = Lists.newArrayList();

    @Override
    public void setup(Location location, Player player) {
        clear();

        double xMin = location.getX();
        double zMin = location.getZ();

        World world = location.getWorld();

        int size = 30;

        for (int x = -size / 2; x <= size / 2; x++) {
            for (int z = -size / 2; z <= size / 2; z++) {
                Location location1 = new Location(world, xMin + x, location.getY(), zMin + z);
                Block block = world.getBlockAt(location1);
                block.setType(Material.POLISHED_DIORITE);
                arenaBlocks.add(block);
            }
        }

        worldBorder(location, size);
        player.teleport(location.add(0, 1, 0));
    }

    @Override
    public void clear() {
        for (Block block : arenaBlocks) {
            block.setType(Material.AIR);
        }
        arenaBlocks.clear();
    }

    @Override
    public void worldBorder(Location location, Integer size) {
        World world = location.getWorld();
        WorldBorder worldBorder = world.getWorldBorder();
        worldBorder.setCenter(location);
        worldBorder.setSize(size);
    }

    @Override
    public void resetWorldBorder(Location location) {
        World world = location.getWorld();
        WorldBorder worldBorder = world.getWorldBorder();
        worldBorder.setCenter(world.getSpawnLocation());
        worldBorder.setSize(worldBorder.getMaxSize());
    }
}
