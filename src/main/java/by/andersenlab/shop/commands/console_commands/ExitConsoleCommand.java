package by.andersenlab.shop.commands.console_commands;

public class ExitConsoleCommand implements ConsoleCommand {

    private static final int ID = 0;

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Выйти из приложения");
    }

    @Override
    public int getCommandId() {
        return ID;
    }
}
