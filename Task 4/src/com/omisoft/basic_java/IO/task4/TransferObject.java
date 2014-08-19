package com.omisoft.basic_java.IO.task4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TransferObject {

	private InputStream in;
	private OutputStream out;
	/**
	 * Constructor
	 * @param in - InputStream
	 * @param out - OutputStream
	 */
	public TransferObject(InputStream in,OutputStream out)
	{
		this.in=in;
		this.out=out;
	}
	
	/**
	 * Transfers the data from one file to another
	 * @param numberOfBytes - number of the bytes which will be transfered
	 * @param offset - shows how many bytes from the beginning of the file are going to be skipped
	 * @return - the number of the transfered bytes
	 */
	public int transfer(int numberOfBytes, int offset)
	{
		int a = numberOfBytes;
		try
		{
			byte[] buffer = new byte[1024];
			
			while ((numberOfBytes = in.read(buffer)) != -1)
			{
				out.write(buffer, offset, a);
				
			}	
			System.out.println("Streams transfered successfully.");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				out.flush();
				in.close();
				out.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		return a;
	}	
	
}
