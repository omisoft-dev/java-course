package com.omisoft.basic_java.DesignPatterns.task1;

public class MyClass implements Instance{
    
    
    /**
     * The default constructor
     * @param name 
     */
    public MyClass()
    {
	
    }
    
    /**
     * Overriding the createInstance method
     */
    @Override
    public void createInstance() {
	System.out.println("Inside MyClass::createInstance() method.");
	
    }
}