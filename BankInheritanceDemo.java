/*
Student: John Felt
HW 7 Assignment:

Write a program in which you create a class, a subclass of that class, and a demo class with main. 

The subclass must: 
- override a method inherited from its immediate superclass and use the keywords this and super to make use of both versions of the overridden method
- The class with main should not be a subclass of any class. 
- It is the executive that orchestrates the flow of calls. 
- The main method must show the results of the method calls. 
- The main method is also our "unit test" to see what we defined in the other classes works as we expect.

- Note that I refactored my code from last week so this will look very famaliar. 

Usage Instructions to run the  program:
java BankInheritanceDemo

Sample Output:
Please enter the names of 2 or more banks separated by commas:
Wells Fargo,JP Morgan,Goldman Sachs
Wells Fargo
JP Morgan
Goldman Sachs
The number of banks you entered is: 3
This is the parameterized constructor for the superclass which sets the bankName and other values: Wells Fargo
This is the BankerBonus Class Constructor
You created this number of accounts in the updateAccounts method in the superclass: 599
You created this number of accounts in the overriden version of the updateAccounts method: 649
Wells Fargo Banker Bonus is: Huge!
This is the parameterized constructor for the superclass which sets the bankName and other values: JP Morgan
This is the BankerBonus Class Constructor
You created this number of accounts in the updateAccounts method in the superclass: 348
You created this number of accounts in the overriden version of the updateAccounts method: 398
JP Morgan Banker Bonus is: Small!
This is the parameterized constructor for the superclass which sets the bankName and other values: Goldman Sachs
This is the BankerBonus Class Constructor
You created this number of accounts in the updateAccounts method in the superclass: 111
You created this number of accounts in the overriden version of the updateAccounts method: 161
Goldman Sachs Banker Bonus is: Small!

*/

import java.util.*;

//This defines the BankAccount superclass which is used to store names of banks entered by the user and is used to calculate banker bonuses.
class BankAccount
{
	boolean happyCustomer;
	String bankName;
	String accountType;
	int numOfAccounts;
		
	//Parameterized constructor for the superclass which sets default values of 3 local variables availaible to our subclass.
	BankAccount(String n) 
	{
		this.happyCustomer = true;	
		this.accountType = "real";
		this.bankName = n;
		System.out.println("This is the parameterized constructor for the superclass which sets the bankName and other values: " + this.bankName);
	}
	
	//This is the parameterized method which sets the number of accounts passed to the method based on the random integers.
	void updateAccounts(int z)
    {
		this.numOfAccounts = z;
		System.out.println("You created this number of accounts in the updateAccounts method in the superclass: " + this.numOfAccounts);
    }
	
}

//The BankerBonus class extends the BankAccount superclass and accesses its variables and updateAccounts method.
class BankerBonus extends BankAccount {
	
	String bonusSize; 
	
	//Parameterized constructor for the BankerBonus class.  Uses super to call the constructor of the superclass.
	BankerBonus(String bankName) {

		super(bankName);
		this.bonusSize = "Huge!";
		System.out.println("This is the BankerBonus Class Constructor");
	}
	
		
	//This overrides the method in the super class
	void updateAccounts(int z)
    {
		//Use super to call the hidden version of the the updateAccounts method in the superclass.
		//The subclass version of the method adds another 50 to the amount.
		numOfAccounts = z + 50;  
		System.out.println("You created this number of accounts in the overriden version of the updateAccounts method: " + numOfAccounts);
    }
	
	String getBonus(int z) {
		
		//Call both the overridden version and the subclass version of the updateAccounts method with "super" and "this".
		super.updateAccounts(z);
		this.updateAccounts(z);
		//Demonstrates how you can access variables from the superclass within the subclass.
		if (numOfAccounts > 500 & happyCustomer == true) {
			return this.bonusSize;
		}
		else return this.bonusSize = "Small!";
	}

}


class BankInheritanceDemo
{
    public static void main(String[] args)
    {
		//Instantiates a scanner object

        Scanner myScanner = new Scanner(System.in);

		//Prompts the user to enter the names of banks
        System.out.println("Please enter the names of 2 or more banks separated by commas:");
        String myBanks = myScanner.nextLine();
		
		//Reads the comma-seperated word strings from the scanner input and splits them into an array and prints them
		String[] myBankArray = myBanks.split(",");
		for(String s: myBankArray) {
			
		    System.out.println(s);
		}
		
		//Creates an array of BankAccount objects equal to the number of bank names entered by the user
		BankerBonus myBonus[] = new BankerBonus[myBankArray.length];
		System.out.println("The number of banks you entered is: " + myBonus.length);
		
		//Declares a random number object which will be used to generate random integers
		Random myRandom = new Random();

		int i = 0;
		for(String z: myBankArray) {
			
			//Creates an array of bankerBonus objects which are based on the BankAccount superclass.
			myBonus[i] = new BankerBonus(z.trim());
			//Calls the myBonus method on the objects of the subclass which then calls updateAccounts methods in the super- and subclass.
			//The random int function is used to simulate creating a number of bank accounts used to calculate a "bonus" value.
			System.out.println(myBonus[i].bankName + " Banker Bonus is: " + myBonus[i].getBonus(myRandom.nextInt(1000))); 
			i++;	
		}
	
    }
}