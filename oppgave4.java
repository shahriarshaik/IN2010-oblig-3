import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class oppgave4 {
    HashMap<String, Movie> movies; 
    HashMap<String, Actor> actors;

    void oppgaveFire(Graph graph){
        movies = graph.movies; actors = graph.actors;
        System.out.println("\n\n\noppgave 4");
        long start = System.currentTimeMillis();

        Map<String, Boolean> path = new HashMap<>(); //containers we are going to use
        Map<Integer, Integer> finalMap = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        
        while(actors.size() != 0){ //while loop untill its empty
            String tempActor = actors.keySet().toArray()[0].toString(); //convert the keyset to arraylist and grab the first item,
            int counter = 0; 
            queue.add(tempActor); 
            path.put(tempActor, true);
            while(!(queue.isEmpty())){ //while loop til queue is empty and all has been added to the path
                String at = queue.poll();
                for(String j : actors.get(at).movies){ //forloop the actors movie
                    if(movies.containsKey(j)){
                        for(String i : movies.get(j).cast){ //for loop that movies cast
                            if(!path.containsKey(i)){ //take that actor, check if not in path
                                path.put(i, true); //if not inn, add to path and to que
                                queue.add(i);
                            }
                        }
                    }
                }
                actors.remove(at);
                counter++;
            }
            if(!finalMap.containsKey(counter)){
                finalMap.put(counter, 0);
            }
            finalMap.put(counter, finalMap.get(counter) + 1);
        }
        //Collections.reverse(path);
        //String k = skuespillere.keySet().toArray()[0].toString();
        ArrayList<Integer> rev = new ArrayList<>();
        for(int a : finalMap.keySet()){
            rev.add(a);
        }
        Collections.reverse(rev); //i have to reverce the list here and then for loop to print 
        long elapsedTime = System.currentTimeMillis() - start;

        for (Integer a : rev) {
            System.out.println("There are " + finalMap.get(a) + " components of size " + a );
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("oppgave 4 took: " + (double) elapsedTime / 1000 + " s ");
        System.out.println("----------------------------------------------------------------");
    }
}
