package com.omisoft.basic_java.exceptions.task3;
/**
 * Declaring a custom exception if the list is already empty
 * @author bkoprinski
 *
 */
public class AlreadyEmptyException extends Exception {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

	public AlreadyEmptyException(String message) {
        super(message);
    }
	
	public String toString()
	 {
		 return getMessage()+ "The list is already empty!";
	 }
}
