package com.jdglazer.messaging.ssh;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SshExecutor {
	
	public static final String PUBLIC_KEY_FILE = "id_rsa.pub";
	private static String PUBLIC_KEY_DIRECTORY = "~/.ssh/";
	
	public static int executeLocalKeygen() {
		Process process = ProcessExecutor.executeWithoutBlocking( SshCommandProvider.LOCAL_KEY_GEN );
		OutputStream stdin = process.getOutputStream();
		BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( stdin) );
		int count = 0;
		while ( process.isAlive() ) {
			try {
				Thread.sleep(300);
				if( count == 0 ) {
					if( !PUBLIC_KEY_DIRECTORY.equals( "~/.ssh/") ) {
						writer.write( PUBLIC_KEY_DIRECTORY+PUBLIC_KEY_FILE);
					} else {
						writer.write("\n");
					}
				} else {
					writer.write("\n");
				}
				writer.flush();
				Thread.sleep(200);
				count++;
			} catch (InterruptedException e) {} 
			catch (IOException e) {}
		}
		return process.exitValue();
	}
	
	public static int exchangeKey( String remoteUser, String remoteHost, String remotePasswd) {
		JSch shell = new JSch();
		File file = new File ( PUBLIC_KEY_FILE );
		ChannelExec exec = null;
		Session session = null;
		
		try {
			List<String> pubkey = IOUtils.readLines( new FileInputStream(file) );
			if( pubkey.size() <= 0 ) {
				return 1;
			}
			
			session = shell.getSession(remoteUser, remoteHost, 22);
			session.setPassword(remotePasswd);
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			config.put("PreferredAuthentications", "password");
			session.setConfig( config );
			session.connect();
			
			exec = (ChannelExec) session.openChannel("exec");
			exec.setCommand("echo \""+pubkey.get(0)+"\" >> /root/.ssh/authorized_keys");
			exec.connect();
			
			exec.disconnect();
			session.disconnect();
			
		} catch ( Exception e ) { 
			if( exec != null ) {
				exec.disconnect();
			}
			if ( session != null) {
				session.disconnect();
			}
			return 1; 
		}
		
		return 0;
	}
	
	public int executeCommand( String remoteUser, String remoteHost, String command ) {
		return 0;
	}
	public int executeCommands( String remoteUser, String remoteHost, String...commands ) {
		return 0;
	}
	
	public int executeFileTransfer( String remoteUser, String remoteHost, File file ) {
		String scpCommand = "scp ";
		if( file.exists() && file.canRead() ) {
			if( file.isDirectory() ) {
				scpCommand += " -r";
			}
			scpCommand += " "+file;
		} else {
			return 1;
		}
		scpCommand += " "+remoteUser+"@"+remoteHost;
		Process process = ProcessExecutor.executeWithoutBlocking( scpCommand.trim() );
		try {
			return process.waitFor();
		} catch (InterruptedException e) {
		}
		return 1;
	}
	
	public int executeFilesTransfer( String remoteUser, String remoteHost, File [] files ) {
		
		return 0;
	}
	
	public static void setPublicKeyDirectory( String directory ) {
		PUBLIC_KEY_DIRECTORY = directory;
	}
	
	public static void main( String [] args ) {
		exchangeKey( "root", "10.0.0.11", "75dsb5yi#!");	
	}
}
