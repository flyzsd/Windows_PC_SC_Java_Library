package org.zsd.win32.pcsc;

/**
 * DWORD - int
 * LONG - int
 * LPCVOID - int for 32 bits, long for 64 bits
 * 
 * 
 * @author shudong
 *
 */
class PCSC {

	static {
		System.loadLibrary("org.zsd.win32.pcsc.dll");
	}
	
	public static native int SCARD_READERSTATE_sizeof();
	
	public static native int SCARD_IO_REQUEST_sizeof();
    /**
     * This must be the first WinSCard function called in a PC/SC application. Each thread of an application shall use its own SCARDCONTEXT.
     */
	public static native int SCardEstablishContext(int dwScope, int pvReserved1, int pvReserved2, int phContext);

	public static native int SCardReleaseContext(int hContext);
	
	public static native int SCardIsValidContext(int hContext);
	
	public static native int SCardListReaders(int hContext, int mszGroups, int mszReaders, int pcchReaders);
	
	public static native int SCardFreeMemory(int hContext, int pvMem);
	
	public static native int SCardGetStatusChange(int hContext, int dwTimeout, int rgReaderStates, int cReaders);
	
	public static native int SCardCancel(int hContext);
	
	public static native int SCardConnect(int hContext, int szReader, int dwShareMode, int dwPreferredProtocols, int phCard, int pdwActiveProtocol);
	
	public static native int SCardDisconnect(int hCard, int dwDisposition);
	
	public static native int SCardReconnect(int hCard, int dwShareMode, int dwPreferredProtocols, int dwInitialization, int pdwActiveProtocol);
	
	public static native int SCardBeginTransaction(int hCard);
	
	public static native int SCardEndTransaction(int hCard, int dwDisposition);
	
	public static native int SCardGetAttrib(int hCard, int dwAttrId, int pbAttr, int pcbAttrLen);
	
	public static native int SCardStatus(int hCard, int szReaderName, int pcchReaderLen, int pdwState, int pdwProtocol, int pbAtr, int pcbAtrLen);
	
	public static native int SCardTransmit(int hCard, int pioSendPci, int pbSendBuffer, int cbSendLength, int pioRecvPci, int pbRecvBuffer, int pcbRecvLength);
}