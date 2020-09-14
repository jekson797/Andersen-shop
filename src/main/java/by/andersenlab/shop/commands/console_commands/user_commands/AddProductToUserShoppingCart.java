package by.andersenlab.shop.commands.console_commands.user_commands;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

public class AddProductToUserShoppingCart implements ConsoleCommand {

    private static final int ID = 1;
    private Product product;

    public AddProductToUserShoppingCart(Product product) {
        this.product = product;
    }

    @Override
    public void execute() {
        ShopSingleton.getShop().getUser().getShoppingCart().add(product);
        System.out.println("Товар успешно добавлен в вашу корзину ;)");
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Добавить товар в корзину");
    }

    @Override
    public int getCommandId() {
        return ID;
    }
}
