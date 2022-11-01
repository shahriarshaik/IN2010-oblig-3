import java.util.ArrayList;
public class looptest {
    public static void main(String[] args) {
        ArrayList<Integer> liste = new ArrayList<>();
        liste.add(2);
        for (int i = 0; i < liste.size(); i++) {
            liste.add(2);
            System.out.println(liste.size());
        }
    }
}
