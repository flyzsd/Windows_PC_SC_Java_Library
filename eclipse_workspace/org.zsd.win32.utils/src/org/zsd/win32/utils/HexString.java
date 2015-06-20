package org.zsd.win32.utils;

/** 
 * Small utility class to hexify bytes and shorts.
 */
public class HexString {
	private static final char[] DIGITS_UPPER = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	/**
	 * Converts an array of bytes into a String representing the hexadecimal values of each byte in order. The returned
	 * String will be double the length of the passed array, as it takes two characters to represent any given byte.
	 * @param bytes a byte[] to convert to Hex characters
	 * @return A String containing hexadecimal characters
	 */
	public static String hexify(byte[] bytes){
		if(bytes == null) return "null";
		
		char[] out = new char[bytes.length * 2];
		// two characters form the hex value.
		for (int i = 0, j = 0; i < bytes.length; i++) {
			out[j++] = DIGITS_UPPER[(0xF0 & bytes[i]) >>> 4];
			out[j++] = DIGITS_UPPER[0x0F & bytes[i]];
		}
		return new String(out);
	}
	
	/**
	 * Hexify a byte value.
	 * @param b byte value
	 * @return
	 */
	public static String hexify(int b) {
		return hexify(new byte[]{(byte)b});
	}
	
	/**
	 * Parse Hex string into a byte array.
	 * @param byteString
	 * @return
	 */
	public static byte[] parseHexString(String hexString) {
		if((hexString.length() % 2) != 0)
			throw new IllegalArgumentException("Odd number of characters.");
		
		byte[] out = new byte[hexString.length()/2];
        for(int i=0; i<out.length; i++) {
        	out[i] = (byte)Integer.parseInt(hexString.substring(i*2, (i+1)*2), 16);
        }
		return out;
	}
	
	/** Hex-dump a byte array (offset and printable ASCII included)<p>
     *
     * @param data  Byte array to convert to HexString
     *
     * @return HexString
     */
	public static String dump(byte[] data) {
		if(data == null) return "null";
	  
		return dump(data,0,data.length);
	}
	
    /** Hex-dump a byte array (offset and printable ASCII included)<p>
     *
     * @param data  Byte array to convert to HexString
     * @param offset Start dump here
     * @param len Number of bytes to be dumped.
     * @return HexString
     */
	public static String dump(byte[] data, int offset, int len) {
		if(data == null) return "null";

	    char[] ascii = new char[16];

	    StringBuilder out = new StringBuilder();

        for(int i=offset; i<offset+len; ) {
          // offset
          out.append(hexify((i>>>8) & 0xff));
          out.append(hexify(i & 0xff));
          out.append(":  ");

          // hexbytes
          for(int j=0; j<16; j++, i++) {
	        if(i<data.length) {
	          int b = data[i] & 0xff;
	          out.append(hexify(b)).append(' ');
	          ascii[j] = (b>=32 && b<127) ? (char)b : '.';
	        }
	        else {
	          out.append("   ");
	          ascii[j] = ' ';
	        }
          }

          // ASCII
          out.append(' ').append(ascii).append("\n");
        }

        return out.toString();
	}
}