package com.omisoft.basic_java.IO.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadFromConsole {
	/**
	 * Reads string from the console
	 */
	public static void readString()
	{
		Scanner input = new Scanner (System.in);
		System.out.println("Enter some string: ");
		String readS = input.next();
		input.close();
		System.out.println(readS);
		
	}
	/**
	 * Reads integer from the console
	 * @exception InputMismatchException - exception for wrong format
	 */
	public static void readInt()
	{
		try
		{
			Scanner input = new Scanner (System.in);
			System.out.println("Enter an integer value: ");
			int readI = input.nextInt();
			input.close();
			System.out.println(readI);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Wrong format!");
			System.out.println("Please write an integer value.");
			readInt();
		}
	}
	/**
	 * Reads char from the console
	 */
	public static void readChar()
	{

		Scanner input = new Scanner (System.in);
		System.out.println("Enter an char value: ");
		char readC = input.next().charAt(0);
		input.close();
		System.out.println(readC);
		
	}
	/**
	 * Reads float from the console
	 * @exception InputMismatchException - exception for wrong format
	 */
	public static void readFloat()
	{
		try
		{
		Scanner input = new Scanner (System.in);
		System.out.println("Enter an float value: ");
		float readF = input.nextFloat();
		input.close();
		System.out.println(readF);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Wrong format!");
			System.out.println("Please write an float value.");
			readFloat();
		}
	}
}
