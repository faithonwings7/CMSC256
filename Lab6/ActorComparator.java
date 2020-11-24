package cmsc256;
import java.util.Comparator;
import bridges.connect.Bridges;
import bridges.data_src_dependent.ActorMovieIMDB;
import java.io.Serializable;


public class ActorComparator implements Comparator<ActorMovieIMDB> {
    @Override
    public int compare(ActorMovieIMDB movie1, ActorMovieIMDB movie2) {

            return movie1.getActor().compareTo(movie2.getActor());
    }
}

