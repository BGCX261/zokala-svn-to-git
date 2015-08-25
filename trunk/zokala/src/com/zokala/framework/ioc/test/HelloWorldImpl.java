/**
 *com.zokala.framwork.ioc.test
 * IHelloWorldImpl.java
 */
package com.zokala.framework.ioc.test;

/**
 * @author ³ÂÐãÄÜ
 * 2011-8-5 ÏÂÎç09:13:47 
 */
public class HelloWorldImpl implements IHelloWorld{
 
	/* 
	 * @see com.zokala.framwork.ioc.test.IHelloWorld#sayHelloWorld()
	 */
	@Override
	public String sayHelloWorld() {
		System.out.println(this.getClass()+" hello world");
		return ";hello world";
	}

	/* 
	 * @see com.zokala.framework.ioc.test.IHelloWord#hello()
	 */ 
	public String hello(){
		
		return "hello me";
	}

}
