/*
Student: John Felt
HW 10 Assignment:
- Write a program that makes use of the functionality that the java.io package provides. 
- You can do a minimal usage of the package, or, if you want, something a bit more complex. 
- For example, your application might:
 - write the characters the user enters at the keyboard to a file named keyboardInput.txt 
 - save a stack trace into a log file that is appendable
 - read a file, modify that file, and save the newly-modified file to the file system
 - compare two files and indicate the first location where the two files differ
 - capture the source code of a web page URL

Note about the logic: 
- This program uses the URL class in java.net and various java.io classes to read content from a URL and write it to an output file
- Note this logic will only work with this specific URL since it's hardcoded to read these HTML elements.

Usage Instructions to run the  program:
java ShakespeareURLReaderDemo

Sample Output (also generates and output text file):
C:\UCBerkeleyJava>java ShakespeareURLReaderDemo

cxlvii. my love is as a fever, longing still

cxlviii. o me, what eyes hath love put in my head,

cxlix. canst thou, o cruel! say i love thee not,

cli. love is too young to know what conscience is;

cliv. the little love-god lying once asleep

The number of Shakespeare's sonnets listed on this website is: 154
27 of 154 Shakespeare's sonnets include the word 'love' in the title.

*/
import java.net.*;
import java.io.*;
 
public class ShakespeareURLReaderDemo
{
    public static void main(String[] args) throws Exception
    {
		String inputLine;
		String myInputLine = " ";
		int sonnetCount = 0;
		int loveCount = 0;
		
		//Instantiates a new URL object and calls the openStream methode to return the contents of the site into an input stream reader
        URL myURL = new URL("http://shakespeare.mit.edu/Poetry/sonnets.html");
 
	    try (BufferedReader fin = new BufferedReader(new InputStreamReader(myURL.openStream())))
	    {
			//Loops through the input stream and looks for only those HTML tags within <DT> to get the content we want (list of sonnets)
			//while ignoring the content within any other HTML tage
            while ((inputLine = fin.readLine()) != null)
            {
			    if(inputLine.contains("<DT>")) {
				
					System.out.println(inputLine);
			        myInputLine += inputLine;
				    sonnetCount++;
			    }
        }
        fin.close();
	    }
	    catch(IOException exc) 
	    {
			System.out.println("Error accessing URL");
		}
	    //Create a new arrary of strings to store each line of the content from the HTML DT tag.
		//Trim each line, make it lower case and split each string by looking for the HTML delimiter >
		String[] myArray = myInputLine.trim().toLowerCase().split(">");
		
		System.out.println("Now we'll print only those sonnet's with the word 'love' in the title:" + "\n");

		//Create a new file output stream object and wrap it in a print stream object so we can write to the output file.
		try (PrintStream fout = new PrintStream(new FileOutputStream("Shakespeare.txt")))
		{
			
			//Loop through the arrary, which  contains each line of the HTML <DT> tag and only select those line with the word "love"
			//The s.lenght()-3 logic is used to strip off the end of the HTML tag from each line. 
			//We print each line and write it it to the output file.
	 	    for(String s: myArray)
			
	 		    if(!s.startsWith("<") & s.contains("love")) 
				{
				    System.out.println(s.substring(0, (s.length()-3)) + "\n");
				    fout.print(s.substring(0, (s.length()-3)) + "\n");
				    loveCount++;
			    }
		fout.close();
		}
		catch(IOException exc) 
		{
			System.out.println("Error writing the output file 'Shakespeare.txt'");
		}
			
		System.out.println("The number of Shakespeare's sonnets listed on this website is: " + sonnetCount);
		System.out.println(loveCount + " of Shakespeare's " + sonnetCount + " sonnets include the word 'love' in the title.");
		
    }

}