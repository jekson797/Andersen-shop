package by.andersenlab.shop.pages.users_pages;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ExitConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ReturnToMainPageConsoleCommand;
import by.andersenlab.shop.commands.console_commands.admin_commands.AddProductConsoleCommand;
import by.andersenlab.shop.commands.console_commands.admin_commands.RemoveProductConsoleCommand;
import by.andersenlab.shop.commands.console_commands.ShowAllProductsConsoleCommand;
import by.andersenlab.shop.pages.Page;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AdministratorMainPage extends Page {

    private static Set<ConsoleCommand> availableCommands = new HashSet<>(Arrays.asList(
            new ReturnToMainPageConsoleCommand(),
            new AddProductConsoleCommand(),
            new RemoveProductConsoleCommand(),
            new ShowAllProductsConsoleCommand()
    ));

    public AdministratorMainPage() {
        super(availableCommands);
    }
}
