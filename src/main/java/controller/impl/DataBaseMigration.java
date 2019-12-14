package controller.impl;

import controller.CommandConsole;
import controller.dbmigration.DBMigrate;
import services.factory.ServiceFactory;

public class DataBaseMigration implements CommandConsole {
    @Override
    public String[] getCommandParameters() {
        return new String[0];
    }

    @Override
    public String execute(String request) {
        DBMigrate dbMigrate = new DBMigrate();
        if(dbMigrate.SendToDB())
            return "true";
            else
                return "false";
    }
}
