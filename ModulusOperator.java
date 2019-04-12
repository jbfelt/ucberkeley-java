/*
Student: John Felt
HW 1 Assignment:
- uses the modulus operator % to return the remainder of the division of the left operand by the right operand
- uses the escape sequences \t and \n when printing strings
- makes use of String[] args by showing a result that makes use of two command-line arguments

Usage Instructions to run the  program:
java ModulusOperator 101 10

Sample Output
The first operand you entered is:       101
The second operand you entered is:      10

The modulus of the two numbers is:      1
*/

public class ModulusOperator
{
    public static void main(String[] args) 
    {
        // Prints result of modulus operator %.
	int operand1 = Integer.parseInt(args[0]);
	int operand2 = Integer.parseInt(args[1]);
	int result = operand1 % operand2; 
	System.out.println("The first operand you entered is: \t" + operand1); 
	System.out.println("The second operand you entered is: \t" + operand2 + "\n");      
	System.out.println("The modulus of the two opertands is: \t" + result);
    }
}