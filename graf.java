import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class graf{
    public static void main(String[] args) throws Exception {
        int noder = 0;
        int kanter = 0;
        
        /*denne delen har ansvaret for å telle--------------------------------- */
        int antall = 0;
        Scanner sc = new Scanner(new File("data/marvel_actors.tsv"));
        while(sc.hasNextLine()){
            sc.nextLine();
            antall++;
        }
        sc.close();
        /*---------------------------------------------------------------------*/

        //denne leser linjene ----------------------------------------------------
        
        Dictionary<String, actorData> artistDict = new Hashtable<>();
        Dictionary<String, movieData> movieDict = new Hashtable<>();
        
        sc = new Scanner(new File("data/marvel_movies.tsv"));
        ArrayList<movieData> movDat = new ArrayList<>();
        while(sc.hasNextLine()){ // nextline: tt0371746	Iron Man	7.9	1049777
            String[] ss = sc.nextLine().split("\t");
            String ttID = ss[0];
            String name = ss[1];
            String rating = ss[2];
            String votes= ss[3];
            movDat.add(new movieData(ttID, name, rating, votes));
            movieDict.put(ttID, new movieData(ttID, name, rating, votes));
        }
        sc.close();

        for (movieData movieData : movDat) {
            System.out.println(movieData + " " + movieData.ttID);
        }
        
        sc = new Scanner(new File("data/marvel_actors.tsv"));
        //while den har neste linje ----------------------------------------------
        //Scanner split;
        ArrayList<actorData> actorArray = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] split = sc.nextLine().split("\t");  //split inneholder: nm0000313	Jeff Bridges	tt0371746
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
            for (String string : ttIDs) {
                if(movieDict.get(string) != null){
                    movieDict.get(string).actorListe.add(actor);
                    actor.filmer.add(movieDict.get(string));
                    kanter++;
                }
            }
        }
        sc.close();
        System.out.println("\n\n\n\n\n\n");
        for (actorData actorData : actorArray) {
            System.out.println(actorData + " " + actorData.nmID);
        }

        for (actorData actorData : actorArray) {
            if(actorData.filmer.size() > 1){
                System.out.println(actorData);
            }
        }

        System.out.println("\n\n");

        System.out.println("noder: " + noder);
        System.out.println("kanter: " + kanter);

        
    }
}
