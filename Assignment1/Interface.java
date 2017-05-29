/* Name: Interface.java
 * Author: Chris Caelli     Date: 4/03/17
 * Purpose: Acts as interface between our User and all other classes.
 * Use: Launch as a terminal application and follow the prompts
 * Comments: 
 */

import java.util.*;
import java.text.*;

public class Interface {
    
    /*
     * Private Varaibles for encapsulation
     */
    
    private Playlist playlist1,playlist2;	//2 playlists are delcared in interface as required. Would replace with playlistArray[] as needed
    private MovieDatabase database;    		//A single movie database is used
    private boolean exit;					//exit is used to to exit our program's input while loop
    private int movieCount;					//movieCount is a int used to count the number of movies we have
    private int playlistCount;				//playlistCount is a int used to count the number of playlists we have
    
    private Scanner console = new Scanner(System.in);	//the console will mainly be used


    //our main hook for use to start the program.
	public static void main(String[] args)
	{
		Interface intFace = new Interface();
		intFace.run();
	}

	//we run our main 'command loop' to handle user input.
	//This method should control the flow of the program
    //and have all code for accessing the playlists
    //and movie database
	private void run() 
	{
    
    initInterface();	//initialise all our variables we'll need to start
    

    String answer;  //console answer
    boolean error;  //answer error flag
    error = false;
    do {	//Do loop used to get an acceptable answer

            //Take user input on TIO or GUI?
            System.out.println("Would you like to enter GUI or TIO?");
            answer = console.nextLine();
            if(answer.equalsIgnoreCase("GUI"))
            {
                error = false;	//no errors, so we could leave this do loop if/when we return.
                launchGUI();	//launch our GUI-driven command loop
            }else if(answer.equalsIgnoreCase("TIO"))
            {
                error = false;	//no errors, so we could leave this do loop if/when we return.
                launchTIO();	//launch our TIO-driven command loop
            }else
            {
                error = true;	//Error: Not correct format
                System.out.println("I couldn't understand your answer. Please enter again \n");
            }
        }while (error == true);	//loop on "Would you like to enter GUI or TIO?" until we get a good answer

	}

	//init our variables, which is mainly just calling initialising constructors of our classes
	private void initInterface()
	{
	   playlist1 = new Playlist();
	   playlist2 = new Playlist();
	   database = new MovieDatabase();
	   movieCount = 0;	//tells us we have 0 movies at the present.
	}

	//this method will run our user interface via TIO
	private void launchTIO()
	{
	    System.out.println("|-----------------------------------------------------------");
	    System.out.println("|------------------   Movie Assignment 1  ------------------");
	    System.out.println("|-----------------------------------------------------------");
	    System.out.println("|> Type the following commands to");
	    System.out.println("|> navigate the program:");
	    System.out.println("|>");
	    printCommandsString();
	    
	    //after our opening intro, we're ready to dive in.
	    while (!exit)
	    {
	        processUserInput();	// Until we exit, keep processing user input
	    }
	}

	//this method is made for visability 
	private void printCommandsString()
	{
	    System.out.println("|>> Commands:");
	    System.out.println("|> 1  - Help");
	    System.out.println("|> 2  - New Movie");
	    System.out.println("|> 3  - New Playlist");
	    System.out.println("|> 4  - List Movies");
	    System.out.println("|> 5  - List Playlists");
	    System.out.println("|> 6  - List Movies in Specific Playlist");
	    System.out.println("|> 7  - List Movies By Director");
	    System.out.println("|> 8  - Delete From Playlist");
	    System.out.println("|> 9  - Delete Playlist");
	    System.out.println("|> 10 - Delete Movie");
	    System.out.println("|> 11 - Save Movie Database");
	    System.out.println("|> 12 - Open Movie Database");
	    System.out.println("|> 13 - List Movies Under Specific Runtime");
	    System.out.println("|> 14 - Edit Movie");
	    System.out.println("|> 15 - Exit");
	    System.out.print("|> ");
	}

	private void processUserInput()
	{
	    //Take user input by looping through the uglest nested if-else tree you can imagine. I wanted to do the program like this, but I didn't work out how to make a proper command line parser. 
	                String answer;  		//Answer as a string
	                int convertedAnswer; 	//Answer converted to int. Allows us to check number range, sanatise etc.
	                boolean error;  //answer error flag
	                error = false;

	    //start by grabbing a command and checking it
	    do 
	    {                           //get the right answer
	                answer = console.nextLine();

	                //santise
	                try{
	                	convertedAnswer = Integer.parseInt(answer)
	                	error = false;
	                }catch(NumberFormatException ex)
	                {
						//Error: Not correct format
						System.out.println("|");
						System.out.println("|>> I couldn't understand your answer. Please enter again \n");
						System.out.println("|");
						System.out.print("|> ");
						error = true;
						continue; //skips this do loop operation
	                }

	                switch(convertedAnswer)
	                {
	                	case 1:

	                	case 2:

	                	case 3:

	                	case 4:

	                	case 5:

	                	case 6:

	                	case 7:

	                	case 8:

	                	case 9:

	                	case 10:

	                	case 11:

	                	case 12:

	                	case 13:

	                	case 14:

	                	case 15:

	                	default:
	                		
	                }

	                {
	                    System.out.println("|");
	                    error = printCommandsString();
	                    break; //overkill, but I feel safer to have both methods of ending the rotuine
	                }
	                       
	                    }

	    }while (error == true);
	}

 //a method show help text
    private boolean help()
    {
        System.out.println("|");
	    printCommandsString();
	}
    
    //a method show help text
    private void newMovie()
    {
        
    }
    
    //a method show help text
    private void newPlaylist()
    {
        
    }
    
    //a method show help text
    private void listMovies()
    {
        
    }
    
    //a method show help text
    private void listPlaylists()
    {
        
    }
    
    //a method show help text
    private void listSpecificPlaylist()
    {
        
    }
    
    //a method show help text
    private void listByMovieDirector()
    {
        
    }
    
    //a method show help text
    private void deleteFromPlaylist()
    {
        
    }
    
    //a method show help text
    private void deletePlaylist()
    {
        
    }
    
    //a method show help text
    private void deleteMovie()
    {
        
    }
    
    //a method show help text
    private void saveMovieDatabase()
    {
        
    }
    
     //a method show help text
    private void openMovieDatabase()
    {
        
    }
    
     //a method show help text
    private void listMoviesUnderSpecificMinutes()
    {
        
    }
    
     //a method show help text
    private void editMovie()
    {
        
    }
    

	//a method to make our GUI wait artifically for a set number of miliseconds
	private void customWait(int miliSeconds)
	{
	    //editted excert from https://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html
	    try {
	        Thread.sleep(miliSeconds);                 //1000 milliseconds is one second.
	    } catch(InterruptedException ex) {
	        Thread.currentThread().interrupt();
	    }
	}

}