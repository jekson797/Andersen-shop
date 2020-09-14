package by.andersenlab.shop.pages.users_pages;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ExitConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ReturnToMainPageConsoleCommand;
import by.andersenlab.shop.commands.console_commands.user_commands.OpenCatalogPageConsoleCommand;
import by.andersenlab.shop.commands.console_commands.user_commands.OpenShoppingCartConsoleCommand;
import by.andersenlab.shop.pages.Page;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserMainPage extends Page {

    private static Set<ConsoleCommand> availableCommands = new HashSet<>(Arrays.asList(
            new OpenCatalogPageConsoleCommand(),
            new OpenShoppingCartConsoleCommand(),
            new ReturnToMainPageConsoleCommand()
    ));

    public UserMainPage() {
        super(availableCommands);
    }
}
