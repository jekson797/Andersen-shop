package by.andersenlab.shop.pages.shop_pages;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ExitConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ReturnToMainPageConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ShowAllProductsConsoleCommand;
import by.andersenlab.shop.commands.console_commands.admin_commands.AddProductConsoleCommand;
import by.andersenlab.shop.commands.console_commands.admin_commands.AdministratorActionConsoleCommand;
import by.andersenlab.shop.commands.console_commands.admin_commands.RemoveProductConsoleCommand;
import by.andersenlab.shop.commands.console_commands.user_commands.UserActionConsoleCommand;
import by.andersenlab.shop.pages.Page;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HomePage extends Page {

    private static Set<ConsoleCommand> availableCommands = new HashSet<>(Arrays.asList(
            new AdministratorActionConsoleCommand(),
            new UserActionConsoleCommand(),
            new ExitConsoleCommand()
    ));

    public HomePage() {
        super(availableCommands);
    }
}
