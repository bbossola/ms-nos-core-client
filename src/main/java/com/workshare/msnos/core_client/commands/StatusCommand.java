package com.workshare.msnos.core_client.commands;

import java.util.Collection;

import com.workshare.msnos.core.Agent;
import com.workshare.msnos.core.Cloud;
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
		System.out.println("  "+"Whoami: "+Bootstrap.agent());
		
		try {
			final Collection<Agent> agents = grid.getAgents();
			System.out.println("  "+"Agents: "+agents.size());
			for (Agent agent : agents) {
				System.out.println("    "+agent);
			}
		}
		finally {
			System.out.println();
		}
	}

}
