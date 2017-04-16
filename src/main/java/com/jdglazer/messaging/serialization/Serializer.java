package com.jdglazer.messaging.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {
	
	public static byte [] serialize( Object object ) throws IOException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream( );
		ObjectOutputStream objectOutputStream = new ObjectOutputStream( byteOut );
		objectOutputStream.writeObject( object );
		return byteOut.toByteArray();
	}
	
}
