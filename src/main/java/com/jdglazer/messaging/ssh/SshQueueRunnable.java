package com.jdglazer.messaging.ssh;

/**
 * One instance of the class per thread assigned to queue
 * @author jglazer
 *
 */
public class SshQueueRunnable implements Runnable {
	
	private SshQueue sshQueue;
	
	public void run() {
		while( sshQueue.isRunning() ) {
			//business logic to send commands from the queue
			try {
				Thread.sleep(sshQueue.QUEUE_FLUSH_INTERVAL);
			} catch (InterruptedException e) {
			}
		}
	}

	public SshQueue getSshQueue() {
		return sshQueue;
	}

	public void setSshQueue(SshQueue sshQueue) {
		this.sshQueue = sshQueue;
	}
}
