package com.jdglazer.messaging.ssh;

import java.util.concurrent.ConcurrentHashMap;

/**
 * A class that stores and distributes all ssh queues
 * @author jglazer
 *
 */
public class SshQueueManager {

	private ConcurrentHashMap<String, SshQueue> queueMap;
	
	public SshQueueManager() {
		queueMap = new ConcurrentHashMap< String, SshQueue >();
	}
	
	public void addQueue( String name, SshQueue queue ) {
		queueMap.put(name, queue);
	}
	
	public void addQueue( SshQueue queue ){
		queueMap.put( queue.getName(), queue );
	}
	
	public SshQueue getQueue( String name ) {
		return queueMap.get(name);
	}
}
