package by.andersenlab.shop.commands.console_commands;

import by.andersenlab.shop.pages.MainPage;

public class AdministratorActionConsoleCommand implements ConsoleCommand {

    private static final int ID = 1;

    @Override
    public void execute() {
        MainPage mainPage = new MainPage();
        mainPage.commandChoice();
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
