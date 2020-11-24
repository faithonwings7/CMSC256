package cmsc256;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import  bridges.data_src_dependent.Song;

/*************************************************
 * File name: SongList
 * Name: Szarek
 * Project number: Project 3
 * Course identifier: CMSC 256, Spring Semester, Section 902
 * Brief description: Taking in data from Bridges API and sorting by
 *  album and then title.
 ************************************************/

public class SongList{

   static List<Song> songData = null;
   SongComparator ac = new SongComparator();

    //Read an artist name as a command line argument.
    // a command line argument is not provided,
    //prompt the user to enter an artist name.
    public static void main(String[] args){

        //Bring in argument at command line

        Scanner scanner = new Scanner(System.in);

        /* Initialize a Bridges connection with your credentials */
        Bridges bridges = new Bridges(0, "szarek", "1509239090489");
        DataSource ds = bridges.getDataSource();

        //Try to connect to Bridges
        try {
            songData = ds.getSongData();
        }
        catch (Exception e) {
            System.out.println("Unable to connect to Bridges.");
        }

        String artist = "";

        //If there's an argument, read in argument.
        // If not prompt user for artist name.
        if(args.length == 1){
            artist = args[0];
        }

        else{
            do{
                System.out.println("No artist name was provided. Please provide artist name: ");
                artist = scanner.nextLine();
            }
            while(artist.isEmpty());
        }

        SongList a = new SongList();

        a.getSongsByArtist(artist);

    }

    //Provide method that returns a formatted list of all the songs by
    // that artist that appear on the playlist, grouped by album and
    // in alphabetical order by song title.
    public String getSongsByArtist(String artist) {
        //New creation of ArrayList to hold songs
        List<Song> songList = new ArrayList<Song>();
        String result = "";

        //Put songs by artist in list
        for(Song a: songData) {
            if (a.getArtist().equalsIgnoreCase(artist)) {
                songList.add(a);
            }
        }
        //If no songs are found by artist return message
        if (songList.isEmpty()){
            System.out.println("There are no songs by this artist in the list.");
        }

        //toString
        for (int i = 0; i < songList.size(); i++){
           result += toString(songList.get(i));
        }

        //Sort using songList and Comparator
        Collections.sort(songList, new SongComparator());
       //Collections.sort(songList, new SongTitleComparator());
        for (int i = 0; i < songList.size(); i++){
            String result2 = "";
            result2 += toString(songList.get(i));
            System.out.println(result2);
        }

        return result;
    }

    public String toString(Song song){
        //Return in correct format
        String result = "Title: " + song.getSongTitle() + "\n"
                + "Artist: " + song.getArtist() + "\n"
                + "Album: " + song.getAlbumTitle() + "\n";
        return result;
    }

}
