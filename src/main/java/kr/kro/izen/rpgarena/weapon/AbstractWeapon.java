package kr.kro.izen.rpgarena.weapon;

import org.bukkit.inventory.ItemStack;

public class AbstractWeapon implements WeaponInterface{

    private final ItemStack item;

    public AbstractWeapon(ItemStack item) {
        this.item = item;
    }

    @Override
    public ItemStack getItemStack() {
        return item.clone();
    }
}
