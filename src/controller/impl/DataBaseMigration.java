package controller.impl;

import controller.CommandConsole;
import services.factory.ServiceFactory;

public class DataBaseMigration implements CommandConsole {
    @Override
    public String[] getCommandParameters() {
        return new String[0];
    }

    @Override
    public String execute(String request) {
        return null;
    }
}
