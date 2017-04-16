package com.jdglazer.messaging.ssh;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class SshInputObjectFilter implements MessageSelector {
	
	private boolean blockAll;
	
	public SshInputObjectFilter() {
		blockAll = false;
	}
	
	public boolean accept( Message message ) {
		return ( message instanceof SshCommand ) && !blockAll;
	}
	
	public void blockAllCommands( boolean block ) {
		blockAll = block;
	}
	
	public boolean commandsBlocked() {
		return blockAll;
	}
}
