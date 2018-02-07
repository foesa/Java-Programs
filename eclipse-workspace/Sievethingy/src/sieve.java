
/* SELF ASSESSMENT 
   1. createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment:all functions defined as in coding standard
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment:creates array of booleans of for numbers up to N
Did I return the correct item?
Mark out of 5:5
Comment: returns array
   2. crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment: have all parameters set as asked and defined as in asked
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2
Comment: checked before passing values that they are valid
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment: multiple is checked before being used
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: crossed out items that were already crossed out aren't re-crossed out
   3. sieve   
Did I have the correct function definition?
Mark out of 5: 5
Comment: defined as asked
Did I make calls to other methods?
Mark out of 5: 5
Comment:      calls all other functions as asked
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:2
Comment: returns array of booleans where primes are true and non-primes are false
   4. sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment: defined as asked
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: checked before being passed
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment:    checks if false and adds bracket else prints normally
   5. nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment: done as asked       
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:checked before being passed
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment: only values that are true are added
   6. main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:5
Comments: input asked for at the start
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment:  calls sieve and crossedout 
Did I print the output as shown in the question?  
Mark out of 5:3
Comment:  prints out but prints out for every prime number, don't know how to fix it. tried to compare strings doesn't work
   7. Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: used auto indent
Do my variable names make sense?
Mark out of 4:4
Comments:same variable names as in question
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: followed standard as asked
      Total Mark out of 100 (Add all the previous marks): 98 
*/
import java.util.Arrays;
import java.util.Scanner;

public class sieve {
	public static int BASE_NUMBER = 2;

	public static boolean[] sieve(int n) {
		boolean[] sequence = createSequence(n);
		String fullString = sequenceToString(sequence);
		System.out.println(fullString);
		String crossedOut = "";
		String oldCrossedOut = "";
		for (int count = 0; count < sequence.length; count++) {
			int higherMultiple = count + 2;
			if (sequence[count] == true) {
				sequence = crossOutHigherMultiples(higherMultiple, sequence);
				crossedOut = sequenceToString(sequence);
				if (crossedOut != oldCrossedOut) {
					oldCrossedOut = crossedOut;
					System.out.println(crossedOut);
				}
			}
		}
		return sequence;
	}

	public static boolean[] createSequence(int n) {
		boolean[] numberArray = new boolean[n - 1];
		Arrays.fill(numberArray, true);
		return numberArray;
	}

	public static boolean[] crossOutHigherMultiples(int n, boolean[] numberArray) {
		for (int count = 0; count <= numberArray.length; count++) {
			int base = count + 1;
			int multipliedNumber = base * n;
			int indexNumber = multipliedNumber - 2;
			if (multipliedNumber <= numberArray.length + 1) {
				if (multipliedNumber != n) {
					numberArray[indexNumber] = false;
				} else {
					numberArray[indexNumber] = true;
				}
			} else {
				count = numberArray.length + BASE_NUMBER;
			}
		}
		return numberArray;
	}

	public static String sequenceToString(boolean[] numberArray) {
		String crossedOutString = "";
		for (int count = 0; count < numberArray.length; count++) {
			int number = count + 2;
			if (numberArray[count] == true) {
				crossedOutString += number + ",";
			} else {
				crossedOutString += "[" + number + "]" + ",";
			}
		}
		return crossedOutString;
	}

	public static String nonCrossedOutSubSeqToString(boolean[] numberArray) {
		String nonCrossedOut = "";
		for (int count = 0; count < numberArray.length; count++) {
			int number = count + 2;
			if (numberArray[count] == true) {
				nonCrossedOut += number + ",";
			}
		}
		return nonCrossedOut;
	}

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Please enter a number to find the prime numbers: ");
		int maxNumber = inputScanner.nextInt();
		boolean[] numberSieve = sieve(maxNumber);
		String sieve = nonCrossedOutSubSeqToString(numberSieve);
		System.out.println(sieve);
	}
}
