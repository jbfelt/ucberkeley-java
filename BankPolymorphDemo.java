/*
Student: John Felt
HW 6 Assignment:
-a non-default constructor that is parameterless
- an overloaded constructor that you define
- an overloaded method that you define
- Additional requirements:
- The class name is a noun that begins with a capital letter, such as Account, and the method name is a verb, such as getName or calculateInterest.
- The class with main must call a constructor and both overloads of the method.
- Include a constructor that calls another constructor using the keyword this().
- Remember that this() to call the target constructor must be the first call when chaining constructors.
- Place the parameterless constructor before the parameterized constructor. (simple, then more complex)
- If you have a parameterless method, place it before the parameterized method. (simple, then more complex)
- At least one of the formal parameters of a constructor overload or a method overload must be an object (as opposed to a primitive)
- At least one method must return an object (as opposed to being void or returning a primitive) - see Return type can be an object
- Optionally, include a method that calls a constructor

Usage Instructions to run the  program:
java BankPolymorphDemo

Sample Output:
Please enter the names of 2 or more banks separated by commas:
Wells Fargo,JP Morgan,Gold Sacks
Wells Fargo
JP Morgan
Gold Sacks
The number of banks you entered is: 3
This is the parameterless constructor for the CustomerAccount class: true
The parameterless constructor sets the happy customer flag to: true
The parameterless construct sets the account type to: real
This is the parameterized construct for Customer Account which sets the bankName: Wells Fargo
If the bank name is Wells Fargo, these accounts are: fake
Is the customer still happy? false
You created this number of accounts: 279
This is the parameterless constructor for the CustomerAccount class: true
The parameterless constructor sets the happy customer flag to: true
The parameterless construct sets the account type to: real
This is the parameterized construct for Customer Account which sets the bankName: JP Morgan
These accounts are real.
You created this number of accounts: 281
This is the parameterless constructor for the CustomerAccount class: true
The parameterless constructor sets the happy customer flag to: true
The parameterless construct sets the account type to: real
This is the parameterized construct for Customer Account which sets the bankName: Gold Sacks
These accounts are real.
You created this number of accounts: 510
This is the BankerBonus Class Constructor
The bonus for employees of Wells Fargo is: Small!
This is the BankerBonus Class Constructor
The bonus for employees of JP Morgan is: Small!
This is the BankerBonus Class Constructor
The bonus for employees of Gold Sacks is: Huge!
*/

import java.util.*;

//This defines the Customer Account class wich is used to store names of banks entered by the user and is used to calculate banker bonuses.
class CustomerAccount
{
	boolean happyCustomer;
	String bankName;
	String accountType;
	int numOfAccounts;
	int randomNumberBonus;
		
	CustomerAccount() 
	{
		this.happyCustomer = true;	
		this.accountType = "real";	
		System.out.println("This is the parameterless constructor for the CustomerAccount class: " + this.happyCustomer);
		System.out.println("The parameterless constructor sets the happy customer flag to: " + this.happyCustomer);
		System.out.println("The parameterless construct sets the account type to: " + this.accountType);
	}
	
	CustomerAccount(String n) 
	{
		this();
		this.bankName = n;
		System.out.println("This is the parameterized construct for Customer Account which sets the bankName: " + this.bankName);
		
	}
	
    void updateAccounts()
    {
		//This method checks to see if the bank is "Wells Fargo". If it is, the account type is set to "fake".
		if (this.bankName.equals("Wells Fargo")) {
		  this.accountType = "fake";
		  this.happyCustomer = false;
		  System.out.println("If the bank name is Wells Fargo, these accounts are: " + this.accountType);
		  System.out.println("Is the customer still happy? " + this.happyCustomer);
		}
		else
		    System.out.println("These accounts are real.");
    }
	
	//This is the parameterized method which sets the number of accounts passed to the method based on the random integers.
	void updateAccounts(int z)
    {
		this.numOfAccounts = z;
		System.out.println("You created this number of accounts: " + this.numOfAccounts);
    }
	
}

//The BankerBonus class stores the BonusSize which is determined by the receiving the CustomerAccount object and comparing
//the value of the number of accounts (from the randon int generator) and the happy customer flag.  The return type is a String.
class BankerBonus {
	
	String bonusSize; 
	
	BankerBonus() {
		
		this.bonusSize = "Huge!";
		System.out.println("This is the BankerBonus Class Constructor");
	}
	
	String getBonus(CustomerAccount myCA) {
		
		if (myCA.numOfAccounts >= 500 & myCA.happyCustomer == true) {

			return this.bonusSize;
		}
		else return this.bonusSize = "Small!";
	}
}


class BankPolymorphDemo
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
		
		//Creates an array of Customer Account objects equal to the number of bank names entered by the user
		//Loop through the array and call the updateAccounts methods
		CustomerAccount myAccounts[] = new CustomerAccount[myBankArray.length];
		System.out.println("The number of banks you entered is: " + myAccounts.length);
		
		//Declares a random number object which will be used to generate random integers
		Random myRandom = new Random();

		int i = 0;
		for(String z: myBankArray) {
			
			myAccounts[i] = new CustomerAccount(z.trim());  //trim leading and trailing spaces from the bank name
			//This first calls the parameterless method updateAccount and then the overloaded method for each object in the array
			myAccounts[i].updateAccounts();
			myAccounts[i].updateAccounts(myRandom.nextInt(1000)); //Generates a random integer between 0 and 1000
			i++;	
		}

		
		//This creates an array of BankerBonus objects equal to the number of bank names entered by the user
		BankerBonus myBonus[] = new BankerBonus[myBankArray.length];
		
		int n = 0;
		for(String z: myBankArray) {
			
			myBonus[n] = new BankerBonus();
			//This demonstrates the method call with an object as an argument.  We pass a Customer Accout object to the BankerBonus object
			//to calcuate a "bonus" based on the number of accounts generated by the random integer value for each bank.  
			//The Bonus Size of type String is returned to the calling method and displayed for each bank.
			System.out.println("The bonus for employees of " + myAccounts[n].bankName + " is: " + myBonus[n].getBonus(myAccounts[n]));
			n++;
		}	
    }
}