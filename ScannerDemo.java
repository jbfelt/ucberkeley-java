/*
Student: John Felt
HW 2 Assignment:
- prompt the user to input an integer, store the input in a variable
- prompt the user for a second value and store it in a different variable. 
- process those two two variables using both relational and logical operators, such as > (relational) and & or | (logical), 
- show a result to the user. 
- in at least one if condition statement, you must use at least one relational operator and at least one logical operator.

Usage Instructions to run the  program:
java ScannerDemo  [it will prompt you to enter 2 integers]

Sample Output:
We'll evaluate two integers.
Enter an integer.
80
Enter a second integer.
200
The larger integer is: 200

*/

import java.util.*;

class LogicDemo
{
    void evaluateIntegers(int int1, int int2)
    {
	//Demonstrate the use of logical and relational operators
	if (int1 > int2) System.out.println("The larger integer is: " + int1);
	else if (int2 > int1) System.out.println("The larger integer is: " + int2);
	else if (int1 == 0 & int2 == 0) System.out.println("You entered 0 for both integers");
	else System.out.println("Both integers are equal");
    }
}
class ScannerDemo
{
    public static void main(String[] args)
    {
	//Instantiates 2 objects
        LogicDemo myLogicDemo = new LogicDemo();
        Scanner myScanner = new Scanner(System.in);

	//Prompts the user to enter two integers to be evaluated
        System.out.println("We'll evaluate two integers.");
        System.out.println("Enter an integer.");
        int myInteger1 = myScanner.nextInt();
        System.out.println("Enter a second integer.");
        int myInteger2 = myScanner.nextInt();

	//Calls the method to evaluate the input
	myLogicDemo.evaluateIntegers(myInteger1, myInteger2);

    }
}