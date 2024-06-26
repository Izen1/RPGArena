package kr.kro.izen.rpgarena.weapon;

import kr.kro.izen.rpgarena.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Sword extends AbstractWeapon{
    public Sword(ItemStack item) {
        super(item);
    }

    public static ItemStack getSword() {
        return new ItemBuilder(Material.DIAMOND_SWORD)
                .setDisplayName("§6아레나용 검")
                .setLore("§f아레나용 검이다.",
                        "§5※특수능력※",
                        "§5우클릭시 잠시동안 초월적인 힘을 발휘한다.",
                        "§5쿨타임 : 30초")
                .setUnbreakable(true)
                .build();
    }
}
