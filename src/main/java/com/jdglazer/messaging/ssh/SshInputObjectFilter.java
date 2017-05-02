package com.jdglazer.messaging.ssh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class SshInputObjectFilter implements MessageSelector {
	
	private boolean blockAll;
	
	public SshInputObjectFilter() {
		blockAll = false;
	}
	
	public boolean accept( Message<?> message ) {
		if( ( message instanceof SshCommand ) && !blockAll ) {
			SshCommand command = (SshCommand) message;
			return command.getQueueName() != null && command.getExecutionString() != null;
		}
		else 
			return false;
	}
	
	public void blockAllCommands( boolean block ) {
		blockAll = block;
	}
	
	public boolean commandsBlocked() {
		return blockAll;
	}
}
