package cmsc256;

import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;

import java.util.Collections;
import java.util.List;

public class SortingLab extends ActorComparator {

    public static void main (String[] args){

        //create the Bridges object
        Bridges bridges = new Bridges(5, "szarek", "1509239090489");
        DataSource ds = bridges.getDataSource();
        List<ActorMovieIMDB> movieData = null;
        try {
            movieData = ds.getActorMovieIMDBData();
        }
        catch (Exception e) {
            System.out.println("Unable to connect to Bridges.");
        }

        for(int i = 0; i < 5; i++) {
            ActorMovieIMDB entry = movieData.get(i);
            System.out.println("" + i + ". " + entry.getActor()
                    + " was in " + entry.getMovie());
        }

       // ActorComparator ac = new ActorComparator();
        System.out.println("The following actors appeared in the movie, Being John Malkovich:");

        Collections.sort(movieData, new ActorComparator() {
            @Override

            public int compare(ActorMovieIMDB movie1, ActorMovieIMDB movie2){

                return movie1.getActor().compareTo(movie2.getActor());

            }
        });
        for(ActorMovieIMDB a : movieData){
            if (a.getMovie().equalsIgnoreCase("Being_John_Malkovich_(1999)")){
                System.out.println(a.getActor());
            }
        }
    }
}
