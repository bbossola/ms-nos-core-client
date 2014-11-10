package com.workshare.msnos.core_client.commands;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import com.workshare.msnos.core.Agent;
import com.workshare.msnos.core.Cloud;
import com.workshare.msnos.core.RemoteAgent;
import com.workshare.msnos.core.protocols.ip.Endpoint;
import com.workshare.msnos.core_client.Bootstrap;
import com.workshare.msnos.core_client.Command;

public class StatusCommand implements Command {

    @Override
    public String description() {
        return "Grid status";
    }

    @Override
    public void execute() throws Exception {
        final Cloud grid = Bootstrap.grid();

        System.out.println();
        dump("  ",  Bootstrap.agent());

        try {
            final Collection<RemoteAgent> remoteAgents = grid.getRemoteAgents();
            System.out.println("  " + "Remote Agents: " + remoteAgents.size());
            for (Agent agent : remoteAgents) {
                dump("    ", agent);
            }
        } finally {
            System.out.println();
        }
    }

    private void dump(final String prefix, final Agent agent) {
 
        System.out.println(prefix+"Agent: "+agent.getIden().getUUID());
        System.out.println(prefix+"  Last seen: "+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(agent.getAccessTime())));

        final Set<Endpoint> points = agent.getEndpoints();
        System.out.println(prefix+"  Endpoints: "+points.size());
        for (Endpoint ep : points) {
            System.out.println(prefix+"    "+ep);
        }
        
        System.out.println();
    }
    

}
