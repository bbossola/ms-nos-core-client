package com.workshare.msnos.core_client.commands;

import com.workshare.msnos.core.LocalAgent;
import com.workshare.msnos.core.Message;
import com.workshare.msnos.core_client.Bootstrap;
import com.workshare.msnos.core_client.Command;

public class PingCommand implements Command {

    @Override
    public String description() {
        return "Send a ping";
    }

    @Override
    public void execute() throws Exception {
        LocalAgent me = Bootstrap.agent();
        me.send(new Message(Message.Type.PIN, me.getIden(), Bootstrap.grid().getIden(), 2, false, null));
    }
}
