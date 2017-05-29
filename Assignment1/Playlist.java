
/* Name: Playlist.java
 * Author: Chris Caelli     Date: 19/04/17
 * Purpose: To hold exactly 3 movies unless the user deletes specific movies.
 * Use: Basically a mini MovieDatabase. When I started out it was it's own specific design, but in retrospect I would have just inherited the MovieDatabase and all it's functions. Or visa versa, if MovieDatabase required more stuff. 
 * Comments: Will require a rewrite depending on what we're allowed to use for Assignment
 */

public class Playlist extends MovieDatabase
{

    //private Movie movieArray[]; //movie1,movie2,movie3; //we hold 3 seperate instances of the movies from the movie database. This was in lieu of using pointers, due to some technical difficulties
    private float totalDuration;
    private int totalSize;
    private String playlistName;
    //private int logicalSize = 0; //previously called MovieCount 28/05/17  //was static
    
    /**
     * Constructor for objects of class Playlist
     */
    public Playlist(String tempName)
    {
        //Made the consturctor call the movie constructor, so it prevents "empty" playlists from exisiting.
        playlistName = tempName;
        movieArray = new Movie[logicalSize];
        //generates our totalDUration & totalSize; Again, this is important to make sure that whenever or whereever we create a Playlist we're making a valid playlist.
        //initPlaylist();
    }

    public String getPlaylistName()
    {
      return playlistName;
    }
 

  public void addMovieToPlaylist(Movie newMovie)
  {
    setMovie(newMovie);  //inherited from MovieDatabase
    initPlaylist();     //update playlist stats
  }


    private void initPlaylist()
    {
        createTotalDuration();
        createTotalSize();
    }
    
    private void createTotalDuration()
    {
        totalDuration = movie1.getDuration() + movie2.getDuration() + movie3.getDuration();
    }
    public float getTotalDuration()
    {
        return totalDuration;
    }
        
    private void createTotalSize()
    {
        totalSize = movie1.getFileSize() + movie2.getFileSize() + movie3.getFileSize();
    }
    public float getTotalSize()
    {
        return totalSize;
    }
    
    //-----------------------------------------------------------------------------------------------------------
}
