package by.andersenlab.shop.singleton;

import by.andersenlab.shop.Shop;

public class ShopSingleton {

    private static volatile Shop shop;

    private ShopSingleton() {}

    public static Shop getShop() {
        if (shop == null) {
            synchronized (ShopSingleton.class) {
                if (shop == null) {
                    shop = new Shop();
                }
            }
        }
        return shop;
    }
}
