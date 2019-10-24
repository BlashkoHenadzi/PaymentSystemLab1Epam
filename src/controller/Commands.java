package controller;

import java.util.HashMap;
import java.util.Map;

public enum Commands {
    CREATECLIENT(0,"Add Client"),
    READCLIENT(1,"Read Clients"),
    UPDATECLIENT(2, "Update Client"),
    DELETECLIENT(3,"Delete Client"),
    CREATECREDITCARD(4,"Add CreditCard"),
    READCREDITCARD(5,"Read CreditCards"),
    UPDATECREDITCARD(6,"Update CreditCard"),
    DELETECREDITCARD(7, "Delete CreditCard"),
    CREATEDEBETCARD(8,"Add DebetCard"),
    READDEBETCARD(9,"Read DebetCards"),
    UPDATEDEBETCARD(10,"Update DebetCard"),
    DELETEDEBETCARD(11, "Delete DebetCard"),
    COMMANDS(12,"Commands"),
    EXIT(13,"Exit"),
    WRONG(14,"--");
    private final int id;
    private final String name;

    private static final Map<Integer, Commands> commandsID = new HashMap<>();
    //private static int[] commandsID;

    static {
        for (Commands commandName: Commands.values()) {
            commandsID.put(commandName.id, commandName);
        }
    }

    Commands(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Commands getValueFromID(int id){
        return commandsID.get(id);
    }
}
