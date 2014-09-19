package com.omisoft.jsp.DTO;

/**
 * Class that keeps all the Email sending properties
 * @author bkoprinski
 *
 */
public class SendMailProperties {
	public static final String HOST_KEY ="mail.smtp.host";
	public static final String HOST_VALUE ="smtp.gmail.com";
	public static final String SOCKETFACTORY_PORT_KEY ="mail.smtp.socketFactory.port";
	public static final String PORT_VALUE ="465";
	public static final String CLASS_KEY ="mail.smtp.socketFactory.class";
	public static final String CLASS_VALUE ="javax.net.ssl.SSLSocketFactory";
	public static final String AUTH_KEY ="mail.smtp.auth";
	public static final String AUTH_VALUE ="true";
	public static final String PORT_KEY ="mail.smtp.port";
}
