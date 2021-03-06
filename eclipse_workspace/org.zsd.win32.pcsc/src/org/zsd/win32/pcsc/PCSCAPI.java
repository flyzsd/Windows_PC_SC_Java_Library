package org.zsd.win32.pcsc;

import org.zsd.win32.utils.OS;

public class PCSCAPI {	
    // PCSC success/error/failure/warning codes
	public final static int SCARD_S_SUCCESS             = 0x00000000;
	public final static int SCARD_E_CANCELLED           = 0x80100002;
	public final static int SCARD_E_CANT_DISPOSE        = 0x8010000E;
	public final static int SCARD_E_INSUFFICIENT_BUFFER = 0x80100008;
	public final static int SCARD_E_INVALID_ATR         = 0x80100015;
	public final static int SCARD_E_INVALID_HANDLE      = 0x80100003;
	public final static int SCARD_E_INVALID_PARAMETER   = 0x80100004;
	public final static int SCARD_E_INVALID_TARGET      = 0x80100005;
	public final static int SCARD_E_INVALID_VALUE       = 0x80100011;
	public final static int SCARD_E_NO_MEMORY           = 0x80100006;
    final static int SCARD_F_COMM_ERROR          = 0x80100013;
    final static int SCARD_F_INTERNAL_ERROR      = 0x80100001;
    final static int SCARD_F_UNKNOWN_ERROR       = 0x80100014;
    final static int SCARD_F_WAITED_TOO_LONG     = 0x80100007;
    final static int SCARD_E_UNKNOWN_READER      = 0x80100009;
    final static int SCARD_E_TIMEOUT             = 0x8010000A;
    final static int SCARD_E_SHARING_VIOLATION   = 0x8010000B;
    final static int SCARD_E_NO_SMARTCARD        = 0x8010000C;
    final static int SCARD_E_UNKNOWN_CARD        = 0x8010000D;
    final static int SCARD_E_PROTO_MISMATCH      = 0x8010000F;
    final static int SCARD_E_NOT_READY           = 0x80100010;
    final static int SCARD_E_SYSTEM_CANCELLED    = 0x80100012;
    final static int SCARD_E_NOT_TRANSACTED      = 0x80100016;
    final static int SCARD_E_READER_UNAVAILABLE  = 0x80100017;

    final static int SCARD_W_UNSUPPORTED_CARD    = 0x80100065;
    final static int SCARD_W_UNRESPONSIVE_CARD   = 0x80100066;
    final static int SCARD_W_UNPOWERED_CARD      = 0x80100067;
    final static int SCARD_W_RESET_CARD          = 0x80100068;
    final static int SCARD_W_REMOVED_CARD        = 0x80100069;
    final static int SCARD_W_INSERTED_CARD       = 0x8010006A;

    final static int SCARD_E_UNSUPPORTED_FEATURE = 0x8010001F;
    final static int SCARD_E_PCI_TOO_SMALL       = 0x80100019;
    final static int SCARD_E_READER_UNSUPPORTED  = 0x8010001A;
    final static int SCARD_E_DUPLICATE_READER    = 0x8010001B;
    final static int SCARD_E_CARD_UNSUPPORTED    = 0x8010001C;
    final static int SCARD_E_NO_SERVICE          = 0x8010001D;
    final static int SCARD_E_SERVICE_STOPPED     = 0x8010001E;

    // MS undocumented
    final static int SCARD_E_NO_READERS_AVAILABLE = 0x8010002E;
    // std. Windows invalid handle return code, used instead of SCARD code
    final static int WINDOWS_ERROR_INVALID_HANDLE = 6;
    final static int WINDOWS_ERROR_INVALID_PARAMETER = 87;

    public final static int SCARD_AUTOALLOCATE    = 0xffffffff;
    
    // The context is a user context, and any database operations are performed within the domain of the user.
    public final static int SCARD_SCOPE_USER      = 0;  
    // The context is that of the current terminal, and any database operations are performed within the domain of that terminal.  
    // (The calling application must have appropriate access permissions for any database actions.)
    public final static int SCARD_SCOPE_TERMINAL  = 1;  
    // The context is the system context, and any database operations are performed within the domain of the system. 
    // (The calling application must have appropriate access permissions for any database actions.)
    public final static int SCARD_SCOPE_SYSTEM    = 2; 

    public final static int SCARD_SHARE_EXCLUSIVE =  0x0001;
    public final static int SCARD_SHARE_SHARED    =  0x0002;
    public final static int SCARD_SHARE_DIRECT    =  0x0003;

    public final static int SCARD_LEAVE_CARD      =  0x0000;
    public final static int SCARD_RESET_CARD      =  0x0001;
    public final static int SCARD_UNPOWER_CARD    =  0x0002;
    public final static int SCARD_EJECT_CARD      =  0x0003;

    public final static int SCARD_STATE_UNAWARE     = 0x0000;
    public final static int SCARD_STATE_IGNORE      = 0x0001;
    public final static int SCARD_STATE_CHANGED     = 0x0002;
    public final static int SCARD_STATE_UNKNOWN     = 0x0004;
    public final static int SCARD_STATE_UNAVAILABLE = 0x0008;
    public final static int SCARD_STATE_EMPTY       = 0x0010;
    public final static int SCARD_STATE_PRESENT     = 0x0020;
    public final static int SCARD_STATE_ATRMATCH    = 0x0040;
    public final static int SCARD_STATE_EXCLUSIVE   = 0x0080;
    public final static int SCARD_STATE_INUSE       = 0x0100;
    public final static int SCARD_STATE_MUTE        = 0x0200;
    public final static int SCARD_STATE_UNPOWERED   = 0x0400;

    public final static int TIMEOUT_INFINITE = 0xffffffff;
	
    public final static int SCARD_PROTOCOL_UNDEFINED    = 0x00000000;  // There is no active protocol.
    public final static int SCARD_PROTOCOL_T0           = 0x00000001;  // T=0 is the active protocol.
    public final static int SCARD_PROTOCOL_T1           = 0x00000002;  // T=1 is the active protocol.
    public final static int SCARD_PROTOCOL_RAW          = 0x00010000;  // Raw is the active protocol.
    
	public static final int SCARD_ATTR_VENDOR_NAME 					= 0x00010100;
	public static final int SCARD_ATTR_VENDOR_IFD_TYPE 				= 0x00010101;
	public static final int SCARD_ATTR_VENDOR_IFD_VERSION 			= 0x00010102;
	public static final int SCARD_ATTR_VENDOR_IFD_SERIAL_NO 		= 0x00010103;

	public static final int SCARD_ATTR_ATR_STRING					= 0x00090303;
	
	public static final int SCARD_ATTR_DEVICE_FRIENDLY_NAME			= 0x7fff0005;
	public static final int SCARD_ATTR_DEVICE_SYSTEM_NAME			= 0x7fff0006;
	
	public static int SCardEstablishContext() throws PCSCException {
		int phContext = OS.AllocateBuffer(OS.handle_sizeof());		
		
		try {
			int rc = PCSC.SCardEstablishContext(SCARD_SCOPE_USER, 0, 0, phContext);
			if(rc != SCARD_S_SUCCESS) {
				throw new PCSCException(rc);
			}
			int[] array = OS.getIntArray(phContext, 1);
			return array[0];
		}
		finally {
			OS.FreeBuffer(phContext);
		}
	}
	
	public static void SCardReleaseContext(int hContext) throws PCSCException {
		int rc = PCSC.SCardReleaseContext(hContext);
		if(rc != SCARD_S_SUCCESS) {
			throw new PCSCException(rc);
		}
	}
	
	public static String[] SCardListReaders(int hContext) throws PCSCException {
		int pcchReaders = OS.AllocateBuffer(OS.handle_sizeof());
		OS.setIntArray(pcchReaders, new int[]{SCARD_AUTOALLOCATE});		
		int ppmszReaders = OS.AllocateBuffer(OS.handle_sizeof());
		
		try {
			int rc = PCSC.SCardListReaders(hContext, 0, ppmszReaders, pcchReaders);			
			if(rc != SCARD_S_SUCCESS) {
				throw new PCSCException(rc);
			}
			
			int pmszReaders = OS.getIntArray(ppmszReaders, 1)[0];		
			String[] readers = OS.getDoubleNullTerminatedCWideString(pmszReaders);		
			PCSC.SCardFreeMemory(hContext, pmszReaders);
			return readers;
		} finally {
			OS.FreeBuffer(pcchReaders);
			OS.FreeBuffer(ppmszReaders);
		}
	}
	
	public static SCARD_READERSTATE[] SCardGetStatusChange(int hContext, int dwTimeout, SCARD_READERSTATE[] readerStates) throws PCSCException {
		int rgReaderStates = SCARD_READERSTATE.toStruct(readerStates, null);
		
		try {
			int rc = PCSC.SCardGetStatusChange(hContext, dwTimeout, rgReaderStates, readerStates.length);
			if(rc != SCARD_S_SUCCESS) {
				throw new PCSCException(rc);
			}
			
			return SCARD_READERSTATE.fromStruct(rgReaderStates, readerStates.length);			
		}
		finally {
			OS.FreeBuffer(rgReaderStates);
		}
	}
	
	public static void SCardCancel(int hContext) throws PCSCException {
		int rc =  PCSC.SCardCancel(hContext);
		if(rc != SCARD_S_SUCCESS) {
			throw new PCSCException(rc);
		}
	}
	
	public static int SCardConnect(int hContext, String szReader, int dwShareMode, int dwPreferredProtocols, int[] dwActiveProtocol) throws PCSCException {
		int phCard = OS.AllocateBuffer(OS.handle_sizeof());
		int pdwActiveProtocol  = OS.AllocateBuffer(OS.int_sizeof());
    	int sizeof = (szReader.length() + 1) * OS.wchar_t_sizeof();
    	int pszReader = OS.AllocateBuffer(sizeof);
    	OS.setCWideString(pszReader, szReader);
    	
    	try {
    		int rc = PCSC.SCardConnect(hContext, pszReader, dwShareMode, dwPreferredProtocols, phCard, pdwActiveProtocol);
    		if(rc != SCARD_S_SUCCESS) {
    			throw new PCSCException(rc);
    		}
    		
			if(dwActiveProtocol != null && dwActiveProtocol.length >= 1) {
				dwActiveProtocol[0] = OS.getIntArray(pdwActiveProtocol, 1)[0];
			}
			
			return OS.getIntArray(phCard, 1)[0];
    	}
    	finally {
			OS.FreeBuffer(phCard);
			OS.FreeBuffer(pdwActiveProtocol);
			OS.FreeBuffer(pszReader);
    	}
	}
	
	public static void SCardDisconnect(int hCard, int dwDisposition) throws PCSCException {
		int rc = PCSC.SCardDisconnect(hCard, dwDisposition);
		if(rc != SCARD_S_SUCCESS) {
			throw new PCSCException(rc);
		}
	}
	
	public static byte[] SCardGetAttrib(int hContext, int hCard, int dwAttrId) {
		int ppbAttr = OS.AllocateBuffer(OS.handle_sizeof());		
		int pcbAttrLen = OS.AllocateBuffer(OS.int_sizeof());
		OS.setIntArray(pcbAttrLen, new int[]{SCARD_AUTOALLOCATE});
		
		try {
			int rc = PCSC.SCardGetAttrib(hCard, dwAttrId, ppbAttr, pcbAttrLen);
			if(rc != SCARD_S_SUCCESS) {
				return null;
			}
			
			int pbAttr = OS.getIntArray(ppbAttr, 1)[0];
			int cbAttrLen = OS.getIntArray(pcbAttrLen, 1)[0];
			byte[] bytes = OS.getByteArray(pbAttr, cbAttrLen);
			PCSC.SCardFreeMemory(hContext, pbAttr);
			return bytes;
		}
		finally {
			OS.FreeBuffer(ppbAttr);
			OS.FreeBuffer(pcbAttrLen);
		}
	}
	
	public static byte[] SCardStatus(int hContext, int hCard, String[] readerName, int[] dwState, int[] dwProtocol) throws PCSCException {
		int ppszReaderName = OS.AllocateBuffer(OS.handle_sizeof());
		int pcchReaderLen = OS.AllocateBuffer(OS.int_sizeof());
		OS.setIntArray(pcchReaderLen, new int[]{SCARD_AUTOALLOCATE});
		int pdwState = OS.AllocateBuffer(OS.int_sizeof());
		int pdwProtocol = OS.AllocateBuffer(OS.int_sizeof());
		int ppbAtr = OS.AllocateBuffer(OS.handle_sizeof());
		int pcbAtrLen = OS.AllocateBuffer(OS.int_sizeof());
		OS.setIntArray(pcbAtrLen, new int[]{SCARD_AUTOALLOCATE});
		
		try {		
			int rc = PCSC.SCardStatus(hCard, ppszReaderName, pcchReaderLen, pdwState, pdwProtocol, ppbAtr, pcbAtrLen);
			if(rc != SCARD_S_SUCCESS) {
				throw new PCSCException(rc);
			}
			
			int pszReaderName = OS.getIntArray(ppszReaderName, 1)[0];
			int cchReaderLen = OS.getIntArray(pcchReaderLen, 1)[0];
			if(readerName != null && readerName.length >= 1) {
				readerName[0] = OS.getCWideString(pszReaderName, cchReaderLen);
			}
			PCSC.SCardFreeMemory(hContext, pszReaderName);
			
			if(dwState != null && dwState.length >= 1) {
				dwState[0] = OS.getIntArray(pdwState, 1)[0];
			}
			
			if(dwProtocol != null && dwProtocol.length >= 1) {
				dwProtocol[0] = OS.getIntArray(pdwProtocol, 1)[0];
			}
			
			int pbAtr = OS.getIntArray(ppbAtr, 1)[0];
			int cbAtrLen = OS.getIntArray(pcbAtrLen, 1)[0];
			byte[] atr = OS.getByteArray(pbAtr, cbAtrLen);
			PCSC.SCardFreeMemory(hContext, pbAtr);
			return atr;
		}
		finally {
			OS.FreeBuffer(ppszReaderName);
			OS.FreeBuffer(pcchReaderLen);
			OS.FreeBuffer(pdwState);
			OS.FreeBuffer(pdwProtocol);
			OS.FreeBuffer(ppbAtr);
			OS.FreeBuffer(pcbAtrLen);
		}
	}
	
	public static byte[] SCardTransmit(int hContext, int hCard, int dwProtocol, byte[] command) throws PCSCException {
		int pioSendPci = SCARD_IO_REQUEST.toStruct(dwProtocol== PCSCAPI.SCARD_PROTOCOL_T0 ? SCARD_IO_REQUEST.SCARD_PCI_T0 : SCARD_IO_REQUEST.SCARD_PCI_T1, null);
		int pbSendBuffer = OS.AllocateBuffer(command.length);
		OS.setByteArray(pbSendBuffer, command);
		int ppbRecvBuffer = OS.AllocateBuffer(OS.handle_sizeof());
		int pcbRecvLength = OS.AllocateBuffer(OS.int_sizeof());
		OS.setIntArray(pcbRecvLength, new int[]{SCARD_AUTOALLOCATE});
		
		try {
			int rc = PCSC.SCardTransmit(hCard, pioSendPci, pbSendBuffer, command.length, 0, ppbRecvBuffer, pcbRecvLength);
			if(rc != SCARD_S_SUCCESS) {
				throw new PCSCException(rc);
			}
			
			int pbRecvBuffer = OS.getIntArray(ppbRecvBuffer, 1)[0];
			int cbRecvLength = OS.getIntArray(pcbRecvLength, 1)[0];
			byte[] response = OS.getByteArray(pbRecvBuffer, cbRecvLength);
			PCSC.SCardFreeMemory(hContext, pbRecvBuffer);
			return response;
		}
		finally {
			OS.FreeBuffer(pioSendPci);
			OS.FreeBuffer(pbSendBuffer);
			OS.FreeBuffer(ppbRecvBuffer);
			OS.FreeBuffer(pcbRecvLength);
		}
	}
}