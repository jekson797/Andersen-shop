package by.andersenlab.shop.commands.console_commands.admin_commands;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.commands.shop_commands.GetAllProductsCommand;
import by.andersenlab.shop.commands.shop_commands.RemoveProductCommand;
import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

import java.util.Set;

public class RemoveProductConsoleCommand implements ConsoleCommand {

    private static final int ID = 2;
    private static final String YES_ANSWER = "yes";
    private static final String NO_ANSWER = "no";
    private final Set<Product> products = ShopSingleton.getShop().processReturnProducts(new GetAllProductsCommand());

    @Override
    public void execute() {
        showProducts();
        boolean isDeleting = true;
        while(isDeleting) {
            int productIdForDeleting = ConsoleInput.
                    getIntegerFromConsoleInput("Введите id товара который хотите удалить: ");
            for (Product product : products) {
                if (product.getProductId() == productIdForDeleting) {
                    ShopSingleton.getShop().processProduct(new RemoveProductCommand(), product);
                    isDeleting = false;
                } else {
                    isDeleting = offerToTryAgain();
                }
            }
        }
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Удалить продукт из магазина");
    }

    @Override
    public int getCommandId() {
        return ID;
    }

    private void showProducts() {
        products.forEach(System.out::println);
    }

    private boolean offerToTryAgain() {
        System.out.println("Введенный id не найден! Хотите попробовать еще раз?");
        String userAnswer;
        while(true) {
            userAnswer = ConsoleInput.getStringFromConsoleInput("Введите yes / no: ").toLowerCase();
            if (userAnswer.equals(YES_ANSWER) || userAnswer.equals(NO_ANSWER)) {
                break;
            } else {
                System.out.println("Введено неверное значение! Попробуйте ещё раз");
            }
        }
        return userAnswer.contains(YES_ANSWER);
    }
}
