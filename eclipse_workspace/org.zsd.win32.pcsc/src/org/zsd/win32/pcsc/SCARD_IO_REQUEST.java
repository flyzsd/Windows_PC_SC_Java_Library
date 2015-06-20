package org.zsd.win32.pcsc;

import org.zsd.win32.pcsc.WriteBuffer.XfsWriteBuffer;
import org.zsd.win32.utils.OS;

public class SCARD_IO_REQUEST {
    private final static int sizeof = PCSC.SCARD_IO_REQUEST_sizeof();
    
	public final static SCARD_IO_REQUEST SCARD_PCI_T0 = new SCARD_IO_REQUEST(0x00000001, 0x00000008);
	public final static SCARD_IO_REQUEST SCARD_PCI_T1 = new SCARD_IO_REQUEST(0x00000002, 0x00000008);
	public final static SCARD_IO_REQUEST SCARD_PCI_RAW = new SCARD_IO_REQUEST(0x00010000, 0x00000008);

    
    public SCARD_IO_REQUEST(int dwProtocol, int cbPciLength){
    	this.dwProtocol = dwProtocol;
    	this.cbPciLength = cbPciLength;
    }
    
	private final int dwProtocol;
	private final int cbPciLength;
	
	public static int toStruct(SCARD_IO_REQUEST struct, XfsWriteBuffer parent) {
    	if(struct == null)
    		return 0;
    	
		WriteBuffer buffer = (parent == null) ? (parent = XfsWriteBuffer.allocate(sizeof)) : parent.allocateMore(sizeof);
		
		buffer.putInt(struct.dwProtocol);
		buffer.putInt(struct.cbPciLength);
    	return buffer.flush();
    }
	
    public static SCARD_IO_REQUEST fromStruct(int handle) {
    	if(handle == 0)
    		return null;
    	
		ReadBuffer buffer = new ReadBuffer(OS.getByteArray(handle, sizeof));
		SCARD_IO_REQUEST struct = new SCARD_IO_REQUEST(buffer.getInt(), buffer.getInt());
    	return struct;
    }
}