package com.omisoft.basic_java.IO.task6;


/**
 * Tests the two methods getObject and saveObject
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {

		
		DataClass person = new DataClass();
		person.setName("Georgi");
		person.setAge(45);
		person.getObject("/home/bkoprinski/dev/bkoprinski/Task 4/Data.out",person);
		
		SaveData.saveObject("/home/bkoprinski/dev/bkoprinski/Task 4/Data.txt", person);
	}

}
