public class Run {
    String filmerFil; String skuespillerFil;
    Graph graph;

    /*--------------------------------------------------kostruktør---------------------------------------------------- */
    public Run(String filmerFil, String skuespillerFil){
        this.filmerFil = filmerFil;
        this.skuespillerFil = skuespillerFil;
        //sender inn hvilken filer som skal leses og starter lesingen
        long startRunKon = System.nanoTime();
        ReadFiles ReadFiles = new ReadFiles(filmerFil, skuespillerFil); 
        try {this.graph = ReadFiles.returnGraph();} 
        catch (Exception e) {System.out.println("fant ikke fil");}
        long endRunKon = System.nanoTime();
        long duration = (endRunKon - startRunKon)/1000000;  //divide by 1000000 to get milliseconds.¨
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Det tok: " + duration + " ms å lese filene og lage grafen. ");
        System.out.println("----------------------------------------------------------------\n");
    }
    /*--------------------------------------------------kostruktør---------------------------------------------------- */


    void oppgave1(){
        
        //starter å telle tid

        //starter å kjøre oppgave 1
        oppgave1 oppgave1 = new oppgave1(graph);
        long duration = oppgave1.run(); 

        //stopper tiden
        System.out.println("----------------------------------------------------------------");
        System.out.println("tiden det tok for å regne kanter: " + duration/1000000 + " ms");
        System.out.println("Oppgave 1 slutt\n\n");
    }

    void oppgave2(){
        oppgave2 oppgave2 = new oppgave2(graph);   //runs the program 
        oppgave2.run();
    }
    void oppgave3(){
        System.out.println("Oppgave 3");
        System.out.println("----------------------------------------------------------------");
        long startTime = System.nanoTime(); // counts time 
        
        oppgave3 oppgave3 = new oppgave3(graph);
        oppgave3.oppgv3print(oppgave3.chillesteSti("nm2255973", "nm0000460"));
        
        oppgave3 = new oppgave3(graph);
        oppgave3.oppgv3print(oppgave3.chillesteSti("nm0424060", "nm0000243"));
        
        oppgave3 = new oppgave3(graph);
        oppgave3.oppgv3print(oppgave3.chillesteSti("nm4689420", "nm0000365"));

        oppgave3 = new oppgave3(graph);
        oppgave3.oppgv3print(oppgave3.chillesteSti("nm0000288", "nm0001401"));

        oppgave3 = new oppgave3(graph);
        oppgave3.oppgv3print(oppgave3.chillesteSti("nm0031483", "nm0931324"));
        
        //oppgave3.run(); //runs 
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("----------------------------------------------------------------");
        System.out.println("kjøretid oppgave 3: " + (duration / 1000000) + " ms");
    }

    void oppgave4(){
        oppgave4 oppgave4 = new oppgave4();
        oppgave4.oppgaveFire(graph);
    }

    public static void main(String[] args) {
        long timeStart = System.nanoTime();
        Run run = new Run("data/movies.tsv", "data/actors.tsv");
        run.oppgave1();
        run.oppgave2();
        run.oppgave3();
        run.oppgave4();
        long timeEnd = System.nanoTime();
        long duration = (timeEnd - timeStart);  //divide by 1000000 to get milliseconds.
        System.out.println("\nDet tok: " + (duration/1000000) + " ms å kjøre hele programmet.");
    }
}
