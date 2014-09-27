package com.omisoft.jsp.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creating a servlet for the register page
 * @author bkoprinski
 *
 */
public class OnServletRegister extends HttpServlet {
	
	private MailRegister reg;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public OnServletRegister()
	{
		reg = new MailRegister();
	}

	/**
	 * Overriding the post method
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		reg.register(req, resp);
	}

	
}
