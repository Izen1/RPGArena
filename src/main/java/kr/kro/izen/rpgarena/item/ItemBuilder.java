package kr.kro.izen.rpgarena.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemBuilder {

    private final ItemStack item;
    private ItemMeta meta;

    public ItemBuilder(Material material) {
        this(new ItemStack(material));
    }

    public ItemBuilder(ItemStack item) {
        this.item = item;
        this.meta = item.getItemMeta();
    }

    public ItemBuilder setDisplayName(String name) {
        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setType(Material material) {
        item.setType(material);
        return this;
    }

    public ItemBuilder setAmount(Integer amount) {
        item.setAmount(amount);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int lvl) {
        meta.addEnchant(enchantment, lvl, true);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder setUnbreakable(Boolean args) {
        meta.setUnbreakable(args);
        return this;
    }

    public ItemBuilder setCustomModelData(Integer number) {
        meta.setCustomModelData(number);
        return this;
    }

    public ItemBuilder setItemMeta(ItemMeta meta) {
        item.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return this.setItemMeta(this.meta).item;
    }
}
