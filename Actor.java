import java.util.ArrayList;
import java.util.HashMap;

public class Actor {

    /* basics, dont need to explain this class, holders, getters thats it */

    String name; String nmID;
    ArrayList<String> movies = new ArrayList<>();
    HashMap<Actor, Movie> naboer = new HashMap<>();
    
    public Actor(String navn, String nmID){this.name = navn; this.nmID = nmID;}

    @Override
    public String toString() {
        return this.name;
    }

    void addMovie(String film){
        movies.add(film);
    }

    ArrayList<String> getMovies(){
        return movies;
    }
}
