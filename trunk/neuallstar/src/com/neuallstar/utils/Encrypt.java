/**
 *com.neuallstar.utils
 * Encrypt.java
 */
package com.neuallstar.utils;

/**
 * 加密
 * @author 陈秀能
 * 2011-7-10 下午03:24:55 
 */
public class Encrypt {
	/**
	 * 加密
	 * @return String 字符串
	 * @param encrypted 被加密字符串
	 * @param encrypting 加密字符串
	 * 算法：1.先取被加密字符串截前半截,得到哈希码并将其除以3转化为16进制数得到s1
	 *       2.取加密字符串截后半截,得到哈希码并将其除以7转化为16进制数得到s2
	 *       3.取被加密字符串截后半截,得到哈希码并将其乘以2转化为16进制数得到s3
	 *       4.取加密字符串截前半截,得到哈希码并将其乘以2转化为16进制数得到s4
	 *       5.取“neuallstar”,得到哈希码并转化为16进制数得到s5
	 *       6.取“by show”,得到哈希码并转化为16进制数得到s6
	 *       7.将s1,s2,s3,s4,s5,s6连成字符串并取前20位便得到加密后的字符串
	 * **/
	public static String encrypt(String encrypted,String encrypting){
        StringBuffer buffer=new StringBuffer();
        if(encrypted!=null&&encrypting!=null){	
        	buffer.append(Integer.toHexString(encrypted.substring(0, encrypted.length()/2).hashCode()/3)) 
        	.append(Integer.toHexString(encrypting.substring(encrypting.length()/2).hashCode()/7))
        	.append(Integer.toHexString(encrypted.substring(encrypted.length()/2).hashCode()*2))
        	.append(Integer.toHexString(encrypting.substring(0,encrypting.length()/2).hashCode()*2))
        	.append(Integer.toHexString("neuallstar".hashCode()))
        	.append(Integer.toHexString("by show".hashCode()));
        }
        return buffer.toString().substring(0, 20);
	}
}
