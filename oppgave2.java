import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Queue;

public class oppgave2 {
    HashMap<String, Movie> movies; 
    HashMap<String, Actor> actors;
    Graph graph;
    
    public oppgave2(Graph graph){
        this.graph = graph;
    }

    void run(){
        ArrayList<Holder> a, b, c, d, e;
        System.out.println("oppgave 2 start");
        System.out.println("----------------------------------------------------------------");
        long startTime = System.nanoTime(); //starts taking the time
        a = shortestPathBetween(shortestPath(graph, "nm2255973"), "nm0000460");
        b = shortestPathBetween(shortestPath(graph, "nm0424060"), "nm0000243");
        c = shortestPathBetween(shortestPath(graph, "nm4689420"), "nm0000365");
        d = shortestPathBetween(shortestPath(graph, "nm0000288"), "nm0001401");
        e = shortestPathBetween(shortestPath(graph, "nm0031483"), "nm0931324");
        long endTime = System.nanoTime(); //stops the timer
        
        //printing
        thePrint(graph, a.get(0), a); thePrint(graph, b.get(0), b); thePrint(graph, c.get(0), c); thePrint(graph, d.get(0), d); thePrint(graph, e.get(0), e);
        System.out.println("----------------------------------------------------------------");
        
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("tiden det tok for å finne korteste sti: " + duration/1000000 + " ms");
        System.out.println("Oppgave 2 slutt\n\n");
        
    }

    HashMap<String, Holder> shortestPath(Graph graph, String startActor){
        movies = graph.movies; actors = graph.actors; //grabs the Hashmaps from the Graph
        HashMap<String, Holder>  parent = new HashMap<>(); parent.put(startActor, new Holder(null, null)); //Hashmap for making actors point at eachother through movies
        Queue<String> queue = new ArrayDeque<>(); queue.add(startActor);
        while(!queue.isEmpty()){
            String parentActor = queue.poll(); //removes and gets the top one from the queue
            for(String movie : actors.get(parentActor).getMovies()){ // loops all the parentActors movies
                for(String actor : movies.get(movie).getCast()){ // for all ov those movies loops all the actors that are inn that movie
                    /*
                    if(actor.equals(null)){
                        parent.put(actor, new Holder(s, movie));
                        return parent;
                    }
                    */
                    if(!parent.containsKey(actor)){ //if its allready in the parent Hashmap it wil skip it, otherwise it will add it to the map with a referance of the parent actor and what movie the came from
                        parent.put(actor, new Holder(parentActor, movie));
                        queue.add(actor);
                    }
                }
            }
        }
        return parent;
    }

    ArrayList<Holder> shortestPathBetween(HashMap<String, Holder> parent, String endActor){
        Holder v = new Holder(endActor, null); //made a pointer
        ArrayList<Holder> path = new ArrayList<>();
        if(!parent.containsKey(endActor)){ //just an if check in case 
            return path;
        }
        while(v.get(0) != null){ // while there is a parentActor
            path.add(v); //add the pointer to the path
            v = parent.get(v.get(0)); // uses the actor in the pointer as a parent to get the next parent
        }
        Collections.reverse(path); return path; // reverse and return it
    }

    void thePrint(Graph graph, Holder start, ArrayList<Holder> path){ // the function that takes the path from shortestPathBetween and prints the path
        movies = graph.movies; actors = graph.actors;
        System.out.print("\n" + actors.get(start.get(0)).name+ " ");
        for (int i = 0; i < path.size()-1; i++) {
            String title = movies.get(path.get(i).get(1)).title;
            String endActor = actors.get(path.get(i + 1).get(0)).name;
            System.out.println("===> [" + title + "] ===> " + endActor);
        }
    }
}
