package kr.kro.izen.rpgarena.weapon;

import kr.kro.izen.rpgarena.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Axe extends AbstractWeapon{
    public Axe(ItemStack item) {
        super(item);
    }

    public static ItemStack getAxe() {
        return new ItemBuilder(Material.DIAMOND_AXE)
                .setDisplayName("§6바바리안 도끼")
                .setLore("§f바바리안이 사용하던 도끼이다.",
                        "§5※특수능력※",
                        "§5우클릭시 잠시동안 체력이 증가하며 데미지가 증가한다.",
                        "§5쿨타임 : 30초")
                .setUnbreakable(true)
                .build();
    }
}
