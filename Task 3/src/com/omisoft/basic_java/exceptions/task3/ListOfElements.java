package com.omisoft.basic_java.exceptions.task3;

import java.util.ArrayList;
import java.util.Scanner;



public class ListOfElements {

	private ArrayList<Object> arr = new ArrayList<Object>();

	
	/**
	 * Removes the last element of the StringBuilder
	 * @throws AlreadyEmptyException
	 */
	public void remove() throws AlreadyEmptyException
	{
		if(arr.size() == 0)
		{
			throw new AlreadyEmptyException("");
		}
		else
		{
			int a = arr.size();
			arr.remove(a);		
		}
		
	}
	
	/**
	 * Adds 5 elements to the StringBuilder
	 * @param obj - element from the keyboard
	 */
	public void add() throws AlreadyFullException
	{
		Scanner input = new Scanner(System.in);
		String first = input.next();
		String second = input.next();
		String third = input.next();
		String forth = input.next();
		String fifth = input.next();
		String sixth = input.next();
	
		arr.add(first);
		arr.add(second);
		arr.add(third);
		arr.add(forth);
		arr.add(fifth);
		arr.add(sixth);
			
		if (arr.size() > 5)
		{
			throw new AlreadyFullException("List = "+arr);
		}
		
		input.close();
		
	}
	/**
	 * Prints all the elements of the StringBuilder
	 */
	public void printAllElements()
	{
		System.out.println(arr);
	}


}
