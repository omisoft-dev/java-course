package com.omisoft.jsp.Servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omisoft.jsp.DAO.AddToTableDAO;

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
}
