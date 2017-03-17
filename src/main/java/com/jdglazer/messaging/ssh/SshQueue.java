package com.jdglazer.messaging.ssh;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A class that serves as the model for an ssh queue and provides functionality to stage commands and
 * files for sending on the queue. Also stores the output from send commands
 * @author jglazer
 *
 */
public class SshQueue implements Runnable  {
	
	private boolean running = true;

	private String name;
	
	private SshQueueConfig config;
	
	private ConcurrentHashMap< String, SshLocation > outputEndpoints = new ConcurrentHashMap<String, SshLocation>();
	
	private ArrayList < Object > commandFileQueue = new ArrayList< Object >();
	
	private ArrayList< SshCommandRecord > pastCommands = new ArrayList< SshCommandRecord >(); 
	
	public SshQueue( SshQueueConfig config ) {
		this.config = config;
	}
	
	public void addToQueue( Object in ) {
		synchronized( commandFileQueue ) {
			commandFileQueue.add( in );
		}
	}
	
	private Object getFromQueue() {
		synchronized( commandFileQueue ) {
			if( commandFileQueue.size() > 0 )
				return commandFileQueue.remove( commandFileQueue.size() );
			else
				return null;
		}
	}
	
	
	private long getImportVolume( long timeInterval ) {
		long volume = 0;
		synchronized( pastCommands ) {
			long currentTime = System.currentTimeMillis();
			for( int i = pastCommands.size() - 1; i >= 0; i-- ) {
				if( currentTime - pastCommands.get(i).getTime() <= timeInterval ) {
					volume += pastCommands.get(i).getSizeOfImport();
				}
				else {
					break;
				}
			}
		}
		return volume;
	}
	
	private int getCommandCount( long timeInterval ) {
		int volume = 0;
		synchronized( pastCommands ) {
			long currentTime = System.currentTimeMillis();
			for( int i = pastCommands.size() - 1; i >= 0; i-- ) {
				if( currentTime - pastCommands.get(i).getTime() <= timeInterval ) {
					volume++;
				}
				else {
					break;
				}
			}
		}
		return volume;
	}
	
	public void run() {
		while( running ) {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void stop() {
		running = false;
	}
}
