package by.andersenlab.shop.commands.console_commands.user_commands;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.pages.Page;
import by.andersenlab.shop.pages.shop_pages.ShoppingCartPage;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

import java.util.ArrayList;

public class OpenShoppingCartConsoleCommand implements ConsoleCommand {

    private static final int ID = 2;

    @Override
    public void execute() {
        ArrayList<Product> userShoppingCart = ShopSingleton.getShop().getUser().getShoppingCart();
        if (userShoppingCart.size() > 0) {
            showShoppingCartProducts(userShoppingCart);
            Page page = new ShoppingCartPage();
            page.showAvailableCommands();
            page.commandChoice();
        } else {
            System.out.println("Корзина пуста!");
        }
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Открыть корзину");
    }

    @Override
    public int getCommandId() {
        return ID;
    }

    private void showShoppingCartProducts(ArrayList<Product> userShoppingCart) {
        System.out.println("Товары в корзине:");
        userShoppingCart.forEach(System.out::println);
    }
}
