package by.andersenlab.shop;

import by.andersenlab.shop.commands.shop_commands.GetAllProductsCommand;
import by.andersenlab.shop.pages.LoginPage;
import by.andersenlab.shop.pages.Page;
import by.andersenlab.shop.singleton.ShopSingleton;

public class Main {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин Дядюшки Сэма");
        Page page = new LoginPage();
        page.commandChoice();
        System.out.println(ShopSingleton.getShop().processReturnProducts(new GetAllProductsCommand()));
    }

    // TODO write unit test
    // TODO create user
    // TODO create stash
    // TODO create console creating
    // TODO create beautiful toString()
}
