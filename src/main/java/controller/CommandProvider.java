package controller;

import controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    Map<Commands, CommandConsole> commandMap = new HashMap<>();

    public CommandProvider() {
        commandMap.put(Commands.READCLIENT, new ClientPrint());
        commandMap.put(Commands.UPDATECLIENT, new ClientUpdate());
        commandMap.put(Commands.DELETECLIENT, new ClientDelete());
        commandMap.put(Commands.CREATECLIENT, new ClientAdd());
        commandMap.put(Commands.CREATECREDITCARD, new CreditCardAdd());
        commandMap.put(Commands.UPDATECREDITCARD, new CreditCardUpdate());
        commandMap.put(Commands.DELETECREDITCARD, new CreditCardDelete());
        commandMap.put(Commands.READCREDITCARD, new CreditCardPrint());
        commandMap.put(Commands.READDEBETCARD, new DebetCardPrint());
        commandMap.put(Commands.UPDATEDEBETCARD, new DebetCardUpdate());
        commandMap.put(Commands.DELETEDEBETCARD, new DebetCardDelete());
        commandMap.put(Commands.CREATEDEBETCARD, new DebetCardAdd());
        commandMap.put(Commands.SORTCLIENTBYNAME, new ClientSortByName());
        commandMap.put(Commands.SORTCLIENTBYID, new ClientSortById());
        commandMap.put(Commands.SEARCHCREDITCARDBYNAME, new SearchCreditCardByName());
        commandMap.put(Commands.WRONG, new Wrong());
        commandMap.put(Commands.MIGRATETODB, new DataBaseMigration());
    }

    CommandConsole getCommand(final int number) {
        Commands commandName;
        CommandConsole command;
        try {
            command = commandMap.get(Commands.getValueFromID(number));
        } catch (IllegalArgumentException | NullPointerException e) {
            command = commandMap.get(Commands.WRONG);
        }
        return command;
    }
}

