/* SELF ASSESSMENT

Harness Class: Member variables (8 marks)
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment:Set all data members to private and set make and model number to final as they don't change. Constant for max number of uses declared also

Harness Class: Harness constructor 1 & constructor 2 (6 marks)
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment: Harness constructor takes in all possible parameters and set to default states, second constructor takes fewer parameters setting some to default

Harness Class: checkHarness method (5 marks)
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment: Asks the user for the name of the instructor and then the name is associated with a specific harness and stored back in the array

Harness Class: isHarnessOnLoan method (2 marks)
My method has no parameters and returns the value of the loan status variable.
Comment: no parameters and returns a boolean

Harness Class: canHarnessBeLoaned method (4 marks)
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment: no parameters and checks if the number of uses is less than the max no of uses and if it's currently on loan, returns true or false

Harness Class: loanHarness method (6 marks)
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment: takes in a members name and is stored, increments no of uses after checking that the harness can be loaned. if false returns null
 
Harness Class: returnHarness method (5 marks)
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment:Resets name of borrower to nothing and sets the on loan status to false, if the harness is on loan

Harness Class: toString method (3 marks)
My method returns a String representation of all the member variables.
Comment: used auto generated to string method

HarnessRecords Class: member variables (3 marks)
I declare the member variable as a private collection of Harnesses 
Comment:Arraylist is declared as private

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks)
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the Java I/O to read data from a text file I created containing sets of Harness characteristics. I use these set of characteristics to create Harness objects and add them to the collection. 
Comment: arraylist is set to null, I use inputStream and then a reader to parse the input and create harness's stored in the arrayList

HarnessRecords Class: isEmpty method (1 marks)
I return true if the collection is null/empty and, false otherwise.
Comment: returns a boolean true or false, based off the size 

HarnessRecords Class: addHarness method (5 marks)
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment:  takes in a harness and adds to the arraylist

HarnessRecords Class: findHarness method (6 marks)
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment:takes in a string and an int. checks through the array if both can be found in an harness and returns that harness

HarnessRecords Class: checkHarness method (6 marks)
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment:asks for all three and returns the harness that's been checked.

HarnessRecords Class: loanHarness method (7 marks)
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment: takes in a string club member and searches through the arraylist cfor the first harness that can be loaned. this harness is then returned and loaned(is on loan set to true) and number of uses is increased and name of user is added

HarnessRecords Class: returnHarness method (7 marks)
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment:Takes in a string and an int. this harness if is in the arraylist is then the harness value isOnLoan is set to false and the name of the last user is removed

HarnessRecords Class: removeHarness method (8 marks)
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment: Takes a string and an int and checks the collection for this harness and is removed from the arraylsit. the removed harness is then returned to the main

GUI (Java main line) (5 marks)
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: implements all the requirements in the question asked.
*/
import java.io.*;
import java.util.Scanner;
public class HarnessMain {
	public static void main(String[]args) {
		InputStream data = null;
		try {
			data = new FileInputStream("C:\\Users\\legua\\Documents\\harnessTest.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		harnessRecords mainRecord = new harnessRecords(data);
		mainHarnessTest(mainRecord);
	}
	public static void mainHarnessTest(harnessRecords record) {
		System.out.println("Please enter the make and model number of the harness you widh to remove: ");
		Scanner harnessScanner = new Scanner(System.in);
		String make = harnessScanner.next();
		int modelNumber = harnessScanner.nextInt();
		harnessScanner.nextLine();
		record.removeHarness(make, modelNumber);
		System.out.println("Please enter the make and model number of the Harness you wish to check: ");
		make = harnessScanner.next();
		modelNumber = harnessScanner.nextInt();
		harnessScanner.nextLine();
		System.out.print("Please enter the name of the instructor you wish to check the harness: ");
		String instructorName = harnessScanner.nextLine();
		harness checkedHarness = record.checkHarness(instructorName, make, modelNumber);
		String checck = checkedHarness.toString();
		System.out.println(checck + "has been checked by "+instructorName);
		System.out.print(" Enter the name of the person requesting a harness: ");
		String userName = harnessScanner.nextLine();
		harness lendHarness = record.loanHarness(userName);
		System.out.println(" The harness "+lendHarness.toString()+" has been lent to " + userName);
		harness returnHarness = record.returnHarness(lendHarness.getMake(), lendHarness.getModelNumber());
		System.out.println(" Thes harness "+returnHarness+" has been returned");
	}
}
