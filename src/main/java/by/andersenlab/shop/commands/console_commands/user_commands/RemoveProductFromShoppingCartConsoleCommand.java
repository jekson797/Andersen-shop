package by.andersenlab.shop.commands.console_commands.user_commands;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.console.ConsoleInput;
import by.andersenlab.shop.products.Product;
import by.andersenlab.shop.singleton.ShopSingleton;

import java.util.ArrayList;

public class RemoveProductFromShoppingCartConsoleCommand implements ConsoleCommand {

    private static final int ID = 1;
    private static final String YES_ANSWER = "yes";
    private static final String NO_ANSWER = "no";
    private final ArrayList<Product> userShoppingCart = ShopSingleton.getShop().getUser().getShoppingCart();

    @Override
    public void execute() {
        boolean isDeleting = true;
        boolean isDeletedSuccessfully;
        while(isDeleting) {
            int productIdForDeleting = ConsoleInput.
                    getIntegerFromConsoleInput("Введите id товара который хотите удалить: ");
            isDeletedSuccessfully = userShoppingCart.removeIf(product -> product.getProductId() == productIdForDeleting);
            isDeleting = !isDeletedSuccessfully;
            if (!isDeletedSuccessfully) {
                isDeleting = offerToTryAgain();
            }
        }
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Удалить товар из корзины");
    }

    @Override
    public int getCommandId() {
        return ID;
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
