/* SELF ASSESSMENT 

Class Retional 
I declared two member variables: numerator and denominator (marks out of 4:4 ).
Comment:numerator and denominator declared in class before making class Rational

Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5:5 ).
Comment: takes in 2 integers and sets them to the numerator and denominator. checks to see if the denominator is equal to 0 before setting the values and throws an error in the main

Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3:3 ).
Comment: takes in an integer and then calls the other rational constructor passing the taken parameter and 1 as parameters

Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8:8 ).
Comment: takes in only a seperate rational number and calls the this function to get more values. returns a seperate Rational number and doesn't change the values of the given rational numbers

Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8:8 ).
Comment: returns a seperate rational number and doesn't change the given parameters

Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8:8 ).
Comment: returns a seperate rational number and doesn't change the given parameters

Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8:8 ).
Comment: returns a seperate rational number and doesn't change the given parameters

Equals Method 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value ((marks out of 8: 8).
Comment:takes in a seperate rational number and calls values within the class. uses multiplication between the numerator and denominator of the 2 rationals and compares them if they are equal returning true or otherwise false

isLessThan 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value (marks out of 8: 8).
Comment: compares 2 rational numbers calling this for the other parameters. does multiplication between numerator and denominator and checks if it's lower returning true or false 

Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8: 8).
Comment: calls gcd then divides both numerator and denominator by gcd. sets the numerator and denominator to these values now instead.

gcd function 
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6: 6).
Comment: used gcd code from a semester 1 to calculate gcd. Seems to be buggy for negative numbers though

toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4: 4).
Comment: calls this and takes in the numerator and denominator and returns a string in the format shown above

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22:22 ).
Comment: creates 2 rational numbers by storing the input in a string array then parsing as an int and depending on whats in the cell calls a different rational constructor. Calls all the rational tests (add subtract etc) and prints out the result.

Mark out of 100: 100
*/
import java.util.Scanner;

public class rationalNumbers {
	public static void test(Rational firstNumber, Rational secondNumber) {
		Rational addedNumber = firstNumber.add(secondNumber);
		addedNumber.simplify();
		System.out.println(firstNumber.toString() + "+" + secondNumber.toString() + " = " + addedNumber.toString());
		Rational subtractedNumber = firstNumber.subtract(secondNumber);
		subtractedNumber.simplify();
		System.out
				.println(firstNumber.toString() + "-" + secondNumber.toString() + " = " + subtractedNumber.toString());
		Rational multipliedNumber = firstNumber.multiply(secondNumber);
		multipliedNumber.simplify();
		System.out
				.println(firstNumber.toString() + "*" + secondNumber.toString() + " = " + multipliedNumber.toString());
		Rational dividedNumber = firstNumber.divide(secondNumber);
		dividedNumber.simplify();
		System.out.println(firstNumber.toString() + "/" + secondNumber.toString() + " = " + dividedNumber.toString());
		if (firstNumber.Equals(secondNumber)) {
			System.out.println(firstNumber.toString() + " is equal to " + secondNumber.toString());
		} else {
			System.out.println(firstNumber.toString() + " is not equal to " + secondNumber.toString());
		}
		if (firstNumber.isLessThan(secondNumber)) {
			System.out.println(firstNumber.toString() + " is less than " + secondNumber.toString());
		} else {
			System.out.println(firstNumber.toString() + " is not less than  " + secondNumber.toString());
		}
	}

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		inputScanner.useDelimiter(",");
		boolean finished = false;
		while (!finished) {
			System.out.println(
					"Please enter 4 numbers, seperated by a commas or place the letter I after a number for an integer to be represented: ");
				Rational firstNumber;
				Rational secondNumber;
				String inputString = inputScanner.nextLine();
				String[] inputArray = inputString.split(",");
				int initialNumerator = Integer.parseInt(inputArray[0]);
				if (inputArray[1]!="I") {
					int initialDenomenator = Integer.parseInt(inputArray[1]);
					if (initialDenomenator == 0) {
						System.out.println("Denominator cannot equal to zero");
					} else {
						firstNumber = new Rational(initialNumerator, initialDenomenator);
						int secondNumerator = Integer.parseInt(inputArray[2]);
						if (inputArray[3]!="I") {
							int secondDenomenator = Integer.parseInt(inputArray[3]);
							if (secondDenomenator == 0) {
								System.out.println("Denominator cannot equal to zero");
							} else {
								secondNumber = new Rational(secondNumerator, secondDenomenator);
								test(firstNumber, secondNumber);
							}
						} else {
							secondNumber = new Rational(secondNumerator);
							test(firstNumber, secondNumber);
						}
					}
				} else {
					firstNumber = new Rational(initialNumerator);
					int secondNumerator = Integer.parseInt(inputArray[2]);
					if (inputArray[3]!="I") {
						int secondDenomenator = Integer.parseInt(inputArray[3]);
						if (secondDenomenator == 0) {
							System.out.println("Denominator cannot equal to zero");
						} else {
							secondNumber = new Rational(secondNumerator, secondDenomenator);
							test(firstNumber, secondNumber);
						}
					} else {
						secondNumber = new Rational(secondNumerator);
						test(firstNumber, secondNumber);
					}
				}
			}
		}
	}

