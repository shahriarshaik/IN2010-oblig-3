import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.io.BufferedReader;
import java.util.Stack;

public class graf{

    static String actorsFileName = "data/actors.tsv";
    static String moviessFileName = "data/movies.tsv";
    static String line;
    static int noder = 0;
    static int kanter = 0;
    static Map<String, actorData> artistDict = new Hashtable<>();
    static Map<String, movieData> movieDict = new Hashtable<>();



    static void lesActor() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(actorsFileName));
        line = null;
        ArrayList<actorData> actorArray = new ArrayList<>();
        while((line = reader.readLine()) != null){
            String[] split = line.split("\t");  //split inneholder: nm0000313	Jeff Bridges	tt0371746
            String nmID = split[0];
            String name = split[1];
            ArrayList<String> ttIDs = new ArrayList<>();
            for (int i = 2; i < split.length; i++) {
                ttIDs.add(split[i]);
            }
            actorData actor = new actorData(nmID, name, ttIDs);
            actorArray.add(actor);
            noder++;
            artistDict.put(nmID, actor);
            for (String ttID : ttIDs) {
                //denne tar frem film ordboka og legger til spilleren i filmens liste
                if(movieDict.get(ttID) != null){
                    movieDict.get(ttID).actorListe.add(actor);
                }
            }
        }
        reader.close();
    }

    static void lesFilmer() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(moviessFileName));
        line = "";
        ArrayList<movieData> movDat = new ArrayList<>();
        while((line = reader.readLine()) != null){ // nextline: tt0371746	Iron Man	7.9	1049777
            String[] ss = line.split("\t");
            String ttID = ss[0];
            String name = ss[1];
            String rating = ss[2];
            String votes= ss[3];
            movDat.add(new movieData(ttID, name, rating, votes));
            movieDict.put(ttID, new movieData(ttID, name, rating, votes));
        }
        reader.close();
    }

    static void regnKanter(){
        for (String data : movieDict.keySet()) {
            int antallSkuespillere = movieDict.get(data).actorListe.size();
            kanter = kanter + ((antallSkuespillere * (antallSkuespillere - 1)/2)); //denne gir deg filmen som returneres
        }
    }

    static void noderOgKAnter(){
        System.out.println("noder: " + noder);
        System.out.println("kanter: " + kanter);
    }
    
    static void kanterOgNoder() throws Exception{
        lesFilmer();
        lesActor();
        regnKanter();
        noderOgKAnter();
    }

    static movNArtcont hentGraf(){
        return new movNArtcont(artistDict, movieDict);
    }
    
    static Map<String, String> DFS(movNArtcont grafen, String startN){
        Map<String, actorData> artistDict = grafen.artistDict; Map<String, movieData> movieDict = grafen.movieDict;
        Stack<String> que = new Stack<>();
        que.add(startN);
        Map<String, String> path;
        //path.put(startN, startN)
        while(!que.empty()){
            String skuespiller = que.pop();
            for (movieData movie : artistDict.get(skuespiller).filmer) {
                for (actorData actor : movieDict.get(movie.ttID).actorListe) {
                    if(!que.contains(actor.nmID)){

                    }
                }
            }
            System.out.println("burde looope uendelig");
        }
        Map<String, String> temp = new Hashtable<>();
        return temp;
    }
    
    public static void main(String[] args) throws Exception {
        kanterOgNoder();
        DFS(hentGraf(), "nm2284418");
    }
}
