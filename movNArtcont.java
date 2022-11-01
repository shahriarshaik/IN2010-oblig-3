import java.util.Map;
public class movNArtcont {
    Map<String, actorData> artistDict;
    Map<String, movieData> movieDict;
    public movNArtcont(Map<String, actorData> artistDict, Map<String, movieData> movieDict){
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
