package com.workshare.msnos.core_client.commands;

import com.workshare.msnos.core.LocalAgent;
import com.workshare.msnos.core_client.Bootstrap;
import com.workshare.msnos.core_client.Command;

public class JoinCommand implements Command {

    @Override
    public String description() {
        return "Join the grid";
    }

    @Override
    public void execute() throws Exception {
        LocalAgent me = Bootstrap.agent();
        me.join(Bootstrap.grid());
        System.out.println("Grid joined! As agent " + me);
    }

}
