package com.omisoft.basic_java.DesignPatterns.task1;


public class MyClassFactory {
    /**
     * Creating a getMyClass method
     * @param instance - string 
     * @return - new instance
     */
    public MyClass getMyClass(String instance)
    {
	if(instance == null)
	{
	    return null;
	}
	else if (instance.equalsIgnoreCase("INSTANCE"))
	{
	    return new MyClass();
	}
	return null;
    }
}
