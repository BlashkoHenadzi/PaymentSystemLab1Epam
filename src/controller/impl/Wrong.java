package controller.impl;

import controller.Command;

public class Wrong implements Command {
    @Override
    public String execute(String request) {
        return "Wrong command";
    }
}
