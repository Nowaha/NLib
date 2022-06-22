package xyz.nowaha.nlib.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import xyz.nowaha.nlib.utils.Formatting;

import java.util.*;

@SuppressWarnings("deprecation")
public class ItemStackBuilder implements Listener {

    private ItemMeta itemMeta;
    private ItemStack itemStack;

    public ItemStackBuilder(Material material) {
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder(ItemStack itemStack) {
        itemStack = itemStack.clone();
        itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder(ItemStackBuilder itemStackBuilder) {
        itemStack = itemStackBuilder.build().clone();
        itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder amount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemStackBuilder type(Material material) {
        itemStack.setType(material);
        itemMeta = itemStack.getItemMeta();
        return this;
    }

    public ItemStackBuilder durability(short durability) {
        itemStack.setDurability(durability);
        return this;
    }

    public ItemStackBuilder displayName(String displayName) {
        itemMeta.setDisplayName(displayName);
        return this;
    }

    public String displayName() {
        return itemMeta.getDisplayName();
    }

    public ItemStackBuilder formatName(String... replacements) {
        displayName(Formatting.format(displayName(), replacements));
        return this;
    }

    public ItemStackBuilder formatLore(String... replacements) {
        List<String> lore = lore();
        if (lore != null) {
            lore(Formatting.format(lore, replacements));
        }

        return this;
    }

    public ItemStackBuilder formatLoreList(String key, List<String> insertion) {
        lore(Formatting.replaceInList(lore(), key, insertion));
        return this;
    }

    public ItemStackBuilder customModelData(int data) {
        itemMeta.setCustomModelData(data);
        return this;
    }

    public ItemStackBuilder glow(boolean glow) {
        if (glow) {
            itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        } else {
            itemMeta.getEnchants().forEach((enchant, level) -> itemMeta.removeEnchant(enchant));
        }

        return this;
    }

    public ItemStackBuilder lore(List<String> lore, boolean extendExisting) {
        if (!extendExisting) {
            if (lore.size() > 0) {
                itemMeta.setLore(lore);
            }

            return this;
        }

        List<String> existingLore = itemMeta.hasLore() ? itemMeta.getLore() : new ArrayList<>();
        existingLore.addAll(lore);
        itemMeta.setLore(existingLore);

        return this;
    }

    public ItemStackBuilder lore(List<String> lore) {
        this.lore(lore, false);
        return this;
    }

    public List<String> lore() {
        return itemMeta.getLore();
    }

    public ItemStackBuilder enchant(Enchantment enchantment, int level, boolean ignoreLevelRestriction) {
        itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction);
        return this;
    }

    public ItemStackBuilder itemFlags(ItemFlag... flags) {
        itemMeta.addItemFlags(flags);
        return this;
    }

    public ItemStackBuilder skullOwner(Player player) {
        SkullMeta playerheadmeta = (SkullMeta) itemMeta;
        playerheadmeta.setOwner(player.getName());
        return this;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ItemStackBuilder metadata(NamespacedKey key, PersistentDataType type, Object value) {
        itemMeta.getPersistentDataContainer().set(key, type, value);
        return this;
    }

    public ItemStackBuilder potion(PotionType type) {
        if(type == null || !(itemMeta instanceof PotionMeta))
            return this;

        PotionMeta potionMeta = (PotionMeta) itemMeta;
        potionMeta.setBasePotionData(new PotionData(type));
        return this;
    }

    public ItemStack build() {
        ItemStack clonedStack = itemStack.clone();
        clonedStack.setItemMeta(itemMeta.clone());
        return clonedStack;
    }

    @Override
    public ItemStackBuilder clone() {
        return new ItemStackBuilder(this);
    }

}




