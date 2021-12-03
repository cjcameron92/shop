package net.oprealms.shop.object;

import java.util.List;

public class Shop {

    private final String title;
    private final List<ShopItem> items;

    public Shop(String title, List<ShopItem> items) {
        this.title = title;
        this.items = items;
    }

    public List<ShopItem> getItems() {
        return items;
    }

    public String getTitle() {
        return title;
    }
}
