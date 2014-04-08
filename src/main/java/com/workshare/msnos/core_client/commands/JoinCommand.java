package com.workshare.msnos.core_client.commands;

import java.util.UUID;

import com.workshare.msnos.core.Agent;
import com.workshare.msnos.core_client.Bootstrap;
import com.workshare.msnos.core_client.Command;

public class JoinCommand implements Command {

	@Override
	public String description() {
		return "Join the grid";
	}

	@Override
	public void execute() throws Exception {

		Agent me = new Agent(UUID.randomUUID());
		me.join(Bootstrap.grid());
		System.out.println("Grid joined! As agent "+me);
	}

}
