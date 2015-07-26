package com.workshare.msnos.core_client.commands;

import java.util.Set;

import com.workshare.msnos.core.Cloud;
import com.workshare.msnos.core.Gateway;
import com.workshare.msnos.core.protocols.ip.Endpoint;
import com.workshare.msnos.core.protocols.ip.Endpoints;
import com.workshare.msnos.core.protocols.ip.www.WWWGateway;
import com.workshare.msnos.core_client.Bootstrap;
import com.workshare.msnos.core_client.Command;
import com.workshare.msnos.core_client.SysConsole;

public class ListEndpointsCommand implements Command {

    @Override
    public String description() {
        return "List all endpoints";
    }

    @Override
    public void execute() throws Exception {
        final Cloud grid = Bootstrap.grid();

        final Set<Gateway> gates = grid.getGateways();
        SysConsole.out.println("Gates: "+gates.size());
        for (Gateway gate : gates) {
            if (gate instanceof WWWGateway)
                continue;
            
            Endpoints endpoints = gate.endpoints();
            SysConsole.out.println("  "+gate.name()+" gate:");
            for (Endpoint endpoint : endpoints.all()) {
                SysConsole.out.println("    "+endpoint);
            }
        }
    }
    
}
