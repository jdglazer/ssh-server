package com.jdglazer.messaging.serialization;

import java.io.File;

public class Deserializer {
	
	public Object deserialize( File file ) {
		System.out.println(file);
		if( !file.delete() )
			System.out.println("Failed to delete file");
		return new Object();
	}
	
}
