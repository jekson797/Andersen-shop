package by.andersenlab.shop.commands.console_commands.user_commands;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.commands.shop_commands.GetAllProductsCommand;
import by.andersenlab.shop.pages.Page;
import by.andersenlab.shop.pages.shop_pages.CatalogPage;
import by.andersenlab.shop.singleton.ShopSingleton;

public class OpenCatalogPageConsoleCommand implements ConsoleCommand {

    private static final int ID = 1;
    private final Page page = new CatalogPage();

    @Override
    public void execute() {
        showProducts();
        page.showAvailableCommands();
        page.commandChoice();
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Открыть каталог товаров");
    }

    @Override
    public int getCommandId() {
        return ID;
    }

    private void showProducts() {
        ShopSingleton.getShop().
                processReturnProducts(new GetAllProductsCommand()).
                forEach(product -> System.out.println("Id товара: " + product.getProductId() +
                        " | Тип товара: " + product.getGroup() +
                        " | Название: " + product.getName() +
                        " | Цена: " + product.getPrice() +
                        " | Валюта: " + product.getCurrency()));
    }
}
