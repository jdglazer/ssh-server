package com.jdglazer.messaging.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deserializer {
	
	Logger logger = LoggerFactory.getLogger( Deserializer.class );
	
	public Object deserialize( File file ) {
		
		Object object = new Object();
		
		if( file.exists() ) {
			
			try {
				
				FileInputStream fileInputStream = new FileInputStream( file );
				ObjectInputStream objectInputStream = new ObjectInputStream( fileInputStream );
				object = objectInputStream.readObject();
				objectInputStream.close();
				
				logger.trace( "Deserialization of object from file "+file.getName()+ " succeeded." );
				
			} catch ( Exception e) {
				logger.warn( "Failed to deserialize object from file " + file.getName() );
			}
			
			if( !file.delete() )
				logger.warn( "Failed to delete file: "+file.getName());
			
		} else {
			logger.warn(" File "+file.getName()+" not found!" );
		}
		
		return object;
	}
	
}
