package org.zsd.win32.pcsc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ReadBuffer {
	private final ByteBuffer buffer;
	
	public ReadBuffer(byte[] array){
		buffer = ByteBuffer.wrap(array);
		buffer.order(ByteOrder.nativeOrder());
	}
	
    public byte getByte(){
    	return buffer.get();
    }
    
    public void getBytes(byte[] bytes){
    	buffer.get(bytes);
    }
	
    public boolean getBoolean() {
    	return buffer.getInt() != 0;
    }
	
    public short getShort() {
    	return buffer.getShort();
    }
	
    public int getInt() {
    	return buffer.getInt();
    }
    
    public long getLong() {
    	return buffer.getLong();
    }
}