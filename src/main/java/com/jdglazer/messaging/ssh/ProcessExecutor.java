package com.jdglazer.messaging.ssh;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessExecutor {
	
	protected static InputStream executeWithBlocking( String command ) {
		Object object = execute( command, true );
		return (object != null) ? (InputStream) object : null;
	}
	
	protected static Process executeWithoutBlocking( String command ) {
		Object object = execute( command, false );
		return (object != null) ? (Process) object : null;
	}
	
	private static Object execute( String command, boolean withBlocking) {
		Logger logger = LoggerFactory.getLogger( ProcessExecutor.class );
		try {
			Process process = Runtime.getRuntime().exec( command );
			if( withBlocking ) {
				if( process.waitFor() != 0 ) {
					logger.error("Command, "+command+", executed with non-zero value.");
					return null;
				}
				return process.getInputStream();
			}
			else {
				return process;
			}
		} catch (IOException e) {
		} catch (InterruptedException e) {
		}
		logger.error("Command, "+command+", failed to execute.");
		return null;
	}
}
