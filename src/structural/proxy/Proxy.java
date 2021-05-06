package structural.proxy;

import java.io.IOException;

class Main
{
    public static void main(String[] args) throws IOException {
        CommandExecutor executor = new Proxy("Darya", "1234D"); //isAdmin
        executor.runCommand("");
    }
}
interface CommandExecutor
{
    void runCommand(String command) throws IOException;
}
class CommandExecutorImpl implements CommandExecutor
{
    @Override
    public void runCommand(String command) throws IOException {
//        Runtime.getRuntime().exec(command); //Heavy Impl
        System.out.println("Hello world");
        System.out.println("command " + command + " is executed");
    }
}
class Proxy implements CommandExecutor
{
    private boolean isAdmin;
    private CommandExecutor executor;
    public Proxy(String username, String password)
    {
        if(username.equals("Darya") && password.equals("1234D"))
            isAdmin = true;
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String command) throws IOException {
        if(isAdmin)
            executor.runCommand(command);
        else {
            if (command.trim().equals("rm")) {
                System.out.println("permission denied");
            }
            else
                executor.runCommand(command);
        }

    }
}