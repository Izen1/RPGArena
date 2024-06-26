package kr.kro.izen.rpgarena.reward;

import kr.kro.izen.rpgarena.item.ItemBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Reward implements RewardItem{
    @Override
    public ItemStack food() {
        return new ItemBuilder(Material.COOKED_BEEF)
                .setAmount(5)
                .build();
    }

    @Override
    public ItemStack potion() {
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) item.getItemMeta();

        if (meta != null) {
            meta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1, true, true, true), true);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 1, true, true, true), true);
            meta.setColor(Color.RED);
            meta.setDisplayName("§c회복 물약");
            item.setItemMeta(meta);
        }
        return item;
    }

    @Override
    public ItemStack all() {
        return new ItemBuilder(Material.EMERALD_BLOCK)
                .setDisplayName("§a모두 획득")
                .build();
    }
}
