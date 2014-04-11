package com.workshare.msnos.core_client.commands;

import com.workshare.msnos.core_client.Bootstrap;
import com.workshare.msnos.core_client.Command;

public class LeaveCommand implements Command {

    @Override
    public String description() {
        return "Leave the grid";
    }

    @Override
    public void execute() throws Exception {
        JoinCommand.me.leave(Bootstrap.grid());
    }
}
