package by.andersenlab.shop.pages.shop_pages;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ReturnToMainPageConsoleCommand;
import by.andersenlab.shop.commands.console_commands.user_commands.RemoveProductFromShoppingCartConsoleCommand;
import by.andersenlab.shop.pages.Page;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShoppingCartPage extends Page {

    private static Set<ConsoleCommand> availableCommands = new HashSet<>(Arrays.asList(
            new RemoveProductFromShoppingCartConsoleCommand(),
            new ReturnToMainPageConsoleCommand()
    ));

    public ShoppingCartPage() {
        super(availableCommands);
    }
}
