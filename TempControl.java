/*
Student: John Felt
HW 4 Assignment:

Write one .java file that contains three classes. 
The following names for class, fields, and methods are examples. You can create any scenario you want.
two classes, such as Cat and Dog, that each define at least one
parameterized constructor
parameterized method
instance variable, also known as a field
class variable, also known as a static field
the third class, ClassDesignDemo.java, has the main method that instantiates the two classes by calling the parameterized constructor of each class.
For example, Dog fido = new Dog("watchdog");
The main method then calls the parameterized method on each of the  newly created objects, such as fido and tibby.
For example, fido.doWork("wag tail at robbers");
The main method must reference both:
the instance variable (on an instance)
the static field (using the class name plus the dot operator).
For example, Dog.numberOfLegs can be a static variable and fido.weight can be an instance variable.

This program allows a user to convert temperatures between the Celsius and Fahrenheit scales.

Usage Instructions to run the program:
java TempControl //and then enter F press enter then type 212

Sample Output:

Please enter a temperature scale that you would like to convert to. Enter C for Celsius and F for Fahrenheit:
F
Please enter a temperature (as an integer) that you would like to convert:
212
The boiling point of water in degrees Fahrenheit is: 212
The freezing point of water in degress Fahrenheit is: 32
The boiling point of water in degrees Celsius is: 100
The freezing point of water in degrees Celsius is: 0
You wish to convert 212 degrees from Celsius to F
This prints the string popluated in the Fahrenheit constructor: The Fahrenheit Class
This is the final converted temp calculated in the Fahrenheit class: 413
This temp will boil water!

*/
import java.util.*;
 
//This class contains two static variables and one method to convert from one temperature scale to another.
class FahrenheitTemperature
{   
    static int boilingPointF = 212;
	static int freezingPointF = 32;

	//Declares two instance variables
	String convertType;
	int finalTemp;
	
	//This is the parameterized constructor
	FahrenheitTemperature(String t)
    {
	    convertType = t;
    }
	
    void convertCelsiustoFahrenheit(String sourceScale, int sourceTemp)
    {
		System.out.println("You wish to convert " + sourceTemp + " degrees from Celsius to " + sourceScale);
		finalTemp = (sourceTemp * 9/5) + 32;
    }
}

//This class is similar but includes different static values and calculation formula.
class CelsiusTemperature
{
	static int boilingPointC = 100;
	static int freezingPointC = 0;
	
	String convertType;
	int finalTemp;
	
	CelsiusTemperature(String t)
    {
	    convertType = t;
    }
	
    void convertFahrenheittoCelsius(String sourceScale, int sourceTemp)
    {
		System.out.println("You wish to convert " + sourceTemp + " degrees from Fahrenheit to " + sourceScale);
		finalTemp = (sourceTemp - 32) * 5/9;
    }

}

public class TempControl
{
  public static void main(String[] args)
  {		
		//Instantiates a Scanner class to accept two user input values.
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a temperature scale that you would like to convert to. Enter C for Celsius and F for Fahrenheit:");
        String myScale = myScanner.nextLine();
	    System.out.println("Please enter a temperature (as an integer) that you would like to convert:");
        int myTemp = myScanner.nextInt();
		
		//Demonstrate how to access a static variable without having to instantiate it.
		System.out.println("The boiling point of water in degrees Fahrenheit is: " + FahrenheitTemperature.boilingPointF);
		System.out.println("The freezing point of water in degress Fahrenheit is: " + FahrenheitTemperature.freezingPointF);
		System.out.println("The boiling point of water in degrees Celsius is: " + CelsiusTemperature.boilingPointC);
		System.out.println("The freezing point of water in degrees Celsius is: " + CelsiusTemperature.freezingPointC);
		
	    myScale = myScale.toUpperCase();
	
		switch (myScale) {
			case "F":
			//Instatiates a new object from a class and demontrates the parameterized contstructor
		    FahrenheitTemperature myFTemp = new FahrenheitTemperature("The Fahrenheit Class");
			//Calls a method on the newly created object and passes two arguments
			myFTemp.convertCelsiustoFahrenheit(myScale, myTemp);
		    System.out.println("This prints the string popluated in the Fahrenheit constructor: " + myFTemp.convertType);
		    System.out.println("This is the final converted temp calculated in the Fahrenheit class: " + myFTemp.finalTemp);
			//Further demonstrates how to access class and instance variables.
		    if (myFTemp.finalTemp >= FahrenheitTemperature.boilingPointF) System.out.println("This temp will boil water!");
		    else if (myFTemp.finalTemp <= FahrenheitTemperature.freezingPointF) System.out.println("This temp will freeze water!");
		    break;
			case "C":
			//Instatiates a new object from a class and demontrates the parameterized contstructor
			CelsiusTemperature myCTemp = new CelsiusTemperature("The Celsius Class");
			//Calls a method on the newly created object and passes two arguments
			myCTemp.convertFahrenheittoCelsius(myScale, myTemp);
			System.out.println("This prints the string popluated in the Celsius constructor: " + myCTemp.convertType);
		    System.out.println("This is the final converted temp calculated in the Celsius class: " + myCTemp.finalTemp);
			//Further demonstrates how to access class and instance variables.
			if (myCTemp.finalTemp >= CelsiusTemperature.boilingPointC) System.out.println("This temp will boil water!");
		    else if (myCTemp.finalTemp <= CelsiusTemperature.freezingPointC) System.out.println("This temp will freeze water!");
			break;
		}
  }
}
