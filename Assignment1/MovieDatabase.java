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
    private Movie movie1,movie2,movie3,movie4;
    
    //this value will be used in lieu of a future dynamic array
    private static int numberOfMovies = 4;
    
    
    //This function is used in lieu of reading a future array length
    public int getNumberOfMovies()
    {
        return numberOfMovies;
    }
    
    /**
     * Constructor for objects of class Playlist
     */
    public MovieDatabase()
    {
        
        movie1 = new Movie();
        movie2 = new Movie();
        movie3 = new Movie();
        movie4 = new Movie();
    }
    
    //Methods for getting/setting our private movies in the MovieDatabase
    //------------------------------------------------------------------------------------------
   public void setMovie(Movie newMovie,int movieNumber)
   {
       //catch non-ints
       
       switch  (movieNumber)
       {
          case 0:
                movie1 = newMovie;
                System.out.println("|> Name: " + movie1.getName());
                System.out.println("|> ");
                break;
          case 1:
                movie2 = newMovie;
                System.out.println("|> Name: " + movie1.getName());
                System.out.println("|> Name: " + movie2.getName());
                System.out.println("|> ");

                break;
          case 2:
                movie3 = newMovie;
                System.out.println("|> Name: " + movie1.getName());
                System.out.println("|> Name: " + movie2.getName());
                System.out.println("|> Name: " + movie3.getName());
                System.out.println("|> ");

                break;
          case 3:
                movie4 = newMovie;
                System.out.println("|> Name: " + movie1.getName());
                System.out.println("|> Name: " + movie2.getName());
                System.out.println("|> Name: " + movie3.getName());
                System.out.println("|> Name: " + movie4.getName());
                System.out.println("|> ");

                break;
          default:
                //error
                //msgbox error!
                break;
       }
    }   
    
   public Movie getMovie(int movieNumber)
   {
       //catch non-ints
       
       switch  (movieNumber)
       {
          case 0:
                return movie1;
          case 1:
                return movie2;
          case 2:
                return movie3;
          case 3:
                return movie4;
          default:
                //error
                //msgbox error!
                //we're bastardising this for use in some sanitity checks in Interface.js line 298. Expect this to change when we can do better checks with arrays.
                break;
       }
       // IF we have made it to this park of the code, we're in trouble. We've been unable to return the requested movie, so we'll send a sentinal indicator back (i.e. our sentinalMovieValue)
       Movie sentinalMovieValue;
       sentinalMovieValue = new Movie();
       sentinalMovieValue.setName("Movie Not Found!");
       sentinalMovieValue.setDirector("Sentinal");
       sentinalMovieValue.setFileSize(-1);
       sentinalMovieValue.setDuration(-1);
       return sentinalMovieValue;
    }  
    
    public int getMovieNumber(String movieName)
   {
     for (int i = 0; i < getNumberOfMovies(); i++)
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
       for (int i = 0; i < getNumberOfMovies(); i++) 
       {
           
           switch (i) //switch on our 4 movies, changing index as we go. movie1 & switch could be swapped for movie[i];
           {
               case 0:
                    if (movie1.getDirector().equalsIgnoreCase(movieDirector)){stringToPrint += "|> " + movie1.getName() + "\n";}
                    break;
               case 1:
                    if (movie2.getDirector().equalsIgnoreCase(movieDirector)){stringToPrint += "|> " +  movie2.getName() + "\n";}
                    break;
               case 2:
                    if (movie3.getDirector().equalsIgnoreCase(movieDirector)){stringToPrint += "|> " +  movie3.getName() + "\n";}
                    break;
               case 3:
                    if (movie4.getDirector().equalsIgnoreCase(movieDirector)){stringToPrint += "|> " +  movie4.getName() + "\n";}
                    break;
               default: 
                    stringToPrint += "!!!ERROR!!!";
                    
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
       
       

       switch (index) //switch our our 4 deleting options. This shifts our database to allow for new movies to be added.
       {
           /* for (int i = 0; i < getNumberOfMovies(); i++) will be used later
           { } */
               
                
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
                        
           }
       
    }
       
       
       
   }
//------------------------------------------------------------------------------------------


