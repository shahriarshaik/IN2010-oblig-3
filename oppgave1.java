import java.util.HashMap;
import java.util.ArrayList;

public class oppgave1 {
    HashMap<String, Movie> movies;
    HashMap<String, Actor> actors;
    Graph graph;
    

    public oppgave1(Graph graph){
        this.graph = graph;
    }

    long run(){
        System.out.println("\nOppgave 1 start");
        System.out.println("----------------------------------------------------------------");
        long start1 = System.nanoTime();
        System.out.println(count(graph));
        long end1 = System.nanoTime();
        long duration = (end1 - start1);  //divide by 1000000 to get milliseconds.
        return duration;
    }

    String count(Graph graph){
        movies = graph.movies; actors = graph.actors;
        int noder = actors.size();
        int kanter = 0;

        for(String film : movies.keySet()){ // function that counts the edges, for loops every cast, gets the cast size, and uses a mathematical function to calculate the edges
            ArrayList<String> MovieArr = movies.get(film).cast; //
            kanter = kanter + (MovieArr.size()*(MovieArr.size() - 1)/2);
        }

        return "noder: " + noder + "\nkanter: " + kanter;
    }
}
