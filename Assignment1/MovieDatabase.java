/* Name: Interface.java
 * Author: Chris Caelli     Date: 4/03/17
 * Purpose: Acts as interface between our User and all other classes.
 * Use: Launch as a terminal application and follow the prompts
 * Comments: 
 */

import java.util.*;
import java.text.*;

public class MovieDatabase
{
   //define our 4 movies
    //private Movie movie1,movie2,movie3,movie4;
  private Movie movieArray[];
    
  //this value will be used in lieu of a future dynamic array
  private int logicalSize = 1; //previously called MovieCount 28/05/17  //was static
  private Scanner console; 

    /*
    * Constructor for objects of class Playlist
    */
    public MovieDatabase(Scanner consoleParent)
    {
        console = consoleParent;
        movieArray = new Movie[logicalSize]; //Java can have [0], but it's a no item. We have to init it with "1" to start. 
        movieArray[0] = new Movie();  //better set up the new one, incase we try to read.
    } 
    
    //This function is used in lieu of reading a future array length
    public int getLogicalSize()
    {
        return logicalSize;
    }
    
    
    public void debugPrint(String debugString)
    {
        System.out.println("|DEBUG~$: " + debugString);
    }

    
    //chrisCopy2implimentation from Lecture 9
    private void chrisCopy2implimentation(Movie array1[], Movie array2[], Movie newMovie)
    {
      //Movie[] returnArray = new Movie[array1.length+1];
      for(int i=0; i< array1.length-1; i++)
      {
        array2[i] = array1[i];
        debugPrint(Integer.toString(i) + " " + array1[i].getName());
      }
      array2[array1.length] = newMovie;//new Movie(); 
      //return(returnArray);
    }

    //chrisCopy2implimentation from Lecture 9
    private void chrisCopy2(Movie array1[],Movie array2[])
    {
      for(int i=0; i< array1.length; i++)
      {
        array2[i] = array1[i];
      }
    }



    //Methods for getting/setting our private movies in the MovieDatabase
    //------------------------------------------------------------------------------------------
   public void setMovie(Movie newMovie)//,int movieNumber)
   {
      //adds to array
      Movie tempMovies[] = new Movie[logicalSize+1];
      //tempMovies = chrisCopy2implimentation(movieArray,newMovie);
      chrisCopy2implimentation(movieArray,tempMovies,newMovie);
      movieArray = tempMovies;
      //movieArray = tempMovies;
      String tempstring = movieArray[logicalSize-1].getName();
      String tempstring2 = tempMovies[logicalSize-1].getName();
      logicalSize++;
    }   
    
   public Movie getMovie(int movieNumber)
   {
      return movieArray[movieNumber];
   }

    
    public int getMovieNumber(String movieName)
   {
     for (int i = 0; i < getLogicalSize(); i++)
     {
         if (getMovie(i).getName().equalsIgnoreCase(movieName))
         {
             return i;
         }
     }
     return -1; //error code. -1 indicates an error e.g. movie not found.
   }  
    

    //method to search our 4 movies by director name
    public String getMovieByDirector(String movieDirector)
   {
       //catch non-ints
       String stringToPrint = "";
       for (int i = 0; i < getLogicalSize(); i++) 
       {

            if (movieArray[i].getDirector().equalsIgnoreCase(movieDirector))
            {
                stringToPrint += "|> " + movieArray[i].getName() + "\n";
            }

        }
   
       if (stringToPrint.equals("")) {stringToPrint = "|>> Director not found.";}
           else 
           {
               String tempstring = stringToPrint;
               stringToPrint = "|>> Director found! \n" + movieDirector + " has directed these movies: \n" + tempstring;
           }
       return stringToPrint;
   }
   

   //method to delete
   public void deleteMovie(int index) 
   {
       
       

       /*switch (index) //switch our our 4 deleting options. This shifts our database to allow for new movies to be added.
       {
           /* for (int i = 0; i < getlogicalSize(); i++) will be used later
           { } */
               
                /*
                   case 0:
                        movie1 = movie2;
                        movie2 = movie3;
                        movie3 = movie4;
                        movie4 = new Movie();
                        break;
                   case 1:
                        movie2 = movie3;
                        movie3 = movie4;
                        movie4 = new Movie();
                        break;
                   case 2:
                        movie3 = movie4;
                        movie4 = new Movie();
                        break;
                   case 3:
                        movie4 = new Movie();
                        break;
                   default: 
                       //u died. :(
                       break;
                        */
           }
       
}


