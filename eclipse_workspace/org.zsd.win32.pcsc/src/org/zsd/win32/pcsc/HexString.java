package org.zsd.win32.pcsc;

/** Small utility class to hexify bytes and shorts.
  *
  * @author   Michael Baentsch (mib@zurich.ibm.com)
  * @author   Dirk Husemann (hud@zurich.ibm.com)
  *
  * @version  $Id: HexString.java,v 1.2 2009/04/30 03:29:39 shudong Exp $
  */
public class HexString {

  /** Auxillary string array. */
  protected final static String[] hexChars = {"0", "1", "2", "3", "4", "5", "6", "7",
                                              "8", "9", "A", "B", "C", "D", "E", "F"};

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
  public static String dump(byte[] data,int offset, int len) {
        if(data == null) return "null";

        char[] ascii = new char[16];

        StringBuffer out = new StringBuffer(256);

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


  /** Hexify a byte array.
    *
    * @param data  Byte array to convert to HexString
    *
    * @return HexString
    */
  public static String hexify(byte[] data) {
        if(data == null) return "null";

        StringBuffer out = new StringBuffer(256);
        for(int i=0; i<data.length; i++) {
          out.append(hexChars[(data[i]>>4) & 0x0f]);
          out.append(hexChars[data[i] & 0x0f]);
        }

        return out.toString();
  }
  
  /**
   * Hexify the specified subarray of bytes.
   * @param data the bytes to be hexfied
   * @param offset the index of first bytes
   * @param length the number of bytes
   * @return HexString
   */
  public static String hexify(byte[] data, int offset, int length) {
	  if(data == null) return "null";
	  
      StringBuffer out = new StringBuffer(256);
      for(int i=0; i<length; i++) {
        out.append(hexChars[(data[offset + i]>>4) & 0x0f]);
        out.append(hexChars[data[offset + i] & 0x0f]);
      }

      return out.toString();
  }

  /** Hexify a byte value.<p>
    *
    * @param val
    *        Byte value to be displayed as a HexString.
    *
    * @return HexString
    */
  public static String hexify(int val) {
        return hexChars[((val & 0xff) & 0xf0)>>>4] + hexChars[val & 0x0f];
  }


  /** Hexify short value encoded in two bytes.<p>
    *
    * @param a
    *        High byte of short value to be hexified
    * @param b
    *        Low byte of short value to be hexified
    *
    * @return HexString
    */
  public static String hexifyShort(byte a, byte b) {
        return hexifyShort(a & 0xff, b & 0xff);
  }


  /** Hexify a short value.<p>
    *
    * @param val
    *        Short value to be displayed as a HexString.
    *
    * @return HexString
    */
  public static String hexifyShort(int val) {
        return hexChars[((val & 0xffff) & 0xf000)>>>12] +
          hexChars[((val & 0xfff) & 0xf00)>>>8] +
          hexChars[((val & 0xff) & 0xf0)>>>4] + hexChars[val & 0x0f];
  }


  /** Hexify short value encoded in two (int-encoded)bytes.<p>
    *
    * @param a
    *        High byte of short value to be hexified
    * @param b
    *        Low byte of short value to be hexified
    *
    * @return HexString
    */
  public static String hexifyShort(int a, int b) {
        return hexifyShort(((a & 0xff)<<8) + (b & 0xff));
  }


  /** Parse bytes encoded as Hexadecimals into a byte array.<p>
    *
    * @param byteString
    *        String containing HexBytes.
    *
    * @return byte array containing the parsed values of the given string.
    */
  public static byte[] parseHexString(String byteString) {
        byte[] result = new byte[byteString.length()/2];
        for (int i=0; i<byteString.length(); i+=2) {
          String toParse = byteString.substring(i, i+2);
          result[i/2] = (byte)Integer.parseInt(toParse, 16);
        }
        return result;
  }


  /** Parse string of Hexadecimals into a byte array suitable for
    * unsigned BigInteger computations. Reverse the order of the
    * parsed data on the fly (input data little endian).<p>
    *
    * @param byteString
    *        String containing HexBytes.
    *
    * @return byte array containing the parsed values of the given string.
    */
  public static byte[] parseLittleEndianHexString(String byteString) {
        byte[] result = new byte[byteString.length()/2+1];
        for (int i=0; i<byteString.length(); i+=2) {
          String toParse = byteString.substring(i, i+2);
          result[(byteString.length()-i)/2] =
        (byte)Integer.parseInt(toParse, 16);
        }
        result[0] = (byte)0; // just to make it a positive value
        return result;
  }
}
