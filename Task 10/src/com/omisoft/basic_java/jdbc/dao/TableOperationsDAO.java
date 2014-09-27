package com.omisoft.basic_java.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.omisoft.basic_java.jdbc.dto.GetTableInfoDTO;
import com.omisoft.basic_java.jdbc.gui.AddUI;
import com.omisoft.basic_java.jdbc.gui.MainGUI;
import com.omisoft.basic_java.jdbc.servicelocator.AgeServiceException;
import com.omisoft.basic_java.jdbc.servicelocator.ValidateAgeService;


/**
 * Creating a class with table operation methods
 * @author bkoprinski
 *
 */
public class TableOperationsDAO extends BaseDAO implements TableDAO {
    private ResultSet rs;
    private ValidateAgeService objValidateAge;
    private JFrame err;
    
    /**
     * Query with the sql operations kept in strings
     */
    private static final String ADD_TO_TABLE_QUERY = "INSERT INTO Task2.People(Name,Age,Email,ID,KeyPeople)";
    private static final String UPDATE_TABLE_QUERY = "update Task2.People set Name=? , Age=? , Email=? , ID=?, KeyPeople=? " + "where ID = ?";
    private static final String PRINT_TABLE_QUERY = "select * from Task2.People";
    private static final String PRINT_PEOPLE_SYMBOL_QUERY = "select * from Task2.People WHERE Name LIKE '";
    private static final String PRINT_INFO_BY_CITY_QUERY = "SELECT Task2.People.Name, Task2.People.Age, Task2.People.Email, Task2.People.ID, Task2.Trip.TicketNumber, Task2.Trip.DateOfArival, Task2.Trip.DateOfDeparture, Task2.Trip.City "
    	+ "FROM People	"
    	+ "JOIN People_Trip ON People.KeyPeople = People_Trip.KeyPeople	"
    	+ "JOIN Trip ON Trip.KeyTrip = People_Trip.KeyTrip "
	+ "Where City = '";
    private static final String PRINT_ORDERED_CITIES_QUERY = "SELECT Task2.Trip.City, count(Task2.Trip.City) AS \"Number of people been in this city\" "
    	+ "FROM Task2.People "
    	+ "JOIN Task2.People_Trip ON Task2.People.KeyPeople = Task2.People_Trip.KeyPeople "
    	+ "JOIN Task2.Trip ON Task2.Trip.KeyTrip = Task2.People_Trip.KeyTrip "
    	+ "GROUP BY City "
    	+ "ORDER BY \"Number of people been in this city\";";
    private static final String DELETE_TABLE_CONTENTS_QUERY = "DELETE FROM ";
    private static final String DELETE_TABLE_QUERY = "DROP TABLE ";
    
    /**
     * Constructor
     */
    public TableOperationsDAO()
    {
	objValidateAge = new ValidateAgeService();
	err = new JFrame("Age Validation");
	try 
	{
	    this.connection();
	} 
	catch (Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    /**
     * Adding into table
     */
    @Override
    public void addToTable(GetTableInfoDTO dto) 
    {
	
        try 
        {	
     
            statement = connect.prepareStatement(ADD_TO_TABLE_QUERY + 
	    	"VALUES(?,?,?,?,?)");
	    
            statement.setString(1, dto.getName());
            try
            {
        	AddUI.setFlag(true);
        	statement.setInt(2, objValidateAge.validateAge());
            }
            catch(AgeServiceException e)
            {
        	// Age validation exception
        	AddUI.setFlag(false);
        	JOptionPane.showMessageDialog(err, "Please write a number between [3,120].", null, JOptionPane.ERROR_MESSAGE);
            }
            statement.setString(3, dto.getEmail());
            statement.setString(4, dto.getID());
            statement.setInt(5, dto.getKeyPeople());
	    
            statement.executeUpdate();
	    
	    System.out.println("Adding Completed.");
	}
        catch (SQLException e) 
        {
	    e.printStackTrace();
	}
        finally
        {
            closeConnection();
            closeStatement();
        }
    }

    /**
     * Updating table information
     */
    @Override
    public void updateTable(GetTableInfoDTO dto) 
    {
	try 
	{
	    statement = connect.prepareStatement(UPDATE_TABLE_QUERY);
	    
	    statement.setString(1, dto.getName());
	    statement.setInt(2, dto.getAge());
	    statement.setString(3, dto.getEmail());
	    statement.setString(4, dto.getID());
	    statement.setInt(5, dto.getKeyPeople());
	    statement.setString(6, dto.getID());
	    
	    statement.executeUpdate();
	    
	    System.out.println("Update Completed.");
	} 
	catch (SQLException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
	}
	
    }

    /**
     * Printing table information
     */
    @Override
    public void printTable() 
    {
	try 
	{
	    statement = connect.prepareStatement(PRINT_TABLE_QUERY);
	    
	    rs = statement.executeQuery();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append("List of People: ");
    	    MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    while (rs.next()) 
	    {
		String name = rs.getObject(1).toString();
		String age = rs.getObject(2).toString();
		String email = rs.getObject(3).toString();
		String id = rs.getObject(4).toString();
		MainGUI.textArea.append("\nName   : " + name);
		MainGUI.textArea.append("\nAge    : " + age );
		MainGUI.textArea.append("\nEmail  : " + email );
		MainGUI.textArea.append("\nID     : " + id );
		MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    }
	} 
	catch (SQLException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
            try 
            {
        	if (rs != null)
        	{
        	    rs.close();
        	}	
	    } 
            catch (SQLException e) 
            {
		e.printStackTrace();
	    }
	}
	
    }

    /**
     * Printing table information by giving the names first symbol
     */
    @Override
    public void printPeopleStartSymbol(String symbolinName) 
    {
	try
	{
	    statement = connect.prepareStatement(PRINT_PEOPLE_SYMBOL_QUERY + symbolinName + "%'");
	    
	    rs = statement.executeQuery();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append("List of People: ");
    	    MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    while (rs.next()) 
	    {
		String name = rs.getObject(1).toString();
		String age = rs.getObject(2).toString();
		String email = rs.getObject(3).toString();
		String id = rs.getObject(4).toString();
		MainGUI.textArea.append("\nName   : " + name);
		MainGUI.textArea.append("\nAge    : " + age );
		MainGUI.textArea.append("\nEmail  : " + email );
		MainGUI.textArea.append("\nID     : " + id );
		MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    }
	} 
	catch (SQLException e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
           
    	    try 
    	    {
    		if (rs != null)
        	{
        	    rs.close();
        	}
	    } 
    	    catch (SQLException e)
    	    {
		e.printStackTrace();
	    }
    	
	}
	
    }

    /**
     * Printing people information by giving a city where they travel to
     */
    @Override
    public void printInfoByCity(String city) 
    {
	try
	{
	    statement = connect.prepareStatement(PRINT_INFO_BY_CITY_QUERY + city + "'");
	    
	    rs = statement.executeQuery();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append("List of People: ");
    	    MainGUI.textArea.append("\n-----------------------------------------------------------------");
    	    
	    while (rs.next()) 
	    {
		String name = rs.getObject(1).toString();
		String age = rs.getObject(2).toString();
		String email = rs.getObject(3).toString();
		String id = rs.getObject(4).toString();
		String ticket = rs.getObject(5).toString();
		String dateofA = rs.getObject(6).toString();
		String dateofD = rs.getObject(7).toString();

		MainGUI.textArea.append("\nName   : " + name);
		MainGUI.textArea.append("\nAge    : " + age );
		MainGUI.textArea.append("\nEmail  : " + email );
		MainGUI.textArea.append("\nID     : " + id );
		MainGUI.textArea.append("\nTicket Number     : " + ticket );
		MainGUI.textArea.append("\nDate of Arival    : " + dateofA);
		MainGUI.textArea.append("\nDate of Departure : " + dateofD );
		MainGUI.textArea.append("\nCity              : " + city);
		MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    }
	} 
	catch (SQLException e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
            
            try 
            {
        	if (rs != null)
        	{
        	    rs.close();
        	}
	    }
            catch (SQLException e) 
            {
		e.printStackTrace();
	    }
	}
	
    }

    /**
     * Prints the cities ordering them by visitors
     */
    @Override
    public void printOrderedCity()
    {
	try 
	{
	    statement = connect.prepareStatement(PRINT_ORDERED_CITIES_QUERY);
	    
	    rs = statement.executeQuery();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append("List of People: ");
    	    MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    
	    while (rs.next()) 
	    {
		String city = rs.getObject(1).toString();
		String countCities = rs.getObject(2).toString();
		
		MainGUI.textArea.append("\nCity                               : " + city);
		MainGUI.textArea.append("\nNumber of people been in this city : " + countCities );
		MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    }
	    
	} 
	catch (SQLException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
            try 
            {
        	if (rs != null)
        	{
        	    rs.close();
        	}
	    } 
            catch (SQLException e) 
            {
		e.printStackTrace();
	    }
	}
    }

    /**
     * Deletes table contents by giving a table name 
     */
    @Override
    public void deleteTableContent(GetTableInfoDTO dto) 
    {
	try 
	{
	    statement = connect.prepareStatement(DELETE_TABLE_CONTENTS_QUERY + dto.getTable());
	    
	    statement.execute();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append(dto.getTable() + " Table Contents Deleted.");
	} 
	catch (SQLException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
	}
    }

    /**
     * Deleting the whole table by giving a table name 
     */
    @Override
    public void deleteTable(GetTableInfoDTO dto) 
    {
	try
	{
	    statement = connect.prepareStatement(DELETE_TABLE_QUERY + dto.getTable());
	    
	    statement.execute();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append(dto.getTable() + " Table Contents Deleted.");
	} 
	catch (SQLException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
	}
    }
}
