import java.util.*;
import java.io.*;

public class spices {
    List<String> cc = new ArrayList<>(Arrays.asList("White","Red","Brown","Orange","Blue","Other"));
    public static void main(String[] args) throws Exception {
        new spices().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("spices.dat"));
        //Scanner f = new Scanner(System.in);
        int N = f.nextInt();
        f.nextLine();
        Set<Spice> s = new TreeSet<>();
        while(N-->0){
            s.add(new Spice(f.next(),f.nextInt(),f.nextInt(),f.next()));
        }
        for(Spice sp : s){
            System.out.println(sp.n);
        }
        f.close();
    }
    class Spice implements Comparable<Spice>{
        String n;
        int r,amt, c;
        public Spice(String name, int amount, int rating, String color){
            n = name;
            amt = amount;
            r = rating;
            if (cc.contains(color)) {
                c = cc.indexOf(color);
            }
            else{
                c = cc.indexOf("Other");
            }
        }
        public int compareTo(Spice o){
            if(r != o.r){
                return r < o.r?1 : -1;
            }
            if(c != o.c){
                return c > o.c?1:-1;
            }
            if(amt != o.amt){
                return amt < o.amt?1:-1;
            }
            return n.compareTo(o.n);
        }
    }
}