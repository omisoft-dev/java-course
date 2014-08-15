package com.omisoft.basic_java.IO.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Reverses the data from the text file.
 * @author bkoprinski
 *
 */
public class ReverseText {
	public static void reverseText()
	{
		String fileName = "reverseText.txt";
		Scanner fileReader = null;
		try
		{
			fileReader = new Scanner(new File(fileName));
			System.out.println("File " + fileName + " opened.");
			
			String buf ;
			while (fileReader.hasNextLine()) 
			{
				buf = fileReader.next();
				System.out.println("File info: "+buf);
				String reverse = new StringBuffer(buf).reverse().toString();
				System.out.println("Reverse file info: "+reverse);
				PrintWriter fileWriter = new PrintWriter(fileName);
				fileWriter.print(reverse);
				fileWriter.close();
			}
		}
		catch (FileNotFoundException fnf) 
		{
			System.err.println("File " + fileName + " not found.");
		}
		catch (NullPointerException npe) 
		{
			System.err.println("File " + fileName + " not found.");
		}
		finally 
		{
			if (fileReader != null) 
			{
				fileReader.close();
			}
			System.out.println("File closed.");
		}
	}
}
