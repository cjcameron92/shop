package net.oprealms.shop.object;

import org.bukkit.Material;

public enum ShopType {

    BLOCKS(Material.DIRT), MOB_DROPS(Material.ROTTEN_FLESH), ORES(Material.DIAMOND), FARMING(Material.WHEAT), MISC(Material.HOPPER);

    private final Material material;

    ShopType(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }
}
