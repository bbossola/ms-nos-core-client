package com.workshare.msnos.core_client;

public interface Command {
	
	public String description()
	;

	public void execute() throws Exception
	;
}
