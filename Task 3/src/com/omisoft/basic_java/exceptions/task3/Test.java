package com.omisoft.basic_java.exceptions.task3;

/**
 * Tests the two custom exceptions
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {

		try
		{
			ListOfElements list = new ListOfElements();
			list.add();
			list.remove();
			list.printAllElements();	
		}
		catch(AlreadyEmptyException aee)
		{
			aee.printStackTrace();
		}
		catch(AlreadyFullException afe)
		{
			afe.printStackTrace();
		}
		
		
	}

}
