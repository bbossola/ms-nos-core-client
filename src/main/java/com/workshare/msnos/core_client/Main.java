package com.workshare.msnos.core_client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.workshare.msnos.core_client.commands.ExitCommand;
import com.workshare.msnos.core_client.commands.JoinCommand;
import com.workshare.msnos.core_client.commands.LeaveCommand;
import com.workshare.msnos.core_client.commands.ListEndpointsCommand;
import com.workshare.msnos.core_client.commands.LogControl;
import com.workshare.msnos.core_client.commands.PingCommand;
import com.workshare.msnos.core_client.commands.StatusCommand;

public class Main {

    private static final Logger logger = Logger.getLogger("com.gridprobe");

    public static Command[] commands = {
            new StatusCommand(),
            new JoinCommand(),
            new LeaveCommand(),
            new PingCommand(),
            new ListEndpointsCommand(),
            new LogControl("routing"),
            new LogControl("protocol"),
            new ExitCommand(),
    };

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {

        Bootstrap.init();

        while (true) {
            showMenu();
            try {
                command().execute();
            } catch (Exception ex) {
                logger.log(Level.WARNING, "An error occured!", ex);
            }

            sleep(500L);
        }
    }

    private Command command() throws IOException {
        String line = SysConsole.in.readLine();

        Command result;
        try {
            int index = Integer.parseInt(line);
            result = commands[index];
        } catch (Exception ignore) {
            result = commands[0];
        }

        return result;
    }

    private void showMenu() {
        System.out.println();
        for (int i = 0; i < commands.length; i++) {
            System.out.printf("%d) %s\n", i, commands[i].description());
        }

        System.out.printf("Action? ");
        System.out.flush();
    }

    private void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
    }
}
