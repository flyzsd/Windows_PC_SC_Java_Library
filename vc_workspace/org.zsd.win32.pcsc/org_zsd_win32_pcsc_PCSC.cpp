#include "stdafx.h"
#include "org_zsd_win32_pcsc_PCSC.h"

#define PCSC(func) Java_org_zsd_win32_pcsc_PCSC_##func

JNIEXPORT jint JNICALL PCSC(SCARD_1READERSTATE_1sizeof) (JNIEnv *env, jclass cls) {
	return sizeof(SCARD_READERSTATE);
}

JNIEXPORT jint JNICALL PCSC(SCARD_1IO_1REQUEST_1sizeof) (JNIEnv *env, jclass cls) {
	return sizeof(SCARD_IO_REQUEST);
}

JNIEXPORT jint JNICALL PCSC(SCardEstablishContext) (JNIEnv *env, jclass cls, jint dwScope, jint pvReserved1, jint pvReserved2, jint phContext) {
	return SCardEstablishContext(dwScope, (LPCVOID)pvReserved1, (LPCVOID)pvReserved2, (LPSCARDCONTEXT)phContext);
}

JNIEXPORT jint JNICALL PCSC(SCardReleaseContext) (JNIEnv *env, jclass cls, jint hContext) {
	return SCardReleaseContext(hContext);
}

JNIEXPORT jint JNICALL PCSC(SCardIsValidContext) (JNIEnv *env, jclass cls, jint hContext) {
	return SCardIsValidContext(hContext);
}

JNIEXPORT jint JNICALL PCSC(SCardListReaders) (JNIEnv *env, jclass cls, jint hContext, jint mszGroups, jint mszReaders, jint pcchReaders) {
	return SCardListReaders(hContext, (LPCTSTR)mszGroups, (LPTSTR)mszReaders, (LPDWORD)pcchReaders);
}

JNIEXPORT jint JNICALL PCSC(SCardFreeMemory) (JNIEnv *env, jclass cls, jint hContext, jint pvMem) {
	return SCardFreeMemory(hContext, (LPCVOID)pvMem);
}

JNIEXPORT jint JNICALL PCSC(SCardGetStatusChange) (JNIEnv *env, jclass cls, jint hContext, jint dwTimeout, jint rgReaderStates, jint cReaders) {
	return SCardGetStatusChange(hContext, dwTimeout, (LPSCARD_READERSTATE)rgReaderStates, cReaders);
}

JNIEXPORT jint JNICALL PCSC(SCardCancel) (JNIEnv *env, jclass cls, jint hContext) {
	return SCardCancel(hContext);
}

JNIEXPORT jint JNICALL PCSC(SCardConnect) (JNIEnv *env, jclass cls, jint hContext, jint szReader, jint dwShareMode, jint dwPreferredProtocols, jint phCard, jint pdwActiveProtocol) {
	return SCardConnect(hContext, (LPCTSTR)szReader, dwShareMode, dwPreferredProtocols, (LPSCARDHANDLE)phCard, (LPDWORD)pdwActiveProtocol);
}

JNIEXPORT jint JNICALL PCSC(SCardDisconnect) (JNIEnv *env, jclass cls, jint hCard, jint dwDisposition) {
	return SCardDisconnect(hCard, dwDisposition);
}

JNIEXPORT jint JNICALL PCSC(SCardReconnect) (JNIEnv *env, jclass cls, jint hCard, jint dwShareMode, jint dwPreferredProtocols, jint dwInitialization, jint pdwActiveProtocol) {
	return SCardReconnect(hCard, dwShareMode, dwPreferredProtocols, dwInitialization, (LPDWORD)pdwActiveProtocol);
}

JNIEXPORT jint JNICALL PCSC(SCardBeginTransaction) (JNIEnv *env, jclass cls, jint hCard) {
	return SCardBeginTransaction(hCard);
}

JNIEXPORT jint JNICALL PCSC(SCardEndTransaction) (JNIEnv *env, jclass cls, jint hCard, jint dwDisposition) {
	return SCardEndTransaction(hCard, dwDisposition);
}

JNIEXPORT jint JNICALL PCSC(SCardGetAttrib) (JNIEnv *env, jclass cls, jint hCard, jint dwAttrId, jint pbAttr, jint pcbAttrLen) {
	return SCardGetAttrib(hCard, dwAttrId, (LPBYTE)pbAttr, (LPDWORD)pcbAttrLen);
}

JNIEXPORT jint JNICALL PCSC(SCardStatus) (JNIEnv *env, jclass cls, jint hCard, jint szReaderName, jint pcchReaderLen, jint pdwState, jint pdwProtocol, jint pbAtr, jint pcbAtrLen) {
	return SCardStatus(hCard, (LPTSTR)szReaderName, (LPDWORD)pcchReaderLen, (LPDWORD)pdwState, (LPDWORD)pdwProtocol, (LPBYTE)pbAtr, (LPDWORD)pcbAtrLen);
}

JNIEXPORT jint JNICALL PCSC(SCardTransmit) (JNIEnv *env, jclass cls, jint hCard, jint pioSendPci, jint pbSendBuffer, jint cbSendLength, jint pioRecvPci, jint pbRecvBuffer, jint pcbRecvLength) {
	return SCardTransmit(hCard, (LPSCARD_IO_REQUEST)pioSendPci, (LPCBYTE)pbSendBuffer, cbSendLength, (LPSCARD_IO_REQUEST)pioRecvPci, (LPBYTE)pbRecvBuffer, (LPDWORD)pcbRecvLength);
}