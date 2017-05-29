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
    
    private Playlist playlist1,playlist2;   //2 playlists are delcared in interface as required. Would replace with playlistArray[] as needed
    private MovieDatabase database;         //A single movie database is used
    private boolean exit;                   //exit is used to to exit our program's input while loop
    private int movieCount;                 //movieCount is a int used to count the number of movies we have
    private int playlistCount;              //playlistCount is a int used to count the number of playlists we have
    
    private Scanner console = new Scanner(System.in);   //the console will mainly be used


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
        initInterface();    //initialise all our variables we'll need to start
        launchTIO();    //launch our TIO-driven command loop
    }

    //init our variables, which is mainly just calling initialising constructors of our classes
    private void initInterface()
    {
       playlist1 = new Playlist();
       playlist2 = new Playlist();
       database = new MovieDatabase(console);
       movieCount = 0;  //tells us we have 0 movies at the present.
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
            processUserInput(); // Until we exit, keep processing user input
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
                    String answer;          //Answer as a string
                    int convertedAnswer;    //Answer converted to int. Allows us to check number range, sanatise etc.
                    boolean error;  //answer error flag
                    error = false;

        //start by grabbing a command and checking it
        do 
        {                           //get the right answer
                    answer = console.nextLine();

                    //santise
                    try{
                        convertedAnswer = Integer.parseInt(answer);
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
                        case 1: help();break; 

                        case 2: newMovie();break; 

                        case 3: newPlaylist();break; 

                        case 4: listMovies();break; 

                        case 5: listPlaylists();break; 

                        case 6: listMoviesInSpecificPlaylist();break; 

                        case 7: listByMovieDirector();break; 

                        case 8: deleteFromPlaylist();break; 

                        case 9: deletePlaylist();break; 

                        case 10: deleteMovie();break; 

                        case 11: saveMovieDatabase();break; 

                        case 12: openMovieDatabase();break; 

                        case 13: listMoviesUnderSpecificRuntime();break; 

                        case 14: editMovie();break; 

                        case 15: exit();break; 

                        default: 
                            //Error: Not recognised command
                            System.out.println("|");
                                System.out.println("|>> Not a recognised command. Please enter again \n");
                            System.out.println("|");
                            System.out.print("|> ");
                            error = true;
                    }
        }while (error == true);
    }

 //a method show help text
    private void help()
    {
        System.out.println("|");
        printCommandsString();
    }
    

    //a method show help text
    private void newMovie()
    {
        String tempName,tempDirector;
        int tempFileSize;
        float tempDuration;
        //set up a temp. movie variable, for us to pass to the database to store.
        Movie tempMovie;
	    tempMovie = new Movie();
	                    
        //enter Name
        System.out.println("|>> Enter Name of Movie");
        System.out.println("|");
        System.out.print("|> ");
        tempName = console.nextLine();

        //enter Director    
        System.out.println("|>> Enter Name of Director");
        System.out.println("|");
        System.out.print("|> ");    
        tempDirector = console.nextLine();

        //enter FileSize
        System.out.println("|>> Enter FileSize of Movie (e.g. 512 for 512mb)");
        System.out.println("|");
        System.out.print("|> ");
        tempFileSize = console.nextInt();

        //enter Duration
        System.out.println("|>> Enter Duration of Movie (e.g. 144.2 for 144.2 minutes))");
        System.out.println("|");
        System.out.print("|> ");
        tempDuration = console.nextFloat();

        tempMovie.setName(tempName);
        tempMovie.setDirector(tempDirector);
        tempMovie.setFileSize(tempFileSize);
        tempMovie.setDuration(tempDuration);

        if (database.getMovieNumber(tempName) == -1) //time to check if we have a duplicate movie by name: (Note: An assumption is made that all other meta data could theoretically be the same as a different, unique movie. We also butcher our "getMovieNumber()" method to check)
        {
            System.out.println("|>> New Movie Made!");
            System.out.println("|> Name: " + tempMovie.getName());
            System.out.println("|> Director: " + tempMovie.getDirector());
            System.out.println("|> FileSize: " + tempMovie.getFileSize());
            System.out.println("|> Duration: " + tempMovie.getDuration());
            //System.out.println("|> movieCount:" + movieCount);
        database.setMovie(tempMovie);//,movieCount);
        //null everything, I think we could have a unforseen issues otherwise.
        tempName = "";
        tempDirector = "";
        tempFileSize = -2;
        tempDuration = -2;
        tempMovie = new Movie();

        movieCount++; //we're 0 indexed for our movies 0-3. 

        System.out.println("|");
        System.out.print("|>");
        }
    }
    
    //a method show help text
    private void newPlaylist()
    {
        
    }
    
    //a method show help text
    private void listMovies()
    {
    	System.out.println("|>> Movies in Database:");
        System.out.println("|");
        for (int i = 0; i < database.getLogicalSize(); i++) 
        {
        	System.out.println("|> " + database.getMovie(i).getName());
        }
        System.out.print("|> ");
    }
    
    //a method show help text
    private void listPlaylists()
    {
        
    }
    
    //a method show help text
    private void listMoviesInSpecificPlaylist()
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
    private void listMoviesUnderSpecificRuntime()
    {
        
    }
    
     //a method show help text
    private void editMovie()
    {
        
    }
    
    //a method show help text
    private void exit()
    {
        exit = true;
        System.out.println("|");
        System.out.print("|>> Exiting"); customWait(330); System.out.print("."); customWait(330); System.out.print("."); customWait(330); System.out.print(".");
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