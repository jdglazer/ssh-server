package com.jdglazer.messaging.ssh;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SshCommandExecutor extends ProcessExecutor {
	
	public static void main( String [] args ) throws IOException {
		File file1 = new File("/home/jglazer/Documents/test.ser");
		File file2 = new File("/home/jglazer/Documents/test1.ser");
		file1.createNewFile(); file2.createNewFile();
		ObjectOutputStream oos1 = new ObjectOutputStream( new FileOutputStream(file1 ) );
		ObjectOutputStream oos2 = new ObjectOutputStream( new FileOutputStream( file2 ) );
		SshCommand command1 = new SshCommand();
		command1.setCommandType(SshCommand.COMMAND_EXECUTION);
		command1.setExecutionString("mkdir -p /var/tmp");
		command1.setQueueName("myQueue");
		SshCommand command2 = new SshCommand();
		command2.setCommandType(SshCommand.FILE_TRANSFER);
		command2.setExecutionString("/var/tmp/apatch");
		command2.setQueueName("machine1_transfer");
		
		oos1.writeObject(command1);
		oos2.writeObject(command2);
	}
	
	
}
