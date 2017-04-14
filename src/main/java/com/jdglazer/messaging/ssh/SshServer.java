package com.jdglazer.messaging.ssh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SshServer {
	
	private static final String APPLICATION_CONFIG_PATH = "com/jdglazer/messaging/ssh/config/ssh-server-config.xml";
	
	public static void main( String [] args ) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( APPLICATION_CONFIG_PATH );
	}
	
}
