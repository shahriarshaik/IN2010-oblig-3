import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class graf{
    public static void main(String[] args) throws Exception {
        
        /*denne delen har ansvaret for å telle--------------------------------- */
        int antall = 0;
        Scanner sc = new Scanner(new File("data/marvel_actors.tsv"));
        while(sc.hasNextLine()){
            sc.nextLine();
            antall++;
        }
        sc.close();
        /*--------------------------------------------------------------------- */

        //denne leser linjene ----------------------------------------------------
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
        }
        sc.close();
        for (actorData actorData : actorArray) {
            System.out.println(actorData + " " + actorData.nmID);
        }

        sc = new Scanner(new File("data/marvel_movies.tsv"));
        ArrayList<movieData> movDat = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] ss = sc.nextLine().split("\t");
            String ttID = ss[0];
            String name = ss[1];
            String rating = ss[2];
            String votes= ss[3];
            movDat.add(new movieData(ttID, name, rating, votes));
        }
        


        //Scanner split = new Scanner(sc.nextLine());
        /* 
        while(split.hasNext()){
            System.out.println(split.next());
        }
        */
        /* 
        String[] test = sc.nextLine().split(" ");
        System.out.println("test size: " + test.length);
        for (String string : test) {
            System.out.println(string);
        }*/

        /* 
        while(sc.hasNextLine()){
            String[] split = sc.nextLine().split(" ");
            System.out.println(sc.nextLine());
        }
        */

    }
}
