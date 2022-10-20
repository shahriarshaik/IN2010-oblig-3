import java.util.ArrayList;

public class movieData {
    ArrayList<actorData> actorListe = new ArrayList<>();
    String ttID;
    String name;
    String rating;
    String votes;
    
    public movieData(String ttID, String name, String rating, String votes){
        this.ttID = ttID;
        this.name=name;
        this.rating = rating;
        this.votes = votes; 
    }

    @Override
    public String toString() {
        return name;
    }
}
