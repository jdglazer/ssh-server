package com.jdglazer.messaging.ssh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public class SshCommandProvider implements ChannelInterceptor {
	
	public static final String LOCAL_KEY_GEN = "ssh-keygen -t rsa";
	
	public static final String key_transfer( String user_at_host, String id_file ) {
		return "/usr/bin/ssh-copy-id"+((id_file != null)? "-i "+id_file : "")+" "+user_at_host;
	}
	
	public static final String open_session( String user, String host ){
		return "ssh -l "+user+" "+host;
	}
	
	public void postSend( Message<?> message, MessageChannel channel, boolean sent ) {

	}

	public void afterReceiveCompletion(Message<?> arg0, MessageChannel arg1, Exception arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterSendCompletion(Message<?> arg0, MessageChannel arg1, boolean arg2, Exception arg3) {
		// TODO Auto-generated method stub
		
	}

	public Message<?> postReceive(Message<?> arg0, MessageChannel arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean preReceive(MessageChannel arg0) {
		Logger logger = LoggerFactory.getLogger( SshCommandProvider.class );
		logger.info("Command is here");
		return false;
	}

	public Message<?> preSend(Message<?> arg0, MessageChannel arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
