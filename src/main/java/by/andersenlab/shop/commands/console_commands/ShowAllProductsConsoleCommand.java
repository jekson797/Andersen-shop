package by.andersenlab.shop.commands.console_commands;

import by.andersenlab.shop.commands.shop_commands.GetAllProductsCommand;
import by.andersenlab.shop.singleton.ShopSingleton;

public class ShowAllProductsConsoleCommand implements ConsoleCommand {

    private static final int ID = 3;

    @Override
    public void execute() {
        ShopSingleton.getShop().processReturnProducts(new GetAllProductsCommand()).forEach(System.out::println);
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Показать все товары");
    }

    @Override
    public int getCommandId() {
        return ID;
    }
}
