package controller.impl;

import controller.Command;
import controller.CommandConsole;

public class Wrong implements CommandConsole {
    @Override
    public String execute(String request) {
        return "Wrong command";
    }

    @Override
    public String[] getCommandParameters() {
        return new String[0];
    }
}
