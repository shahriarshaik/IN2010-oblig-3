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
        Scanner split;
        ArrayList<actorData> actorArray = new ArrayList<>();
        while(sc.hasNextLine()){
            split = new Scanner(sc.nextLine());  //split inneholder: nm0000313	Jeff Bridges	tt0371746
            String nmID = split.next();
            String name = split.next();
            ArrayList<String> ttIDs = new ArrayList<>();
            while(split.hasNext()){
                String analyse = split.next();
                if(analyse.length() > 1){
                    char en = analyse.charAt(0);
                    char to = analyse.charAt(1);
                    String begge = "" + en + to;
                    if(!begge.equals("tt")){
                        name = name + " " + analyse;
                    }
                    else{
                        ttIDs.add(analyse);
                    }
                }
            }
            actorData actor = new actorData(nmID, name, ttIDs);
            actorArray.add(actor);
        }
        for (actorData actorData : actorArray) {
            System.out.println(actorData);
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
