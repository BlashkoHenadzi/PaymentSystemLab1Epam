package view.impl;

import controller.Commands;
import controller.Controller;
import view.View;

import java.util.Scanner;

public class ConsoleView implements View {
    private Controller controller = new Controller();
    private void printListOfCommands(){
        Commands[] commands = controller.getListOfCommands();
        for (Commands command: commands) {
            System.out.println(String.format("%d. %s;", command.getID(), command.getName()));
        }
    }
    @Override
    public void start() {
        System.out.println("----Payments----");
        Scanner in = new Scanner(System.in);
        int currentCommand = Commands.COMMANDS.getID();
        while (currentCommand != Commands.EXIT.getID()) {
            if (currentCommand == Commands.COMMANDS.getID()) {
                printListOfCommands();
            }
            try {
                currentCommand = in.nextInt();

                if (currentCommand > Commands.values().length){
                    currentCommand = Commands.COMMANDS.getID();
                }
                else {
                     String parameters = "" ;
                     System.out.println("Please, enter this parameters by spaces:");
                     parameters = in.next();
                     System.out.println(controller.command(new String[]{String.valueOf(currentCommand),parameters}));
                }


            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
