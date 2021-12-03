package net.oprealms.shop.menu;

import me.lucko.helper.item.ItemStackBuilder;
import me.lucko.helper.menu.paginated.PageInfo;
import me.lucko.helper.menu.paginated.PaginatedGui;
import me.lucko.helper.menu.paginated.PaginatedGuiBuilder;
import me.lucko.helper.menu.scheme.MenuScheme;
import me.lucko.helper.menu.scheme.StandardSchemeMappings;
import net.oprealms.shop.object.Shop;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShopMenu extends PaginatedGui {


    public static final int DEFAULT_LINES = 6;

    public static final int DEFAULT_NEXT_PAGE_SLOT = new MenuScheme()
            .maskEmpty(5)
            .mask("000000010")
            .getMaskedIndexes().get(0);

    public static final int DEFAULT_PREVIOUS_PAGE_SLOT = new MenuScheme()
            .maskEmpty(5)
            .mask("010000000")
            .getMaskedIndexes().get(0);

    public static final List<Integer> DEFAULT_ITEM_SLOTS = new MenuScheme()
            .mask("011111110")
            .mask("011111110")
            .mask("011111110")
            .mask("011111110")
            .mask("011111110")
            .getMaskedIndexesImmutable();

    public static final MenuScheme DEFAULT_SCHEME = new MenuScheme(StandardSchemeMappings.STAINED_GLASS)
            .mask("100000001")
            .mask("100000001")
            .mask("100000001")
            .mask("100000001")
            .mask("100000001")
            .mask("100000001")
            .scheme(10, 10)
            .scheme(10, 10)
            .scheme(10, 10)
            .scheme(10, 10)
            .scheme(10,10)
            .scheme(10, 10);

    public static final Function<PageInfo, ItemStack> DEFAULT_NEXT_PAGE_ITEM = pageInfo -> ItemStackBuilder.of(Material.ARROW)
            .name("&7Next Page ->")
            .lore("&fSwitch to the next page.").build();

    public static final Function<PageInfo, ItemStack> DEFAULT_PREVIOUS_PAGE_ITEM = pageInfo -> ItemStackBuilder.of(Material.ARROW)
            .name("&7Last Page <-")
            .lore("&fSwitch to the previous page.")
            .build();

    public ShopMenu(Player player, Shop shop) {
        super(paginatedGui -> shop.getItems().stream().map(shopItem -> shopItem.getItem(player)).collect(Collectors.toList()), player, PaginatedGuiBuilder.create().title("&8 " +shop.getTitle())
                .itemSlots(DEFAULT_ITEM_SLOTS)
                .scheme(DEFAULT_SCHEME)
                .nextPageItem(DEFAULT_NEXT_PAGE_ITEM)
                .previousPageItem(DEFAULT_PREVIOUS_PAGE_ITEM));


    }
}
