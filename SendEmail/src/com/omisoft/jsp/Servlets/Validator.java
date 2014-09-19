package com.omisoft.jsp.Servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omisoft.jsp.DAO.AddToTableDAO;
import com.omisoft.jsp.DTO.GetTableInfoDTO;
import com.omisoft.jsp.DTO.SendMailProperties;

/**
 * This class keeps all the methods which are executed in the Servlet classes
 * @author bkoprinski
 *
 */
public class Validator extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * Login method
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	public void validate(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
        res.setContentType("text/html");
      
        String email=req.getParameter("email");
        String pass=req.getParameter("userPassword");
        
        AddToTableDAO obj = new AddToTableDAO();
		
        if (obj.checkUser(email, pass)) 
        {
        	try
    		{
        		session = req.getSession(true); 
        		session.setAttribute("aaaa", email);
    		}
        	catch(NullPointerException e)
        	{
        		e.printStackTrace();
        	}
    		res.sendRedirect("EmailForm.html");
        }
        else
        {
        	res.sendRedirect("LoginFail.jsp");
        }
	}
	
	/**
	 * Register method
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	public void register(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        
        AddToTableDAO addUser = new AddToTableDAO();
        
        String fistname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email= req.getParameter("email");
        String pass = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        
        if(!addUser.checkEmail(email))
        {
        	GetTableInfoDTO userInfo = new GetTableInfoDTO(fistname,lastname,email,pass,age);
           
            addUser.addToTable(userInfo);
            res.sendRedirect("Success.jsp");
        }
        else
        {
        	pw.println("Email exists!");
        }
        
        if(pw != null)
        {
        	pw.close();
        }
	}
	
	/**
	 * Send email method
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	public void send(String path, String filename, String to, String subject, String textBody) throws IOException
	{
		Properties props = new Properties();
		props.put(SendMailProperties.HOST_KEY, SendMailProperties.HOST_VALUE);
		props.put(SendMailProperties.SOCKETFACTORY_PORT_KEY, SendMailProperties.PORT_KEY);
		props.put(SendMailProperties.CLASS_KEY, SendMailProperties.CLASS_VALUE);
		props.put(SendMailProperties.AUTH_KEY, SendMailProperties.AUTH_VALUE);
		props.put(SendMailProperties.PORT_KEY, SendMailProperties.PORT_VALUE);
		
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("b.koprinski@omisoft.eu","aaaaa");
					}
				}		
		);
		
		try
		{
			Message mess = new MimeMessage(session);
			
			if(filename == "")
			{
				mess.setFrom(new InternetAddress("b.koprinski@omisoft.eu"));
				mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				mess.setSubject(subject);
				mess.setText(textBody); 
				
				javax.mail.Transport.send(mess);
			}
			else
			{
	            mess.setFrom(new InternetAddress("b.koprinski@omisoft.eu"));
	            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	            mess.setSubject(subject);
	            
	            BodyPart messageBodyPart = new MimeBodyPart();
	            Multipart multipart = new MimeMultipart();
	            
	            File file = new File(path);
	            DataSource source = new FileDataSource(file);
	            messageBodyPart.setDataHandler(new DataHandler(source));
	       
	            messageBodyPart.setFileName(filename);
	            multipart.addBodyPart(messageBodyPart);
	            
	            BodyPart messageBodyPart2 = new MimeBodyPart();
	            messageBodyPart2.setText(textBody);
	            multipart.addBodyPart(messageBodyPart2);
	            mess.setContent(multipart);

	            javax.mail.Transport.send(mess);
			}
			
			
			System.out.println("Message send!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Message not send!");
		}
	}
	
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
