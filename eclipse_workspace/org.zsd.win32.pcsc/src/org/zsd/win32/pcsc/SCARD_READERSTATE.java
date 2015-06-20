package org.zsd.win32.pcsc;

import org.zsd.win32.pcsc.WriteBuffer.XfsWriteBuffer;
import org.zsd.win32.utils.OS;

public class SCARD_READERSTATE {
    private final static int sizeof = PCSC.SCARD_READERSTATE_sizeof();
    
	public String szReader;
	public int pvUserData;
	public int dwCurrentState;
	public int dwEventState;
	public int cbAtr;
	public byte[] rgbAtr = new byte[36];
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("szReader = [" + szReader + "], dwCurrentState = 0x" + String.format("%08X", dwCurrentState));
		if((dwCurrentState & PCSCAPI.SCARD_STATE_IGNORE) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_IGNORE");
		}
		if((dwCurrentState & PCSCAPI.SCARD_STATE_CHANGED) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_CHANGED");
		}
		if((dwCurrentState & PCSCAPI.SCARD_STATE_UNKNOWN) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_UNKNOWN");
		}
		if((dwCurrentState & PCSCAPI.SCARD_STATE_UNAVAILABLE) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_UNAVAILABLE");
		}
		if((dwCurrentState & PCSCAPI.SCARD_STATE_EMPTY) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_EMPTY");
		}
		if((dwCurrentState & PCSCAPI.SCARD_STATE_PRESENT) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_PRESENT");
		}
		if((dwCurrentState & PCSCAPI.SCARD_STATE_ATRMATCH) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_ATRMATCH");
		}
		if((dwCurrentState & PCSCAPI.SCARD_STATE_EXCLUSIVE) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_EXCLUSIVE");
		}
		if((dwCurrentState & PCSCAPI.SCARD_STATE_INUSE) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_INUSE");
		}
		if((dwCurrentState & PCSCAPI.SCARD_STATE_MUTE) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_MUTE");
		}
		if((dwCurrentState & PCSCAPI.SCARD_STATE_UNPOWERED) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_UNPOWERED");
		}
		sb.append(", dwEventState = 0x" + String.format("%08X", dwEventState));
		if((dwEventState & PCSCAPI.SCARD_STATE_IGNORE) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_IGNORE");
		}
		if((dwEventState & PCSCAPI.SCARD_STATE_CHANGED) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_CHANGED");
		}
		if((dwEventState & PCSCAPI.SCARD_STATE_UNKNOWN) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_UNKNOWN");
		}
		if((dwEventState & PCSCAPI.SCARD_STATE_UNAVAILABLE) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_UNAVAILABLE");
		}
		if((dwEventState & PCSCAPI.SCARD_STATE_EMPTY) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_EMPTY");
		}
		if((dwEventState & PCSCAPI.SCARD_STATE_PRESENT) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_PRESENT");
		}
		if((dwEventState & PCSCAPI.SCARD_STATE_ATRMATCH) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_ATRMATCH");
		}
		if((dwEventState & PCSCAPI.SCARD_STATE_EXCLUSIVE) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_EXCLUSIVE");
		}
		if((dwEventState & PCSCAPI.SCARD_STATE_INUSE) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_INUSE");
		}
		if((dwEventState & PCSCAPI.SCARD_STATE_MUTE) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_MUTE");
		}
		if((dwEventState & PCSCAPI.SCARD_STATE_UNPOWERED) != 0x00) {
			sb.append(" ");
			sb.append("SCARD_STATE_UNPOWERED");
		}		
		
		if(cbAtr != 0) {
			sb.append(", ATR = [" + HexString.hexify(rgbAtr, 0, cbAtr) + "]");
		}
		return sb.toString();
	}
	
	public static int toStruct(SCARD_READERSTATE struct) {
		return toStruct(struct, null);
	}

	public static int toStruct(String struct, XfsWriteBuffer parent) {
    	if(struct == null)
    		return 0;
    	
    	int sizeof = (struct.length() + 1) * OS.wchar_t_sizeof();
		WriteBuffer buffer = (parent == null) ? (parent = XfsWriteBuffer.allocate(sizeof)) : parent.allocateMore(sizeof);
		OS.setCWideString(buffer.getHandle(), struct);
		return buffer.getHandle();
	}
	
	public static int toStruct(SCARD_READERSTATE struct, XfsWriteBuffer parent) {
    	if(struct == null)
    		return 0;
    	
		WriteBuffer buffer = (parent == null) ? (parent = XfsWriteBuffer.allocate(sizeof)) : parent.allocateMore(sizeof);
		
		buffer.putInt(toStruct(struct.szReader, parent));
		buffer.putInt(struct.pvUserData);
		buffer.putInt(struct.dwCurrentState);
		buffer.putInt(struct.dwEventState);
		buffer.putInt(struct.cbAtr);
		buffer.put(struct.rgbAtr);
    	return buffer.flush();
    }
	
	public static int toStruct(SCARD_READERSTATE[] array, XfsWriteBuffer parent) {
    	if(array == null)
    		return 0;
    	
		WriteBuffer buffer = (parent == null) ? (parent = XfsWriteBuffer.allocate(sizeof * array.length)) : parent.allocateMore(sizeof * array.length);
		
		for(int i=0; i<array.length; i++) {
			SCARD_READERSTATE struct = array[i];
			buffer.putInt(toStruct(struct.szReader, parent));
			buffer.putInt(struct.pvUserData);
			buffer.putInt(struct.dwCurrentState);
			buffer.putInt(struct.dwEventState);
			buffer.putInt(struct.cbAtr);
			buffer.put(struct.rgbAtr);
		}
    	return buffer.flush();
	}
    
    public static SCARD_READERSTATE fromStruct(int handle) {
    	if(handle == 0)
    		return null;
    	
		ReadBuffer buffer = new ReadBuffer(OS.getByteArray(handle, sizeof));
		SCARD_READERSTATE struct = new SCARD_READERSTATE();
    	struct.szReader = OS.getNullTerminatedCWideString(buffer.getInt());
    	struct.pvUserData = buffer.getInt();
    	struct.dwCurrentState = buffer.getInt();
    	struct.dwEventState = buffer.getInt();;		
    	struct.cbAtr = buffer.getInt();
    	buffer.getBytes(struct.rgbAtr);
    	return struct;
    }
    
    public static SCARD_READERSTATE[] fromStruct(int handle, int length) {
    	if(handle == 0)
    		return null;
		ReadBuffer buffer = new ReadBuffer(OS.getByteArray(handle, sizeof*length));
		SCARD_READERSTATE[] array = new SCARD_READERSTATE[length];
		for(int i=0; i<length; i++) {
			array[i] =  new SCARD_READERSTATE();
			array[i].szReader = OS.getNullTerminatedCWideString(buffer.getInt());
			array[i].pvUserData = buffer.getInt();
			array[i].dwCurrentState = buffer.getInt();
			array[i].dwEventState = buffer.getInt();;		
			array[i].cbAtr = buffer.getInt();
	    	buffer.getBytes(array[i].rgbAtr);
		}

    	return array;
    }
}