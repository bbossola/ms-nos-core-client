package com.workshare.msnos.core_client.commands;

import com.workshare.msnos.core.Agent;
import com.workshare.msnos.core.Cloud;
import com.workshare.msnos.core.LocalAgent;
import com.workshare.msnos.core.RemoteAgent;
import com.workshare.msnos.core_client.Bootstrap;
import com.workshare.msnos.core_client.Command;

import java.util.Collection;

public class StatusCommand implements Command {

    @Override
    public String description() {
        return "Grid status";
    }

    @Override
    public void execute() throws Exception {
        final Cloud grid = Bootstrap.grid();

        System.out.println();
        System.out.println("  " + "Whoami: " + Bootstrap.agent());
        System.out.println("  " + "Networks: " + Bootstrap.agent().getHosts() + "\n");

        try {
            final Collection<LocalAgent> agents = grid.getLocalAgents();
            System.out.println("  " + "Agents: " + agents.size());
            for (Agent agent : agents) {
                System.out.println("    " + agent);
            }
            final Collection<RemoteAgent> remoteAgents = grid.getRemoteAgents();
            System.out.println("  " + "Remote Agents: " + remoteAgents.size());
            for (RemoteAgent agent : remoteAgents) {
                System.out.println("    " + agent);
            }
        } finally {
            System.out.println();
        }
    }
}
