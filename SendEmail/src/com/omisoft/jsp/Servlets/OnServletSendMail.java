package com.omisoft.jsp.Servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


/**
 * Creating a servlet for the Send Email page
 * @author bkoprinski
 *
 */
public class OnServletSendMail extends HttpServlet{
	Validator valid = new Validator();
	private static final long serialVersionUID = 1L;
	

	/**
	 * Overriding the post method
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html");
		
		boolean isMultiPart = ServletFileUpload.isMultipartContent(req);
		String path2 = null,to = null,subject = null,textBody = null;
		org.apache.tomcat.util.http.fileupload.FileItemStream item = null;
		String path = null;
		int firstindex;
		String Filename = null;
		
		if(isMultiPart)
		{
			ServletFileUpload upload = new ServletFileUpload();
			try
			{
				org.apache.tomcat.util.http.fileupload.FileItemIterator iter = upload.getItemIterator(req);
				
				while(iter.hasNext())
				{
					item = iter.next();
				
					if(item.isFormField())
					{
						String fieldName = item.getFieldName();
						InputStream is = item.openStream();
						byte[] b = new byte[is.available()];
						is.read(b);
						String value = new String(b);
						if ("to".equals(fieldName)) 
						{
							to = value;
						}
						else if("subject".equals(fieldName))
						{
							subject = value;
						}
						else if("textBody".equals(fieldName))
						{
							textBody = value;
						}		
					}
					else
					{
						path = getServletContext().getRealPath("/");
						firstindex = path.indexOf(".metadata");
						
						path2 = path.substring(0, firstindex)+item.getName();
						Filename = item.getName();
					}
				}
			}
			catch(org.apache.tomcat.util.http.fileupload.FileUploadException | IllegalArgumentException e)
			{
				e.printStackTrace();
			}

			valid.send(path2, Filename, to, subject, textBody);
			resp.sendRedirect("MailSend.jsp");
		}
	}

}
