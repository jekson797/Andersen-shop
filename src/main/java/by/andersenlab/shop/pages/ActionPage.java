package by.andersenlab.shop.pages;

import by.andersenlab.shop.commands.console_commands.ExitConsoleCommand;
import by.andersenlab.shop.commands.console_commands.AdministratorActionConsoleCommand;

import java.util.Arrays;
import java.util.HashSet;

public class ActionPage extends Page {

    public ActionPage() {
        super(new HashSet<>(Arrays.asList(
                new ExitConsoleCommand(),
                new AdministratorActionConsoleCommand()
        )));
    }
}
