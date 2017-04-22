package com.jdglazer.messaging.ssh;

import java.io.Serializable;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class SshCommand implements Message, Serializable {
	
	public static final int FILE_TRANSFER = 1;
	public static final int COMMAND_EXECUTION = 2;

	private static final long serialVersionUID = 1L;
	
	private int commandType;
	private String executionString;
	private String queueName;

	public MessageHeaders getHeaders() {
		return null;
	}

	public Object getPayload() {
		return this;
	}

	public int getCommandType() {
		return commandType;
	}

	public void setCommandType(int commandType) {
		this.commandType = commandType;
	}

	public String getExecutionString() {
		return executionString;
	}

	public void setExecutionString(String executionString) {
		this.executionString = executionString;
	}
	
	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

}
