package by.andersenlab.shop.commands.console_commands;

public class ReturnToMainPageConsoleCommand implements ConsoleCommand {

    private static final int ID = 0;

    @Override
    public void execute() {
        System.out.println("<--- Возвращаемся на главную страницу <---");
    }

    @Override
    public void showCommandInfo() {
        System.out.println(ID + " - Вернуться на глвную страницу");
    }

    @Override
    public int getCommandId() {
        return ID;
    }
}
