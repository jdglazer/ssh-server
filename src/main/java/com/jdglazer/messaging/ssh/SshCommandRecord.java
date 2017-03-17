package com.jdglazer.messaging.ssh;

public class SshCommandRecord {
	
	public static final int FILE_TRANSFER = 1;
	public static final int BASH_COMMAND = 2;
	
	private int commandType;
	private boolean success;
	private long time;
	private long sizeOfImport;
	
	public int getCommandType() {
		return commandType;
	}
	public void setCommandType(int commandType) {
		this.commandType = commandType;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getSizeOfImport() {
		return sizeOfImport;
	}
	public void setSizeOfImport(long sizeOfImport) {
		this.sizeOfImport = sizeOfImport;
	}
}
