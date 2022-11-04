import java.util.ArrayList;

public class Movie {
    /* basics, dont need to explain this class, holders, getters thats it */

    String title; Float rating;
    ArrayList<String> cast = new ArrayList<>();

    
    public Movie(String title, Float rating){
        this.title = title;
        this.rating = rating;
    }

    void addActor(String actor){
        cast.add(actor);
    }

    @Override
    public String toString() {
        return title + ". Rating: " + rating;
    }

    ArrayList<String> getCast(){
        return cast;
    }

}
