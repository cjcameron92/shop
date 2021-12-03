package net.oprealms.shop;

import net.oprealms.shop.service.ShopService;
import org.bukkit.plugin.java.JavaPlugin;

public class ShopPlugin extends JavaPlugin {

    private static ShopPlugin plugin;

    private ShopService shopService;

    public ShopPlugin() {
        ShopPlugin.plugin = this;
    }


    @Override public void onEnable() {
        shopService = new ShopService();
    }

    public ShopService getShopService() {
        return shopService;
    }

    public static ShopPlugin getPlugin() {
        return plugin;
    }
}
