package com.omisoft.jsp.Servlets;

import java.io.File;
import java.io.IOException;
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

public class MailSender {
	
	/**
	 * Constants that keep all the Email sending properties
	 */
	private static final String HOST_KEY ="mail.smtp.host";
	private static final String HOST_VALUE ="smtp.gmail.com";
	private static final String SOCKETFACTORY_PORT_KEY ="mail.smtp.socketFactory.port";
	private static final String PORT_VALUE ="465";
	private static final String CLASS_KEY ="mail.smtp.socketFactory.class";
	private static final String CLASS_VALUE ="javax.net.ssl.SSLSocketFactory";
	private static final String AUTH_KEY ="mail.smtp.auth";
	private static final String AUTH_VALUE ="true";
	private static final String PORT_KEY ="mail.smtp.port";
	
	
	/**
	 * Send email method
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	public void send(String path, String filename, String to, String subject, String textBody) throws IOException
	{
		Properties props = new Properties();
		props.put(HOST_KEY, HOST_VALUE);
		props.put(SOCKETFACTORY_PORT_KEY, PORT_KEY);
		props.put(CLASS_KEY, CLASS_VALUE);
		props.put(AUTH_KEY, AUTH_VALUE);
		props.put(PORT_KEY, PORT_VALUE);
		
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("b.koprinski@omisoft.eu","9211105326");
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
}
