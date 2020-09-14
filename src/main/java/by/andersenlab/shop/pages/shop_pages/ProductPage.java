package by.andersenlab.shop.pages.shop_pages;

import by.andersenlab.shop.commands.console_commands.ReturnToMainPageConsoleCommand;
import by.andersenlab.shop.commands.console_commands.user_commands.AddProductToUserShoppingCart;
import by.andersenlab.shop.pages.Page;
import by.andersenlab.shop.products.Product;

import java.util.Arrays;
import java.util.HashSet;

public class ProductPage extends Page {

    private Product product;

    public ProductPage(Product product) {
        super(new HashSet<>(Arrays.asList(
                new AddProductToUserShoppingCart(product),
                new ReturnToMainPageConsoleCommand()
        )));
        this.product = product;
        System.out.println("Информация о товаре:\n" + product);
    }
}
