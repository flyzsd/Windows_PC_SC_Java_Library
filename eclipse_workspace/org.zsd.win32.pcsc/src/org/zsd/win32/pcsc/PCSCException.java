package org.zsd.win32.pcsc;

public class PCSCException extends Exception {
	private static final long serialVersionUID = 1L;
	private final int errorCode;
	
	public PCSCException(int errorCode) {
		super("ErrorCode = 0x" + String.format("%08X", errorCode));
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return this.errorCode;
	}
}
