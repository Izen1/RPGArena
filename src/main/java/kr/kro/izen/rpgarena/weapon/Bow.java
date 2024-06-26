package kr.kro.izen.rpgarena.weapon;

import kr.kro.izen.rpgarena.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Bow extends AbstractWeapon {
    public Bow(ItemStack item) {
        super(item);
    }

    public static ItemStack getBow() {
        return new ItemBuilder(Material.BOW)
                .setDisplayName("§6아레나용 활")
                .setLore("§f아레나용 활이다.",
                        "§5※특수능력※",
                        "§5활을 버릴시 잠시동안 매우 강력한 활로 변경된다.",
                        "§5쿨타임 : 라운드당 한번")
                .addEnchantment(Enchantment.ARROW_INFINITE, 1)
                .setUnbreakable(true)
                .build();
    }

    public static ItemStack getEnchantedBow() {
        return new ItemBuilder(Material.BOW)
                .setDisplayName("§5특수 활")
                .setLore("§5특수 활이다.")
                .addEnchantment(Enchantment.ARROW_DAMAGE, 5)
                .addEnchantment(Enchantment.ARROW_INFINITE, 1)
                .setUnbreakable(true)
                .build();
    }
}
