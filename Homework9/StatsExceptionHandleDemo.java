/*
Student: John Felt
HW 9 Assignment:

- Submit a program with exception handling that uses:
	- try, catch, and finally
	- try with resources and catch
- The program must catch BOTH of the following:
	- a standard exception provided at...
	- a custom exception that you invent
- Follow the Java convention of naming your Exception class with suffix Exception. 
- For example, OddNumberException or AttemptLimitExceededException.
- The program can be new, or it can be enhanced version of one of your earlier programs.

Usage Instructions to run the  program:
java StatsExceptionHandleDemo

Sample Output:
This program will generate a number of random integers between 0 and 50
to be used to calculate the Standard Deviation for both the full set and a sample set of those integers.
Please enter an integer between 10 and 100 to choose the number of integers to be generated:
10
This loop will print out each random integer stored in myInteger array: 0 value is: 10
This loop will print out each random integer stored in myInteger array: 1 value is: 33
This loop will print out each random integer stored in myInteger array: 2 value is: 7
This loop will print out each random integer stored in myInteger array: 3 value is: 31
This loop will print out each random integer stored in myInteger array: 4 value is: 37
This loop will print out each random integer stored in myInteger array: 5 value is: 4
This loop will print out each random integer stored in myInteger array: 6 value is: 43
This loop will print out each random integer stored in myInteger array: 7 value is: 1
This loop will print out each random integer stored in myInteger array: 8 value is: 40
This loop will print out each random integer stored in myInteger array: 9 value is: 10

The Average of the 10 random integers between 0 and 50 is: 21.6
The Standard Deviation of the integers in this dataset is: 15.71114254279427
Note: Any number in the dataset greater than 37.31114254279427 exceeds 1 Standard Deviation per the Normal Curve

The number 43 exceeds 1 Standard Deviation per the normal curve and should be reviewed for accuracy.
Please review the exception report 'numbers.txt'
The number 40 exceeds 1 Standard Deviation per the normal curve and should be reviewed for accuracy.
Please review the exception report 'numbers.txt'

*/
import java.util.*;
import java.io.*;

public class StatsExceptionHandleDemo
{
  public static void main(String[] args)
  {		
  		//Instantiates a Scanner class to accept user input
        Scanner myScanner = new Scanner(System.in);
	    
		System.out.println("This program will generate a number of random integers between 0 and 50 ");
	    System.out.println("to be used to calculate the Standard Deviation for both the full set and a sample set of those integers.");
		System.out.println("Please enter an integer between 10 and 100 to choose the number of integers to be generated:");       

		int userCount = myScanner.nextInt();

		//Creates an array of integers with a length equal the number entered by the user.
		int myIntegers[] = new int[userCount]; 
	
		Random myRandom = new Random();	

		for(int i = 0; i < myIntegers.length; i++)
		{
			//Generates a random integer between 0 and 50 and stores it in an array and prints each number
			myIntegers[i] = myRandom.nextInt(50);
		    System.out.println("This loop will print out each random integer stored in myInteger array: " + i + " value is: " + myIntegers[i]);
		}
		
		System.out.println();

		//Instantiate a new object of the Standard Deviation (SD) class to calculate the SD of the random number dataset.
		PopulationSD myPopSD = new PopulationSD();
	
		double myAverage = 0;
		double mySD = 0;
		double oneSD = 0;
		
		//Calls the methods to calculate the avearage and standard deviation of the dataset
		myAverage = myPopSD.calculateAverage(myIntegers);
		mySD = myPopSD.calculateSD(myIntegers);
		//Defines One Standard Deviation per the Normal Curve used in statistics
		oneSD = myAverage + mySD;
		
		System.out.println("The Average of the " + myIntegers.length + " random integers between 0 and 50 is: " + myAverage);
		System.out.println("The Standard Deviation of the integers in this dataset is: " + mySD);
		System.out.println("Note: Any number in the dataset greater than " + oneSD + " exceeds 1 Standard Deviation per the Normal Curve");
		System.out.println();

		//An exception is thrown when the loop of the array of integers encounters a Standard Deviation greater than 1.
		//Creates an output file in binary format of integers with an SD > 1 which allows the end-user to review them offline.
		//These numbers are handled as exceptions so the end-user could review them once the program has completed execution.
		//Note: I included the logic to open the fileoutputstream in main but I wonder if it would have made more sense to include
		//this logic in my exception handling class.  I didn't have time this week to explore this option.
		try(FileOutputStream fout = new FileOutputStream("numbers.txt"))
		{	
	        for(int i = 0; i < myIntegers.length; i++)
		    {
				try
				{
					//This condition identifies those integers greater than 1 SD above the average
			    	if ((myIntegers[i] - myAverage) / mySD > 1)
				    {
					    fout.write((char) myIntegers[i]);

					    throw new StandardDeviationException(myIntegers[i]);
				    }
				}
				catch (StandardDeviationException e)
				{
					System.out.println("Please review the exception report 'numbers.txt'");
				}
			} 
		}
		catch(IOException exc) 
		{
			System.out.println("Error writing the output file 'numbers.txt'");
		}
  }
}
