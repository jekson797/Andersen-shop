package by.andersenlab.shop.commands.console_commands;

import by.andersenlab.shop.pages.product_remove_page.ProductRemovingPage;

public class RemoveProductConsoleCommand implements ConsoleCommand {

    private static final int ID = 2;

    @Override
    public void execute() {
        ProductRemovingPage page = new ProductRemovingPage();
        page.showProducts();
        page.deleteProduct();
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Удалить продукт из магазина");
    }

    @Override
    public int getCommandId() {
        return ID;
    }
}
