package cmsc256;
import java.util.Comparator;
import  bridges.data_src_dependent.Song;
import java.io.Serializable;

/******************************************
 * File name: SongList
 * Name: Szarek
 * Project number: Project 3
 * Course identifier: CMSC 256, Spring Semester, Section 902
 * Brief description: Taking in data from Bridges API and sorting by
 *  album and then title.
 ************************************************/

public class SongComparator implements Comparator<Song> {

    @Override
    public int compare(Song song1, Song song2) {

                //if Album title is null, compare Song titles
        if (song1.getAlbumTitle().equals(null) || song2.getAlbumTitle().equals(null)){

            return song1.getSongTitle().compareTo(song2.getSongTitle());
        }

        //If Album titles are the same, compare song titles
        if (song1.getAlbumTitle().compareTo(song2.getAlbumTitle()) == 0){

            return song1.getSongTitle().compareTo(song2.getSongTitle());
        }
        else {
            //else compare Album Titles
            return song1.getAlbumTitle().compareTo(song2.getAlbumTitle());
        }
    }

}








