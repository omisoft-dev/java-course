package com.omisoft.basic_java.xml.task2.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Tests the program with JAXB parser(Unmarshall - for converting xml to object) for the Duties_Patients table
 * You can print the attributes from the xml file
 * @author bkoprinski
 *
 */
public class XMLToObject_DutiesPatients {
    public static final String FILE_NAME = "Duties_Patients_Table (JAXB).xml";
   
    /**
     * Starts the program
     * @param args
     */
    public static void main(String[] args) {
	
	try 
	{
	    DutiesPatientsJAXB dp = (DutiesPatientsJAXB) ((JAXBContext.newInstance(DutiesPatientsJAXB.class)).createUnmarshaller()).unmarshal(new File(FILE_NAME));

	    System.out.println(dp);
	} 
	catch (JAXBException e) 
	{
	    e.printStackTrace();
	}
    }

}
