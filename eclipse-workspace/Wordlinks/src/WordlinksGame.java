/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: returns an string array list takes in nothing
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: checked this by entering in nonsense words and seeing if it says if it is or isn't a word
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: returns array list dictionary.

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: method definition asks for string of words and returns a array of type string
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: splits string and stores as an array. spaces are removed to prevent errors

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: asks for array of type string and returns a boolean
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: takes each word and compares each word after the index of the word. 
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: if word isn't unique it stops and returns false
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: only returns true once entire array has been run through

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: returns a boolean and requires a string to run
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: uses binarySearch in collections as arrayList doesn't have that method.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: when a nonsense word is entered it returns a minus value so false is returned

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: asks for 2 strings and returns a boolean
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: uses a loop and compares the characters of each word at the same index and if more than 1 are different then returns false; else returns true. first checks for the length of both words

6. isWordChain(renamed to is validwordLink
- I have the correct method definition [Mark out of 5:5]
- Comment: asks for String array and array list and returns a boolean if is true
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: calls all 3 methods and sends an error message if one of the methods evaluates to false depending on the method

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: I imported the file in the reader function but an arraylist is created in the main and is filled from the readDictionary function
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: user is asked for input in the string and calls isValidWordLink

 #]=Total Mark out of 100 (Add all the previous marks):100   
 
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordlinksGame {
	public static ArrayList<String> readDictionary() {
		ArrayList<String> dictionary = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader("C:\\Users\\legua\\eclipse-workspace\\Wordlinks\\src\\wordlinks.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				dictionary.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dictionary;
	}

	public static String[] readWordList(String input) {
		String[] inputArray = input.split(",");
		return inputArray;
	}

	public static boolean isUniqueList(String[] inputArray) {
		for (int count = 0; count < inputArray.length; count++) {
			String comparison = inputArray[count];
			int comparisonCounter = count;
			while (comparisonCounter < inputArray.length - 1) {
				if (comparison.equals(inputArray[comparisonCounter + 1])) {
					return false;
				} else {
					comparisonCounter++;
				}
			}
		}
		return true;
	}

	public static boolean isEnglishWord(String word, ArrayList<String> dictionary) {
		if ((Collections.binarySearch(dictionary, word)) >= 0) {
			return true;
		}
		return false;
	}

	public static boolean isDifferentByOne(String word1, String word2) {
		if (word1.length() == word2.length()) {
			int differenceNumber = 0;
			for (int count = 0; count < word1.length(); count++) {
				if (word1.charAt(count) != word2.charAt(count)) {
					differenceNumber++;
				}
				if (differenceNumber > 1) {
					return false;
				}
			}

		}
		return true;
	}

	public static boolean isValidwordLink(String[] input, ArrayList<String> dictionary) {
		if (isUniqueList(input)) {
			for (int count = 0; count < input.length; count++) {
				String word = input[count];
				if (!isEnglishWord(word, dictionary)) {
					System.out.println("Invalid word link, " + word + "is not a valid word");
					return false;
				}
			}
			for (int count = 0; count < input.length-1; count++) {
				String word1 = input[count];
				String word2 = input[count + 1];
				if (!isDifferentByOne(word1, word2)) {
					System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
					return false;
				}
			}
		} else {
			System.out.println("The word list is not unique");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<String> dictionary = readDictionary();
		Scanner skinner = new Scanner(System.in);
		boolean finished = false;
		while (!finished) {
			System.out.println("Enter a comma separated list of words (or an empty list to quit):");
			String inputString = skinner.nextLine();
			inputString = inputString.replaceAll("\\s+","");
			System.out.println(inputString);
			String[] inputArray = readWordList(inputString);
			if (inputString.equals("")) {
				System.out.println("Goodbye");
				finished = true;
			} else if (isValidwordLink(inputArray, dictionary)) {
				System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
			}
		}
	}
}
