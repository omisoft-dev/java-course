package com.omisoft.basic_java.DesignPatterns.task1;

/**
 * Tests the program
 * @author bkoprinski
 *
 */
public class Test {

    public static void main(String[] args) {
	MyClassFactory myClassFactory = new MyClassFactory();
	
	MyClass instance = myClassFactory.getMyClass("INSTANCE");
	instance.createInstance();
	
    }

}
