/**
 *com.zokala.framwork.ioc.test
 * Test.java
 */
package com.zokala.framework.ioc.test;

import com.zokala.framework.ioc.util.Context;

/**
 * @author ³ÂÐãÄÜ
 * 2011-8-5 ÏÂÎç09:11:21 
 */
public class Test {

	/**
	 *@param args
	 *return void
	 */
	public static void main(String[] args) {
		Context ctx=new Context();
		IHello hello=(IHello) ctx.get("hello");
		System.out.println(hello.sayHello());
	}

}
