# Windows_PC_SC_Java_Library
This project offers WinSCard API in Java, which supports PC/SC reader in Windows platform

This java library is built on top of the WinSCard native library (Windows Smart Card SDK), which offers more capability and flexibility than standard javax.smartcardio package.

A detailed description of all WinSCard API functions is available in the MSDN Library Documentation (https://msdn.microsoft.com/en-us/library/aa374731(v=VS.85).aspx).

This library allows you to transmit and receive application protocol data units (APDUs) specified by ISO/IEC 7816-3 to a smart card in Java platform.

# Project directory structure
/dist/ contains the runtime deployment directory, run runjava.bat to run the test program. Note you may need to modify runjava.bat to specify the JRE7 in your environment

/vc_workspace/ contains the relevant VC++ 2010 projects

/eclipse_workspace/ contains the relevant Java projects

# Sample code
As the java library strictly follows WinSCard API functions, as long as you understand WinSCard API functions as defined in MSDN Library, it should be very straightforward to start.

```
public static void main(String[] args) {
  //establish card context
  int hContext = PCSCAPI.SCardEstablishContext();
  
  //retrieve list of available PC/SC readers
  String[] readers = PCSCAPI.SCardListReaders(hContext);
    
  SCARD_READERSTATE[] readerStates = new SCARD_READERSTATE[readers.length + 1];
  
  //this is to monitor the state of current available readers
  for(int i=0; i<readerStates.length - 1; i++) {
	readerStates[i] = new SCARD_READERSTATE();
	readerStates[i].szReader = readers[i];
	readerStates[i].dwCurrentState = PCSCAPI.SCARD_STATE_UNAWARE;
  }
  //this is to monitor any reader connected or disconnected
  readerStates[readerStates.length - 1] = new SCARD_READERSTATE();
  readerStates[readerStates.length - 1].szReader = "\\\\?PNP?\\NOTIFICATION";
  readerStates[readerStates.length - 1].dwCurrentState = PCSCAPI.SCARD_STATE_UNAWARE;
		
  while(true) {
	readerStates = PCSCAPI.SCardGetStatusChange(hContext, PCSCAPI.TIMEOUT_INFINITE, readerStates);	
	...
	//processing reader states
	...
	for(int i=0; i<readerStates.length; i++) {
		readerStates[i].dwCurrentState = readerStates[i].dwEventState;
	}
  }
  ...
  PCSCAPI.SCardReleaseContext(hContext);
}
```
