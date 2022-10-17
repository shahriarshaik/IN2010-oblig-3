import java.util.ArrayList;
public class actorData {

    String nmID;
    String name;
    ArrayList<String> ttIDs;

    public actorData(String nmID, String name, ArrayList<String> ttIDs){
        this.nmID = nmID;
        this.name = name;
        this.ttIDs = ttIDs;
    }
    @Override
    public String toString() {
        return name;
    }
}
