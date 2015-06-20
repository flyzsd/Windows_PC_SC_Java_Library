package org.zsd.win32.pcsc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.zsd.win32.utils.OS;

public abstract class WriteBuffer {
	private final int handle;
	private final ByteBuffer buffer;
	
	private WriteBuffer(int length, int handle){
		this.handle = handle;
		this.buffer = ByteBuffer.allocate(length);		
		this.buffer.order(ByteOrder.nativeOrder());
	}
	
	public int getHandle() {
		return handle;
	}
	
	public final static class XfsWriteBuffer extends WriteBuffer {		
		private XfsWriteBuffer(int length, int handle) {
			super(length, handle);
		}

		public static XfsWriteBuffer allocate(int length){
			int handle = OS.AllocateBuffer(length);
			return new XfsWriteBuffer(length, handle);
		}
		
		public WriteBuffer allocateMore(int length){
			int handle = OS.AllocateMore(length, super.handle);
			return new WriteBuffer(length, handle){};
		}		
	}
	
	public void putBoolean(boolean value) {
		this.buffer.putInt(value ? 1 : 0);
	}
	
	public void putShort(short value) {
		this.buffer.putShort(value);
	}
	
	public void putInt(int value) {
		this.buffer.putInt(value);
	}
	
	public void putLong(int value) {
		this.buffer.putLong(value);
	}
	
	public void putByte(byte value) {
		this.buffer.put(value);
	}
	
	public void put(byte[] bytes) {
		this.buffer.put(bytes);
	}
	
	/**
	 * Flush the buffer into C memory and return the handle.
	 * Note: No further methods could be invoked.
	 * @return
	 */
	public int flush(){
		this.buffer.flip();
		byte[] bytes = new byte[this.buffer.remaining()];
		this.buffer.get(bytes);
		OS.setByteArray(this.handle, bytes);
		return this.handle;
	}
}