/*
Student: John Felt
HW 5 Assignment:
- Write a program with two classes:
- a StringDemo class with the main method that calls the methods of your StringManipulator class. 
- a StringManipulator class with two methods:
- The first method calls String methods on an array of type String with at least three (3) different 
- String methods calls INSIDE a for-each loop (see Lecture 3: Program Control Statements#foreachloop)
- The second method calls at least three (3) different String methods on individual Strings that are not in a String array.
- Note: I did not code the optional challeng of using static methods.

Usage Instructions to run the  program:
java StringDemo

Sample Output:
Please enter 5 words separated by commas:
hello,these,strings,are,fun
hello
these
strings
are
fun
This substring method prints the last part of each word: llo
The concat method combines the words as we loop thru them:  hello
This substring method prints the last part of each word: ese
The concat method combines the words as we loop thru them:  hellothese
This substring method prints the last part of each word: ings
The concat method combines the words as we loop thru them:  hellothesestrings
The word - are - contains the first letter in the alphabet.
This substring method prints the last part of each word: re
The concat method combines the words as we loop thru them:  hellothesestringsare
This substring method prints the last part of each word: un
The concat method combines the words as we loop thru them:  hellothesestringsarefun
The first word in Uppercase is: HELLO
A special message for the second word: This word --these-- is my favorite word!!
The third word is: strings
The fourth word is: are
The fifth word is: fun
I've replaced the 5th word with my favorite word from your list: these

*/

import java.util.*;

class StringManipulator
{
	
    void loopTheArray(String[] theWords)
    {
		//This method includes simple examples of 3 string methods contains, substring, and concat
		//For the substring method, we are using the length of the word divided by two as the beginIndex
		String myConcatenation = " ";
		for(String x : theWords)
		{
			if (x.contains("a")) System.out.println("The word - " + x + " - contains the first letter in the alphabet.");
			System.out.println("This substring method prints the last part of each word: " + x.substring((x.length())/2));
			myConcatenation = myConcatenation.concat(x);
	        System.out.println("The concat method combines the words as we loop thru them: " + myConcatenation);
		}
    }
	

	void indexTheArray(String[] theWords)
    {
		//This method includes simple examples of 3 string methods toUppderCase, join, and replace
		//First check to see that the user entered 5 words since the array indexes are hardcoded 0 to 4
		if (theWords.length == 5) {
		System.out.println("The first word in Uppercase is: " + theWords[0].toUpperCase());
		String message = String.join("--", "This word ", theWords[1], " is my favorite word!!");
		System.out.println("A special message for the second word: " + message);
		System.out.println("The third word is: " + theWords[2]);
		System.out.println("The fourth word is: " + theWords[3]);
		System.out.println("The fifth word is: " + theWords[4]);
		String replacedWord = theWords[4].replace(theWords[4], theWords[1]);
		System.out.println("I've replaced the 5th word with my favorite word from your list: " + replacedWord);
		}
		else
		System.out.println("You didn't 5 words so the progam skipped the other string method examples.");
    }
	
}

class StringDemo
{
    public static void main(String[] args)
    {
		//Instantiates 2 objects
		StringManipulator myStringManipulator = new StringManipulator();
        Scanner myScanner = new Scanner(System.in);

		//Prompts the user to enter 5 words to demo various string class methods
        System.out.println("Please enter 5 words separated by commas:");
        String myWords = myScanner.nextLine();
		
		//Reads the comma-seperated word strings from the scanner input and splits them into an array and prints them
		String[] myWordArray = myWords.split(",");
		for(String s: myWordArray)
		   System.out.println(s);
	
		//Calls a method to loop through the array of words and another to access the words by the array index
		myStringManipulator.loopTheArray(myWordArray);
		myStringManipulator.indexTheArray(myWordArray);

    }
}