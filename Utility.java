package com.hzwq.dx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * 
 * @author jlf
 *@desc 各基础类型与byte之间的转换
 */
public class Utility {
	
	 /** 
     * 将short[]转成byte[] 
     * @param a 
     * @return 
     */  
	public static byte[] toByteArray(short[] src) {

        int count = src.length;
        byte[] dest = new byte[count << 1];
        for (int i = 0; i < count; i++) {
                dest[i * 2] = (byte) (src[i] >> 8);
                dest[i * 2 + 1] = (byte) (src[i] >> 0);
        }

        return dest;
    }
	
	 /** 
     * 将short转成byte[2] 
     * @param a 
     * @return 
     */  
    public static byte[] short2Byte(short a){  
        byte[] b = new byte[2];  
          
        b[0] = (byte) (a >> 8);  
        b[1] = (byte) (a);  
          
        return b;  
    } 
    /** 
     * 将short转成byte[2] 小端排序
     * @param a 
     * @return 
     */  
    public static byte[] short2B(short a){  
    	byte[] b = new byte[2];  
    	
    	b[1] = (byte) (a >> 8);  
    	b[0] = (byte) (a);  
    	
    	return b;  
    } 
    /** 
     * 将short转成byte[2] |128 
     * @param a 
     * @return 
     */  
    public static byte[] shortTByte(short a){  
    	byte[] b = new byte[2];  
    	
    	b[0] = (byte) (128|a >> 8);  
    	b[1] = (byte) (a);  
    	
    	return b;  
    }  
      
    /** 
     * 将short转成byte[2] 
     * @param a 
     * @param b 
     * @param offset b中的偏移量 
     */  
    public static void short2Byte(short a, byte[] b, int offset){  
        b[offset] = (byte) (a >> 8);  
        b[offset+1] = (byte) (a);  
    }  
      
    /** 
     * 将byte[2]转换成short 
     * @param b 
     * @return 
     */  
    public static short byte2Short(byte[] b){  
        return (short) (((b[0] & 0xff) << 8) | (b[1] & 0xff));  
    }  
      
    /** 
     * 将byte[2]转换成short 
     * @param b 
     * @param offset 
     * @return  
     */  
    public static short byte2Short(byte[] b, int offset){  
        return (short) (((b[offset] & 0xff) << 8) | (b[offset+1] & 0xff));  
    }  
  
    /** 
     * long转byte[8] 
     *  
     * @param a 
     * @param b 
     * @param offset 
     *            b的偏移量 
     */  
    public static void long2Byte(long a, byte[] b, int offset) {          
        b[offset + 0] = (byte) (a >> 56);  
        b[offset + 1] = (byte) (a >> 48);  
        b[offset + 2] = (byte) (a >> 40);  
        b[offset + 3] = (byte) (a >> 32);  
  
        b[offset + 4] = (byte) (a >> 24);  
        b[offset + 5] = (byte) (a >> 16);  
        b[offset + 6] = (byte) (a >> 8);  
        b[offset + 7] = (byte) (a);  
    }  
  
    /** 
     * byte[8]转long 
     *  
     * @param b 
     * @param offset 
     *            b的偏移量 
     * @return 
     */  
    public static long byte2Long(byte[] b, int offset) {  
         return ((((long) b[offset + 0] & 0xff) << 56)  
         | (((long) b[offset + 1] & 0xff) << 48)  
         | (((long) b[offset + 2] & 0xff) << 40)  
         | (((long) b[offset + 3] & 0xff) << 32)  
           
         | (((long) b[offset + 4] & 0xff) << 24)  
         | (((long) b[offset + 5] & 0xff) << 16)  
         | (((long) b[offset + 6] & 0xff) << 8)  
         | (((long) b[offset + 7] & 0xff) << 0));  
    }  
  
    /** 
     * byte[8]转long 
     *  
     * @param b 
     * @return 
     */  
    public static long byte2Long(byte[] b) {  
         return  
         ((b[0]&0xff)<<56)|  
         ((b[1]&0xff)<<48)|  
         ((b[2]&0xff)<<40)|  
         ((b[3]&0xff)<<32)|  
          
         ((b[4]&0xff)<<24)|  
         ((b[5]&0xff)<<16)|  
         ((b[6]&0xff)<<8)|  
         (b[7]&0xff);  
    }  
  
    /** 
     * long转byte[8] 
     *  
     * @param a 
     * @return 
     */  
    public static byte[] long2Byte(long a) {  
        byte[] b = new byte[4 * 2];  
  
        b[0] = (byte) (a >> 56);  
        b[1] = (byte) (a >> 48);  
        b[2] = (byte) (a >> 40);  
        b[3] = (byte) (a >> 32);  
          
        b[4] = (byte) (a >> 24);  
        b[5] = (byte) (a >> 16);  
        b[6] = (byte) (a >> 8);  
        b[7] = (byte) (a >> 0);  
  
        return b;  
    }  
  
    /** 
     * byte数组转int 
     *  
     * @param b 
     * @return 
     */  
    public static int byte2Int(byte[] b) {  
        return ((b[0] & 0xff) << 24) | ((b[1] & 0xff) << 16)  
                | ((b[2] & 0xff) << 8) | (b[3] & 0xff);  
    }  
  
    /** 
     * byte数组转int 
     *  
     * @param b 
     * @param offset 
     * @return 
     */  
    public static int byte2Int(byte[] b, int offset) {  
        return ((b[offset++] & 0xff) << 24) | ((b[offset++] & 0xff) << 16)  
                | ((b[offset++] & 0xff) << 8) | (b[offset++] & 0xff);  
    }  
  
    /** 
     * int转byte数组 
     *  
     * @param a 
     * @return 
     */  
    public static byte[] int2Byte(int a) {  
        byte[] b = new byte[4];  
        b[0] = (byte) (a >> 24);  
        b[1] = (byte) (a >> 16);  
        b[2] = (byte) (a >> 8);  
        b[3] = (byte) (a);  
  
        return b;  
    } 
    
    /** 
     * int转byte数组 小端排序
     *  
     * @param a 
     * @return 
     */  
    public static byte[] int2B(int a) {  
    	byte[] b = new byte[4];  
    	b[3] = (byte) (a >> 24);  
    	b[2] = (byte) (a >> 16);  
    	b[1] = (byte) (a >> 8);  
    	b[0] = (byte) (a);  
    	
    	return b;  
    }  
  
    
    
    /** 
     * int转byte数组 
     *  
     * @param a 
     * @param b 
     * @param offset 
     * @return 
     */  
    public static void int2Byte(int a, byte[] b, int offset) {        
        b[offset++] = (byte) (a >> 24);  
        b[offset++] = (byte) (a >> 16);  
        b[offset++] = (byte) (a >> 8);  
        b[offset++] = (byte) (a);  
    }  
    /**
     * 合并数组
     * @param srcArrays
     * @return
     */
    public static byte[] sysCopy(List<byte[]> srcArrays) {
          int len = 0;
          for (byte[] srcArray:srcArrays) {
           len+= srcArray.length;
          }
             byte[] destArray = new byte[len];   
             int destLen = 0;
             for (byte[] srcArray:srcArrays) {
                 System.arraycopy(srcArray, 0, destArray, destLen, srcArray.length);   
                 destLen += srcArray.length;   
             }   
             return destArray;
         }
    /**
     * 数组转成十六进制字符串
     * @param byte[]
     * @return HexString
     */
    public static String toHexString1(byte[] b){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < b.length; ++i){
            buffer.append(toHexString1(b[i]));
        }
        return buffer.toString();
    }
    public static String toHexString1(byte b){
        String s = Integer.toHexString(b & 0xFF);
        if (s.length() == 1){
            return "0" + s;
        }else{
            return s;
        }
    }
    
    /**
     * 字节数组转成16进制表示格式的字符串: 0x01 0x02...
     *
     * @param byteArray 要转换的字节数组
     * @return 16进制表示格式的字符串
     **/
    public static String byteArrtoHexStringWithBlank(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1)
            throw new IllegalArgumentException("this byteArray must not be null or empty");

        final StringBuilder hexString = new StringBuilder(" ");
        for (int i = 0; i < byteArray.length; i++) {
        	hexString.append("0x");
            if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
                hexString.append("0");
            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
            hexString.append(" ");
        }
        return hexString.toString().toLowerCase();
    }
    
    /**
     *  利用java原生的摘要实现SHA256加密
     * @param str 加密后的报文
     * @return
     */
    public static byte[] getSHA256ByteJava(byte[] bytes){
        MessageDigest messageDigest;
        byte[] encodeBytes = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bytes);
            encodeBytes = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
           throw new RuntimeException(e.getMessage());
        } 
        return encodeBytes;
    }
    
} 

