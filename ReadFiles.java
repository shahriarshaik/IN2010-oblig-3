import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class ReadFiles{
    /*--------------------------------------------------variabler---------------------------------------------------- */
    String line;
    HashMap<String, Movie> movies = new HashMap<>();
    HashMap<String, Actor> actors = new HashMap<>();
    String filmFil; String skuespillerFil;
    /*---------------------------------------------------------------------------------------------------------------- */

    //constructor
    public ReadFiles(String filmFil, String skuespillerFil){
        this.filmFil = filmFil;
        this.skuespillerFil = skuespillerFil;
    }


    HashMap<String, Movie> readMovieFile() throws Exception{ //reads the movie.tsv file and returns a movie Hashmap
        //using bufferedreader to read the files, scanner caps out at 100-130 lines
        BufferedReader reader = new BufferedReader(new FileReader(filmFil));
        line = "";          //just a variable to get the bufferedereader going
        while((line = reader.readLine()) != null){ // content in a line: tt0371746	Iron Man	7.9	1049777
            String[] split = line.split("\t");              //using \t to split for tabs
            String ttID = split[0]; String title = split[1]; Float rating = Float.parseFloat(split[2]);         //generating variables
            movies.put(ttID, new Movie(title, rating)); //adding to the movies dict which is a part of the graph, creates a new film class to store the films data
        }
        reader.close();
        return movies;
    }

    HashMap<String, Actor> readActorFile() throws Exception{  //reads the actors.tsv file and returns a actor Hashmap, most of it is the same as readMovieFile()
        BufferedReader reader = new BufferedReader(new FileReader(skuespillerFil));
        line = null;
        while((line = reader.readLine()) != null){   //while loop for the buffered reader
            String[] split = line.split("\t");  //line contents: nm0000313	Jeff Bridges	tt0371746
            String nmID = split[0]; String name = split[1]; ArrayList<String> ttList = new ArrayList<>(); for (int i = 2; i < split.length; i++) {ttList.add(split[i]);}
            actors.put(nmID, new Actor(name, nmID)); //creates and stores actor
            for(String movie : ttList){  //loop for going inn the movies and make them point to the actor through a list, also makes the actor point to the movie
                if(movies.containsKey(movie)){
                    actors.get(nmID).addMovie(movie);
                    movies.get(movie).addActor(nmID);
                }
            }
        }
        reader.close();
        return actors;
    }

    Graph returnGraph() throws Exception{ // creates and returns the graph
        HashMap<String, Movie> movies = readMovieFile(); 
        HashMap<String, Actor> actors = readActorFile();
        return new Graph(movies, actors);
    }
}
