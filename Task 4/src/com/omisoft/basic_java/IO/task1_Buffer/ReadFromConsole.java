package com.omisoft.basic_java.IO.task1_Buffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class ReadFromConsole {
	
	private static BufferedReader input;
	
	/**
	 * Reads string from the console
	 */
	public static void readString()
	{
		input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter some string: ");
		String readS;
		try 
		{
			readS = input.readLine();
			System.out.println(readS);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * Reads integer from the console
	 * @exception InputMismatchException - exception for wrong format
	 */
	public static void readInt()
	{
		try
		{
			input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter an integer value: ");
			int readI;
			try 
			{
				readI = Integer.parseInt(input.readLine());
				System.out.println(readI);
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println();
			System.err.println("Wrong format!");
			System.err.println("Please write an integer value.");
			
			readInt();
		}
	}
	/**
	 * Reads char from the console
	 */
	public static void readChar()
	{

		input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter an char value: ");
		char readC;
		try 
		{
			readC = input.readLine().charAt(0);
			System.out.println(readC);
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * Reads float from the console
	 * @exception InputMismatchException - exception for wrong format
	 */
	public static void readFloat()
	{
		input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter an float value: ");
		float readF;
		try 
		{
			readF = Float.parseFloat(input.readLine());
			System.out.println(readF);
		} 
		catch (NumberFormatException e) 
		{
			System.err.println("Wrong format!");
			System.err.println("Please write an float value.");
			readFloat();
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
	}
	
	public static void closeBuffer()
	{
		input = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			input.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
