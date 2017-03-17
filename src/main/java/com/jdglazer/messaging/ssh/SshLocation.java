package com.jdglazer.messaging.ssh;

import java.io.Serializable;

/**
 * A class that models the relevant access data for an ssh location
 * @author jglazer
 *
 */
public class SshLocation implements Serializable {
	
	public static final int PASSWORD_AUTH = 1;
	
	public static final int KEY_AUTH = 2;
	
	private String host;
	
	private String user;
	
	private String authType;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

}
