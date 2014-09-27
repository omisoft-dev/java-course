package com.omisoft.jsp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omisoft.jsp.DAO.AddToTableDAO;
import com.omisoft.jsp.DTO.GetTableInfoDTO;

public class MailRegister {
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
}
