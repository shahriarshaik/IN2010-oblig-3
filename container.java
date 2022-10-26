import java.util.Map;
public class container {
    Map<String, actorData> artistDict;
    Map<String, movieData> movieDict;
    public container(Map<String, actorData> artistDict, Map<String, movieData> movieDict){
        this.artistDict = artistDict;
        this.movieDict = movieDict;
    }

    Map<String, actorData> actordict(){
        return artistDict;
    }

    Map<String, movieData> moviedict(){
        return movieDict;
    }
}
