package com.jdglazer.messaging.ssh;

import java.io.Serializable;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class SshCommand implements Message, Serializable {

	private static final long serialVersionUID = 1L;

	public MessageHeaders getHeaders() {

		return null;
	}

	public Object getPayload() {

		return this;
	}

}
