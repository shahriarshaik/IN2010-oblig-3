import java.util.HashMap;

public class Graph { //this class is uesd to represent the graph as to dictionaries
    HashMap<String, Movie> movies; HashMap<String, Actor> actors;

    public Graph(HashMap<String, Movie> movies, HashMap<String, Actor> actors){
        this.movies = movies;
        this.actors = actors;
    }
}
