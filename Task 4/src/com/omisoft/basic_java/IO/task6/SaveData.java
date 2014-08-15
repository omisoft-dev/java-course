package com.omisoft.basic_java.IO.task6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData {
	/**
	 * Saves an object in existing file or if the file doesnt exist 
	 * it creates a new file with the same name
	 * @param path - the path of the file
	 * @param o - object
	 */
	public static void saveObject(String path, Object o)
	{
		File browse = new File(path);
		if (browse.isFile() == false)
		{
			
			try
			{
				browse.createNewFile();
				System.out.println("The file "+browse.getName()+" is created.");
			}
			catch(IOException e)
			{
				System.err.println("Error during reading/writing.");
			}
					
		}

		try{
			FileWriter write = new FileWriter(browse.getAbsoluteFile());
			BufferedWriter buf = new BufferedWriter(write);
			buf.write(o.toString());
			buf.close();
			
		}
		catch(IOException e)
		{
			System.err.println("Error during reading/writing.");
		}
		System.out.println("The file is saved.");
	}
}
