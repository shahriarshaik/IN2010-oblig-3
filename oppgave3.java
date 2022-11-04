import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;

public class oppgave3 {
    HashMap<String, Movie> filmer; 
    HashMap<String, Actor> actors;
    HashMap<String, String[]> path = new HashMap<>();
    
    public oppgave3(Graph graph){
        filmer = graph.movies;
        actors = graph.actors; 
    }

    void run(){
        oppgv3print(chillesteSti("nm2255973", "nm0000460"));
        oppgv3print(chillesteSti("nm0424060", "nm0000243"));
        oppgv3print(chillesteSti("nm4689420", "nm0000365"));
        oppgv3print(chillesteSti("nm0000288", "nm0001401"));
        oppgv3print(chillesteSti("nm0031483", "nm0931324"));
    }

    public class cmp implements Comparator<String>{
        @Override
        public int compare(String i, String j) {
            if(Float.parseFloat(path.get(i)[1]) - Float.parseFloat(path.get(j)[1]) > 0){
                return 1;
            }
            else if(Float.parseFloat(path.get(i)[1]) - Float.parseFloat(path.get(j)[1]) < 0){
                return -1; 
            }
            else{
                return 0;
            }
        }
        
    }

    String chillesteSti(String startingActor, String endingActor){ // makes a string with the path that is considered the chillest path, the other function prints that string
        path.put(startingActor, new String[] {startingActor, "0"}); //putting the first actor and rating inn
        PriorityQueue<String> queue = new PriorityQueue<>(new cmp());
        queue.add(startingActor);  //adding the first actor to the queue
        while(!queue.isEmpty()){ //runs untill the queue is empty
            String at = queue.poll();
            if(at.equals(endingActor)){ // when finally arrive to the last actor
                System.out.println("\nweight: " + path.get(at)[1]);
                return path.get(at)[0];
            }
            for(String j : actors.get(at).movies){ // for looping all the actors movies
                if(filmer.containsKey(j)){
                    for(String i : filmer.get(j).cast){ // for looping that movies cast
                        Float f = 10 - filmer.get(j).rating; // calculating the weight
                        f = Float.parseFloat(path.get(at)[1]) + f;
                        if(!path.containsKey(i)){ //creating the string and adding to the path and queue for continuing the finding if its not in the path
                            path.put(i, new String[] {path.get(at)[0] + "," + j + "," + i, "" + f});
                            queue.add(i); //using the cmp to compare
                        } 
                        else if(Float.parseFloat(path.get(i)[1]) > f){ //does the same if its in the path but the raitng is higher
                            path.get(i)[1] = "" + f;
                            path.get(i)[0] = path.get(at)[0] + ","+ j + "," + i;
                            queue.add(i);
                        }
                    }
                }
            }
        }
        return "not found";
    }
    
    void oppgv3print(String f){ //parces the string and prints output
        String[] path = f.split(",");
        System.out.println(actors.get(path[0]));
        for(int i = 1; i < path.length; i++){
            System.out.println("===[" + filmer.get(path[i]) + "] ===> " + actors.get(path[i+1]));
            i++;
        }
    }

}
