package com.omisoft.basic_java.IO.task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
/**
 * Reads text from the console and writes it in text file
 * @exception IOException - Error during reading/writing
 * @author bkoprinski
 *
 */
public class ReadWriteConsole {
	public static void ReadWrite()
	{
		try{
			PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
			int ch;
			
			System.out.print ("Enter some text: ");
			while ((ch = System.in.read()) != '.') 
			{
				char s = (char) ch;

				out.print(s);
				System.setOut(out);
			}
			out.close();		
		}
		catch(IOException e)
		{
			System.err.println("Error during reading/writing.");
		}
		
	}
}
