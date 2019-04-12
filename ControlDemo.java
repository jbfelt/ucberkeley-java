/*
Student: John Felt
HW 3 Assignment:

Write a single program that does not exceed 120 lines that uses all of the following:
- if ...else if ... else if ... else ladder
- switch with cases
- while loop
- do-while loop
- for loop - the tradition form with three statements in the parentheses
- for each loop that processes an array

This program prompts a user to enter a word and a number between 1 and 3 then calls an "encryption" method
to shift each character in the word by 1, 2, or 3 characters to simulate a simple cipher shift encryption.
It also calls a random number generator to demo the do-while loop but this is unrelated to encryption demo.

Usage Instructions to run the  program:
java ControlDemo

Sample Output:

Please enter a word that you would like to encrypt:
hello
Please enter an encryption level 1, 2 or 3.
1
For Loop will print each character in the source word: h
For Loop will print each character in the source word: e
For Loop will print each character in the source word: l
For Loop will print each character in the source word: l
For Loop will print each character in the source word: o
For Each Loop will print each encrypted character: i
For Each Loop will print each encrypted character: f
For Each Loop will print each encrypted character: m
For Each Loop will print each encrypted character: m
For Each Loop will print each encrypted character: p
The unencrypted word is: hello
The encryption level is: 1
Your fully encrypted word is: ifmmp
You selected the lowest level of encryption: 1
You selected a medium word of 5 characters.
This is a ramdon integter: -1367281314
This is a ramdon integter: 2043975020
This is a ramdon integter: -1924226543
This is a ramdon integter: 1459518181
This is a ramdon integter: 266415571
This is a ramdon integter: 716894381
This is a ramdon integter: -613985076
This is a ramdon integter: 1367791929
This is a ramdon integter: 1861410527
This is a ramdon integter: 1802133720
*/
import java.util.*;
 
 //This class consists of two methods to demonstrate Java's program control statements
 class LoopDemo
{
    void encryptWord(String sourceWord, int sourceLevel)
    {
		char myChar[] = new char[sourceWord.length()];
		
		//If a user enters a number greater than 3, we process the encryption via the while loop, else we use the for loop
		if (sourceLevel > 3) {
			
			System.out.println("You entered a value greater than 3 so we'll encrypt at level 1.");
			
			int j = 0;
			
		    while(j < sourceWord.length())
		    {
		        myChar[j] = sourceWord.charAt(j);
			
		        System.out.println("For Loop will print each character in the source word: " + myChar[j]);
			
		        myChar[j] = (char) (myChar[j] + 1);
			
                j++;
            }
		}
		else
		
		//This loops through an array of chars and shifts each char by a value of 1, 2, or 3 based on what the user entered
		for(int i = 0; i < sourceWord.length(); i++)
		{
			myChar[i] = sourceWord.charAt(i);
			
			System.out.println("For Loop will print each character in the source word: " + myChar[i]);
			
			myChar[i] = (char) (myChar[i] + sourceLevel);
		}
		
		//This demonstrates the for each loop by looping through an arrary of chars and printing them out	
		for(char x : myChar)
		{
		    System.out.println("For Each Loop will print each encrypted character: " + x);
		}
		
		System.out.println("The unencrypted word is: " + sourceWord);
		System.out.println("The encryption level is: " + sourceLevel);
		
		String str = String.valueOf(myChar);
		System.out.println("Your fully encrypted word is: " + str);
		
		//The switch and if else statements are examples of how each can be used to control output
		switch(sourceLevel) {
		    case 1:
			System.out.println("You selected the lowest level of encryption: " + sourceLevel);
			break;
			case 2:
			System.out.println("You selected the middle level of encryption: " + sourceLevel);
			break;
			case 3:
			System.out.println("You selected the highest level encryption: " + sourceLevel);
			break;
		}
		
		if (sourceWord.length() <=3) System.out.println("You selected a short word of " + sourceWord.length() + " characters.");
		else if (sourceWord.length() <= 7) System.out.println("You selected a medium word of " + sourceWord.length() + " characters.");
		else if (sourceWord.length() <= 10) System.out.println("You selected a long word of " + sourceWord.length() + " characters.");
		else System.out.println("You selected a very long word of " + sourceWord.length() + " characters.");
    }
	
	//This is a demo of a do while loop calling the random class to generator 10 integers
	void randomNumLoop() 
	{
	    Random rnd = new Random();
		int count = 0;
		
		do 
		{
			int randomInt = rnd.nextInt();
		    System.out.println("This is a random integter: " + randomInt);
			count++;
		} 
		while (count < 10);
	}
}

public class ControlDemo
{
  public static void main(String[] args)
  {		
	
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a word that you would like to encrypt:");
        String myWord = myScanner.nextLine();
	    System.out.println("Please enter an encryption level 1, 2 or 3.");
        int myEncryptionLevel = myScanner.nextInt();
		
		//Instantiates a class which contains the control statement demos
		LoopDemo myLoopDemo = new LoopDemo();
		
		myLoopDemo.encryptWord(myWord, myEncryptionLevel);
		myLoopDemo.randomNumLoop();
		

  }
}
