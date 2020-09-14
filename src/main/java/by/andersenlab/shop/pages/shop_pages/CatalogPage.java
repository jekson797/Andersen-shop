package by.andersenlab.shop.pages.shop_pages;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ReturnToMainPageConsoleCommand;
import by.andersenlab.shop.commands.console_commands.user_commands.ChooseProductConsoleCommand;
import by.andersenlab.shop.pages.Page;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CatalogPage extends Page {

    private static Set<ConsoleCommand> availableCommands = new HashSet<>(Arrays.asList(
            new ChooseProductConsoleCommand(),
            new ReturnToMainPageConsoleCommand()
    ));

    public CatalogPage() {
        super(availableCommands);
    }
}
