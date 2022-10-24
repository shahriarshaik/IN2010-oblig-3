import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.io.BufferedReader;

public class graf{
    public static void main(String[] args) throws Exception {

//----------------------generelle variabler------------------------------------
        int noder = 0;
        int kanter = 0;
        Map<String, actorData> artistDict = new Hashtable<>();
        Map<String, movieData> movieDict = new Hashtable<>();
        String actorsFileName = "data/actors.tsv";
        String moviessFileName = "data/movies.tsv";
        BufferedReader reader = new BufferedReader(new FileReader(actorsFileName));
//-----------------------------------------------------------------------------


//---------------------denne leser film filen-------------------------------------
        reader = new BufferedReader(new FileReader(moviessFileName));
        String line;
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
//-------------------------------------------------------------------------------


//---------------------denne leser actor filen-------------------------------------

        reader = new BufferedReader(new FileReader(actorsFileName));
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
//-------------------------------------------------------------------------------

//-----------------denne skal telle kanter--------------------------------------

    for (String data : movieDict.keySet()) {
        int antallSkuespillere = movieDict.get(data).actorListe.size();
        kanter = kanter + ((antallSkuespillere * (antallSkuespillere - 1)/2)); //denne gir deg filmen som returneres
    }

//-------------------------------------------------------------------------------

        //noder og kanter print
        System.out.println("noder: " + noder);
        System.out.println("kanter: " + kanter);

        
    }
}
