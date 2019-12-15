package controller;

import java.util.HashMap;
import java.util.Map;

public enum Commands {
    CREATECLIENT(0,"Add User"),
    READCLIENT(1,"Read Clients"),
    UPDATECLIENT(2, "Update User"),
    DELETECLIENT(3,"Delete User"),
    CREATECREDITCARD(4,"Add Credit-Card"),
    READCREDITCARD(5,"Read CreditCards"),
    UPDATECREDITCARD(6,"Update CreditCard"),
    DELETECREDITCARD(7, "Delete CreditCard"),
    CREATEDEBETCARD(8,"Add Debit-Card"),
    READDEBETCARD(9,"Read DebetCards"),
    UPDATEDEBETCARD(10,"Update DebitCard"),
    DELETEDEBETCARD(11, "Delete DebitCard"),
    SORTCLIENTBYNAME(12,"Sort clients by name"),
    SORTCLIENTBYID(13,"Sort clients by id"),
    SEARCHCREDITCARDBYNAME(14,"Sarch credit card by name"),
    COMMANDS(15,"Commands"),
    EXIT(16,"Exit"),
    WRONG(17,"--"),
    MIGRATETODB(18,"Send to DataBase");
    private final int id;
    private final String name;

    private static final Map<Integer, Commands> commandsID = new HashMap<Integer, Commands>();
    private static final Map<String, Commands> commandsName = new HashMap<String, Commands>();

    static {
        for (Commands command: Commands.values()) {
            commandsID.put(command.id, command);
            commandsName.put(command.name.toLowerCase(),command);
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
    public static Commands getValueFromName(String name){return commandsName.get(name.toLowerCase());}



}
