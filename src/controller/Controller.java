package controller;

public class Controller {
    private final CommandProvider provider = new CommandProvider();
    public String command (final String[] request){
        Command executionCommand;
        executionCommand = provider.getCommand(Integer.parseInt(request[0]));
        return executionCommand.execute(request[1]);
    }
    public Commands[] getListOfCommands(){
        return  Commands.values();
    }
    public String[] getCommandParameters(int id){return provider.getCommand(id).getCommandParameters();}

}
