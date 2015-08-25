/**
 *com.zokala.framwork.ioc.test
 * IHelloImpl.java
 */
package com.zokala.framework.ioc.test;

/**
 * @author ³ÂÐãÄÜ
 * 2011-8-5 ÏÂÎç09:13:28 
 */
public class HelloImpl implements IHello {
	private IHelloWorld helloWorld;






	public IHelloWorld getHelloWorld() {
		return helloWorld;
	}






	public void setHelloWorld(IHelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}






	/* 
	 * @see com.zokala.framwork.ioc.test.IHello#sayHello()
	 */
	@Override
	public String sayHello() {
		System.out.println(this.getClass()+" hello 1");
		return "hello "+helloWorld.sayHelloWorld();
	}

}
