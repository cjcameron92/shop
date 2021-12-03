package net.oprealms.shop.object;

import me.lucko.helper.item.ItemStackBuilder;
import me.lucko.helper.menu.Item;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ShopItem {

    private final Material material;
    private final double buyPrice, sellPrice;

    public ShopItem(Material material, double buyPrice, double sellPrice) {
        this.material = material;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public Material getMaterial() {
        return material;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public Item getItem(Player player) {
        return ItemStackBuilder.of(material).name(material.name().replaceAll("_", " ")).lore("", "&fBuy Price: &c$" + buyPrice, "&fSell Price: &a$" + sellPrice).build(() -> {
            player.getInventory().addItem(new ItemStack(material, 1));
            player.sendMessage(ChatColor.GREEN + "You have purchased this!");
        });
    }
}
