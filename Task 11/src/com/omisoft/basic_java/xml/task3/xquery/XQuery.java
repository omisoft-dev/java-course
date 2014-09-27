package com.omisoft.basic_java.xml.task3.xquery;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class XQuery {
 
    
    /**
     * Query with the sql operations kept in strings
     */
    private static final String SORT_BY_YEAR = "for $x in doc('books.xml')//book order by $x/year return $x/title/text()"; // ex3
    private static final String AVG_PRICE = "let $x := doc('books.xml')//book return avg($x/price)"; // ex4
    private static final String NAME_COUNT_AUTHORS = "for $x in doc('books.xml')//book let $y := count($x/author) where $x/price>30  return ($x/title,<author>{$y}</author>)"; // ex5
    private static final String CHILD_TITLE_LETTER_CASE = "for $x in doc('books.xml')//book  return	if ($x/@category=\"CHILDREN\") then <child>{upper-case($x/title)}</child> else <adult>{lower-case($x/title)}</adult>"; // ex6
    private static final String DISCOUNT_BOOK_TITLES = "for $x in doc('books.xml')//book let $y := $x/price*0.1  return if($x/year>2003) then ($x/title,(<price>{($x/price)-$y}</price>)) else ($x/title,(<price>10</price>))"; // ex7
    
    /**
     * Starts the program by opening a connection.
     * The program has a menu from which the user can choose an option and an operation will be executed
     */
    public static void query()
    {
	XQDataSource xqs = new SaxonXQDataSource();
	
	XQConnection conn = null;
	XQExpression xqe;
	XQResultSequence rs;
	int fCase = 0;
	Scanner input = null;
	
	try 
	{
	    conn = xqs.getConnection("root", "asdqwe123");
	    xqe = conn.createExpression();
	    input = new Scanner(System.in);
	    
	    do
		{
		    System.out.println("-------------------------------------------------------------------------------");
		    System.out.println("Please choose an option:");
		    System.out.println("1 - Print all the titles ordered by year of publication.");
		    System.out.println("2 - Print the average price of all the books.");
		    System.out.println("3 - Print the titles and the number of authors who wrote the books which cost more than $30.");
		    System.out.println("4 - Print the names of the childen books with upper-case letters and the adult books with lower-case letters.");
		    System.out.println("5 - Print the books with discount.");
		    System.out.println("6 - Exit.");
		    System.out.println("-------------------------------------------------------------------------------");
		    
		    fCase = input.nextInt();
		    
		    switch (fCase) 
		    {
		    	case 1: rs = xqe.executeQuery(SORT_BY_YEAR);
	        	    	while(rs.next())
	        		{
	        		     System.out.println(rs.getItemAsString(null));
	        		}
			break;
			
		    	case 2: rs = xqe.executeQuery(AVG_PRICE);
	        	    	while(rs.next())
	        		{
	        		     System.out.println(rs.getItemAsString(null));
	        		}
	        	break;
		    	
		    	case 3: rs = xqe.executeQuery(NAME_COUNT_AUTHORS);
	        	    	while(rs.next())
	        		{
	        		     System.out.println(rs.getItemAsString(null));
	        		}
	        	break;
	        	
		    	case 4: rs = xqe.executeQuery(CHILD_TITLE_LETTER_CASE);
	        	    	while(rs.next())
	        		{
	        		     System.out.println(rs.getItemAsString(null));
	        		}
		    	break;
		    	
		    	case 5: rs = xqe.executeQuery(DISCOUNT_BOOK_TITLES);
	        	    	while(rs.next())
	        		{
	        		     System.out.println(rs.getItemAsString(null));
	        		}
		    	break;
		    	case 6: break;
		    }
		}
		while(fCase != 6);
	    
	}
	catch (XQException e) 
	{
	    e.printStackTrace();
	}
	catch(InputMismatchException j)
	{
	    System.err.println("Please write an integer value.");
	}
	finally
	{
	    if(conn != null)
	    {
		try 
		{
		    conn.close();
		}
		catch (XQException e)
		{
		    e.printStackTrace();
		}
	    }
	    if(input != null)
	    {
		input.close();
	    }
	}
    }
}
