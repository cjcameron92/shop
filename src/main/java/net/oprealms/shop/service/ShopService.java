package net.oprealms.shop.service;

import net.oprealms.shop.object.Shop;

import java.util.HashMap;
import java.util.Map;

public class ShopService {

    private final Map<String, Shop> shops;

    public ShopService() {
        shops = new HashMap<>();
    }

    public Map<String, Shop> getShops() {
        return shops;
    }
}

