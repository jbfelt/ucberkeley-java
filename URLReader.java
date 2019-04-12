import java.net.*;
import java.io.*;
 
public class URLReader
{
    public static void main(String[] args) throws Exception
    {
		
		String inputLine;
		String myInputLine = " ";
		int sonnetCount = 0;
		int loveCount = 0;
		
        URL myURL = new URL("http://shakespeare.mit.edu/Poetry/sonnets.html");
 
       // BufferedReader fin = new BufferedReader(new InputStreamReader(myURL.openStream()));
	    try (BufferedReader fin = new BufferedReader(new InputStreamReader(myURL.openStream())))
	    {
		
        while ((inputLine = fin.readLine()) != null)
        {
			if(inputLine.contains("<DT>")) {
				
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

		String[] myArray = myInputLine.trim().toLowerCase().split(">");

		try (PrintStream fout = new PrintStream(new FileOutputStream("Shakespeare.txt")))
		{
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
		System.out.println(loveCount + " of " + sonnetCount + " Shakespeare's sonnets include the word 'love' in the title.");
		
    }

}