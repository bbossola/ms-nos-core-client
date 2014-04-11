package com.workshare.msnos.core_client.commands;

import com.workshare.msnos.core.Agent;
import com.workshare.msnos.core_client.Bootstrap;
import com.workshare.msnos.core_client.Command;

import java.util.UUID;

public class JoinCommand implements Command {

    static Agent me;

    @Override
    public String description() {
        return "Join the grid";
    }

    @Override
    public void execute() throws Exception {
        me = new Agent(UUID.randomUUID());
        me.join(Bootstrap.grid());
        System.out.println("Grid joined! As agent " + me);
    }

}
