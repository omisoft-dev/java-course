package com.omisoft.basic_java.IO.task6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class DataClass implements Serializable {
	private String name;
	private int age;
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	DataClass()
	{
		
		this.name=name;
		this.age=age;
	}
	
	/**
	 * Method for writing in file and reading from this file
	 * @param path - String - directory of the file
	 * @param person - object that is defined in the main program
	 * @return
	 */
	public DataClass getObject(String path, Object person)
	{
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		FileOutputStream outFile = null;
		
		try
	    {
	    	outFile = new FileOutputStream(path);
	    	
	    	out = new ObjectOutputStream(outFile);
	    	out.writeObject(person);
	    	
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
		finally
		{
			try {
				out.flush();
				out.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		try
	    {
	      FileInputStream inFile = new FileInputStream(path);
	      in = new ObjectInputStream(inFile);

	      Object obj1 = in.readObject();
	      DataClass restoredPerson = (DataClass)obj1;
	      System.out.println("Name: " + restoredPerson.name);
	      System.out.println("Age: " + restoredPerson.age);
	      
	    }
		 catch(IOException ex)
	    {
	      ex.printStackTrace();
	    }
	    catch(ClassNotFoundException ex)
	    {
	      ex.printStackTrace();
	    }
		finally
		{
			try 
			{
				in.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return null;

	}
}
