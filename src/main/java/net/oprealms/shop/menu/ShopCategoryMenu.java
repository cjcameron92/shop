package net.oprealms.shop.menu;

import me.lucko.helper.item.ItemStackBuilder;
import me.lucko.helper.menu.Gui;
import me.lucko.helper.menu.scheme.MenuPopulator;
import me.lucko.helper.menu.scheme.MenuScheme;
import net.oprealms.shop.ShopPlugin;
import net.oprealms.shop.object.ShopType;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ShopCategoryMenu extends Gui {



    private static final MenuScheme BUTTONS = new MenuScheme()
            .mask("000000000")
            .mask("000000000")
            .mask("000111000")
            .mask("000000000")
            .mask("000010000")
            .mask("000000000");


    public ShopCategoryMenu(Player player) {
        super(player, 6, "&8Skills");
    }

    @Override public void redraw() {
        MenuPopulator populate = BUTTONS.newPopulator(this);
        Player player = getPlayer();
        for (int i = 0; i < 54; i++) {
            setItem(i, ItemStackBuilder.of(Material.BLACK_STAINED_GLASS_PANE).buildItem().build());
        }

        for (var s : ShopPlugin.getPlugin().getShopService().getShops().values()) {
            populate.accept(ItemStackBuilder.of(Material.DIAMOND_PICKAXE).name("").build(() -> {

            }));
        }

        for (var type : ShopType.values()) {
            populate.accept(ItemStackBuilder.of(type.getMaterial()).name("").build(() -> {

            }));
        }


        populate.accept(ItemStackBuilder.of(Material.RED_STAINED_GLASS_PANE).name("&cClose").build(player::closeInventory));
    }
}
