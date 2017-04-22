package com.jdglazer.messaging.ssh;

public abstract class SshCommandProvider {
	
	public static final String LOCAL_KEY_GEN = "ssh-keygen -t rsa";
	
	public static final String key_transfer( String user_at_host, String id_file ) {
		return "/usr/bin/ssh-copy-id"+((id_file != null)? "-i "+id_file : "")+" "+user_at_host;
	}
	
	public static final String open_session( String user, String host ){
		return "ssh -l "+user+" "+host;
	}
	
}
