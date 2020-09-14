package by.andersenlab.shop.commands.console_commands.admin_commands;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.pages.users_pages.AdministratorMainPage;

public class AdministratorActionConsoleCommand implements ConsoleCommand {

    private static final int ID = 1;

    @Override
    public void execute() {
        AdministratorMainPage administratorMainPage = new AdministratorMainPage();
        administratorMainPage.showAvailableCommands();
        administratorMainPage.commandChoice();
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Совершить действие как администратор");
    }

    @Override
    public int getCommandId() {
        return ID;
    }
}
