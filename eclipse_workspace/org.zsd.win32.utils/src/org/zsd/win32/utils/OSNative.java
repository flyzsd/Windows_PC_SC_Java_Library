package org.zsd.win32.utils;

public class OSNative {

	static {
		System.loadLibrary("org.zsd.win32.utils.dll");
	}
	
	/************************** OS Utility Functions ********************************/
	public final static native void PostQuitMessage(int nExitCode);
	
	/************************** sizeof Functions ********************************/	
	public final static native int char_sizeof();
	
	public final static native int wchar_t_sizeof();
	
	public final static native int short_sizeof();
	
	public final static native int int_sizeof();
	
	public final static native int long_sizeof();
	
	public final static native int handle_sizeof();	
	
	/************************** Memory Management Functions **************************/	
	public final static native int AllocateBuffer(int ulSize);
	
	public final static native int AllocateMore(int ulSize, int lpvOriginal);
	
	public final static native void FreeBuffer(int lpvOriginal);
	
	/**
	 * Set the byte array into C array specified by handle. 
	 * Note: The C array must be allocated with enough memory.
	 * @param handle specify the address of C array
	 * @param array the byte array
	 */
	public final static native void setByteArray(int handle, byte[] array);
	
	/**
	 * Get the null terminated byte array specified by handle
	 * <p>
	 * byte <---> jbyte <---> char <---> signed 8 bits
	 * @param handle specify the address of C array
	 * @return the byte array
	 */
	public final static native byte[] getByteArray(int handle);
	
	/**
	 * Get the byte array specified by handle with specified length
	 * @param handle specify the address of C array
	 * @param length the array length
	 * @return the byte array
	 */
	public final static native byte[] getByteArray(int handle, int length);
	
	/**
	 * Set the short array into C array specified by handle. 
	 * Note: The C array must be allocated with enough memory.
	 * @param handle specify the address of C array
	 * @param array the short array
	 */
	public final static native void setShortArray(int handle, short[] array);
	
	/**
	 * Get the null terminated short array specified by handle
	 * <p>
	 * short <---> jshort <---> short <---> signed 16 bits
	 * @param handle specify the address of C array
	 * @return the short array
	 */
	public final static native short[] getShortArray(int handle);
	
	/**
	 * Get the short array specified by handle with specified length
	 * <p>
	 * short <---> jshort <---> short <---> signed 16 bits
	 * @param handle specify the address of C array
	 * @param length the array length
	 * @return the short array
	 */
	public final static native short[] getShortArray(int handle, int length);
	
	/**
	 * Set the int array into C array specified by handle. 
	 * Note: The C array must be allocated with enough memory.
	 * @param handle specify the address of C array
	 * @param array the int array
	 */
	public final static native void setIntArray(int handle, int[] array);
	
	/**
	 * Get the null terminated integer array specified by handle
	 * <p>
	 * int <---> jint <---> int <---> signed 32 bits
	 * @param handle specify the address of C array
	 * @return the integer array
	 */
	public final static native int[] getIntArray(int handle);
	
	/**
	 * Get the integer array specified by handle with specified length
	 * <p>
	 * int <---> jint <---> int <---> signed 32 bits
	 * @param handle specify the address of C array
	 * @param length the array length
	 * @return the integer array
	 */
	public final static native int[] getIntArray(int handle, int length);
	
	/**
	 * Set the long array into C array specified by handle. 
	 * Note: The C array must be allocated with enough memory.
	 * @param handle specify the address of C array
	 * @param array the long array
	 */
	public final static native void setLongArray(int handle, long[] array);
	
	/**
	 * Get the null terminated long array specified by handle
	 * <p>
	 * long <---> jlong <---> __sign64 <---> signed 64 bits
	 * @param handle specify the address of C array
	 * @return the long array
	 */
	public final static native long[] getLongArray(int handle);
	
	/**
	 * Get the long array specified by handle with specified length
	 * <p>
	 * long <---> jlong <---> __sign64 <---> signed 64 bits
	 * @param handle specify the address of C array
	 * @param length the array length
	 * @return the long array
	 */
	public final static native long[] getLongArray(int handle, int length);
	
	/**
	 * Get the double null terminated byte array specified by the handle
	 * @param handle specify the address of C array
	 * @return the byte array which excludes the terminating double null
	 */
	public final static native byte[] getDoubleNullTerminatedByteArray(int handle);
	
	public final static native String getNullTerminatedCString(int handle);
	
	//null terminated C wide string
	public final static native String getNullTerminatedCWideString(int handle);
	
	public final static native String[] getDoubleNullTerminatedCString(int handle);
	
	public final static native String[] getDoubleNullTerminatedCWideString(int handle);
	
	public final static native String getCWideString(int handle, int length);
	
	public final static native void setCString(int handle, String string);
	
	public final static native void setCWideString(int handle, String string);
}