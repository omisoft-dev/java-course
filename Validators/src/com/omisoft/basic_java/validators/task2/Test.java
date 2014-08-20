package com.omisoft.basic_java.validators.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Scanner input2 = new Scanner(System.in);
		BulstatValidator bulstat = new BulstatValidator();
		
		try 
		{
			int ch;
			do{

				System.out.println("Please choose an option:");
				System.out.println("1 - Enter 9 digit Bulstat");
				System.out.println("2 - Enter 13 digit Bulstat");
				System.out.println("3 - Exit");
				
				ch = input2.nextInt();
				
				switch (ch) 
				{
					case 1: System.out.println("Enter your Bulstat: ");
							String in = input.readLine();
							bulstat.bulstat9Dig(in);
					break;
					case 2: System.out.println("Enter your Bulstat: ");
							String in2 = input.readLine();
							bulstat.bulstat13Dig(in2);
					case 3: break;
				}
			
			}
			while (ch != 3);
			
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			input2.close();
			try
			{
				if (input != null)
				{
					input.close();
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
