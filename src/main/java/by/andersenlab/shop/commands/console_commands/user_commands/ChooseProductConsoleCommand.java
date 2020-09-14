package by.andersenlab.shop.commands.console_commands.user_commands;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.commands.shop_commands.GetAllProductsCommand;
import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.pages.Page;
import by.andersenlab.shop.pages.shop_pages.ProductPage;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

import java.util.Set;

public class ChooseProductConsoleCommand implements ConsoleCommand {

    private static final int ID = 1;

    @Override
    public void execute() {
        Set<Product> products = ShopSingleton.getShop().processReturnProducts(new GetAllProductsCommand());
        if (products.size() > 0) {
            Product product = findProductById(products);
            Page page = new ProductPage(product);
            page.showAvailableCommands();
            page.commandChoice();
        } else {
            System.out.println("<-- В магазине на данный момент нету товаров -->");
        }
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Открыть страницу товара");
    }

    @Override
    public int getCommandId() {
        return ID;
    }

    private Product findProductById(Set<Product> products) {
        Product resultProduct;
        while(true) {
            int productId = ConsoleInput.
                    getIntegerFromConsoleInput("Введите Id товара на страницу которого хотите перейти: ");
            resultProduct = products.stream().
                    filter(product -> product.getProductId() == productId).
                    findFirst().
                    orElse(null);
            if (resultProduct != null) {
                break;
            } else {
                System.out.println("Id товара не найден! Попробуйте ещё раз.");
            }
        }
        return resultProduct;
    }
}
