package by.andersenlab.shop.commands.console_commands.user_commands;

import by.andersenlab.shop.commands.console_commands.ConsoleCommand;
import by.andersenlab.shop.pages.Page;
import by.andersenlab.shop.pages.users_pages.UserMainPage;

public class UserActionConsoleCommand implements ConsoleCommand {

    private static final int ID = 2;

    @Override
    public void execute() {
        Page page = new UserMainPage();
        page.showAvailableCommands();
        page.commandChoice();
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Совершить действие как пользователь");
    }

    @Override
    public int getCommandId() {
        return ID;
    }
}
