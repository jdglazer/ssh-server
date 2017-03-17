package com.jdglazer.messaging.ssh;

/**
 * Determines important traits of a given queue
 * @author jglazer
 *
 */
public class SshQueueConfig {
	
	private int maxCommandsPerMinute;
	
	private int maxDataFlowPerMinute;
	
	private int maxCachedQueueData;
	
	private String queueDataOutputLocation;

	public int getMaxCommandsPerMinute() {
		return maxCommandsPerMinute;
	}

	public void setMaxCommandsPerMinute(int maxCommandsPerMinute) {
		this.maxCommandsPerMinute = maxCommandsPerMinute;
	}

	public int getMaxDataFlowPerMinute() {
		return maxDataFlowPerMinute;
	}

	public void setMaxDataFlowPerMinute(int maxDataFlowPerMinute) {
		this.maxDataFlowPerMinute = maxDataFlowPerMinute;
	}

	public int getMaxCachedQueueData() {
		return maxCachedQueueData;
	}

	public void setMaxCachedQueueData(int maxCachedQueueData) {
		this.maxCachedQueueData = maxCachedQueueData;
	}

	public String getQueueDataOutputLocation() {
		return queueDataOutputLocation;
	}

	public void setQueueDataOutputLocation(String queueDataOutputLocation) {
		this.queueDataOutputLocation = queueDataOutputLocation;
	}
}
