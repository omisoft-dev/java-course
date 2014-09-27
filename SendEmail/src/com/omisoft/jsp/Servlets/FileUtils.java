package com.omisoft.jsp.Servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
	
	/**
	 * Checks if the file exists and if yes reads it and writes it on the server
	 * @param path
	 * @param item
	 * @return true
	 */
	public boolean processFile(String path, org.apache.tomcat.util.http.fileupload.FileItemStream item)
	{
		FileOutputStream fos = null;
		InputStream is = null;
		try
		{
			File f = new File(path+File.separator+"files");
			if(!f.exists())
			{
				f.mkdir();
			}
			File savedFile = new File(f.getAbsolutePath() + File.separator + item.getName());
			fos = new FileOutputStream(savedFile);
			is = item.openStream();
			int x = 0;
			byte[] b = new byte[1024];
			while((x=is.read(b)) != -1)
			{
				fos.write(b, 0, x);
			}
			fos.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(fos != null)
			{
				try 
				{
					fos.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			if(is != null)
			{
				try 
				{
					is.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
