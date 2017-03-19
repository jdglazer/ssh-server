package com.jdglazer.messaging.ssh;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class SshThreadPool {
	
	/**
	 * A pool of Threads stored in array lists. Each list is associated to the string name
	 * of the queue with which the threads are associated
	 */
	private ConcurrentHashMap< String, ArrayList<Thread> > threadPool;
	
	public synchronized void addQueuePool( SshQueue sshQueue, int threadCount ) {
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		
		for( int i = 0; i < threadCount; i++ ) {
			SshQueueRunnable runnable = new SshQueueRunnable();
			runnable.setSshQueue( sshQueue );
			threadList.add( new Thread( runnable ) );
		}
		
		threadPool.put( sshQueue.getName(), threadList );
	}
	
	public synchronized Thread getThread( String queueName, int threadNumber ) {
		try {
			return threadPool.get( queueName ).get( threadNumber );
		} catch( Exception e ) {
			return null;
		}
	}
}
