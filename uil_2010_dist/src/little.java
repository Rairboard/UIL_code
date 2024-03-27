import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class little {
    List<String> hand = new ArrayList<>(Arrays.asList("PAIR,FLUSH,HIGH CARD".split(",")));
    List<String> rank = new ArrayList<>(Arrays.asList("Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Jack,Queen,King,Ace".split(",")));
    public static void main(String[] args) throws Exception {
        new little().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("little").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n = f.nextInt();
            List<Hand> al = new ArrayList<>();
            f.nextLine();
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().split(",\\s+");
                al.add(new Hand(ln[0],ln[1]));
            }
            Collections.sort(al);
            int qualify = 0;
            for (int i = 0; i < al.size(); i++) {
                if(al.get(0).compareTo(al.get(i))==00){
                    qualify++;
                }
            }
            out.println(hand.get(al.get(0).in) +" " + qualify);
//            Set<String> hs = new HashSet<>();
//            hs.add(al.get(0).toString());
//            for (int i = 1; i < al.size(); i++) {
//                if(al.get(0).compareTo(al.get(i))==0){
//                    hs.add(al.get(i).toString());
//                }
//            }
//            out.println(hs);
//            out.println(hand.get(al.get(0).in) + " " + hs.size());
        }
        f.close();
    }
    class Hand implements Comparable<Hand>{
        String[] a, b;
        int in;
        public Hand(String one,String two){
            String[] line1 = one.split("\\s+of\\s+");
            String[] line2 = two.split("\\s+of\\s+");
            if(line1[0].equals(line2[0])){
                in = 0;
            }
            else if(line1[1].equals(line2[1])){
                in= 1;
            }
            else{
                in = 2;
            }
            a = line1;
            b = line2;
        }
        public int compareTo(Hand o){
            if(in == o.in){
                int one = Math.max(rank.indexOf(a[0]),rank.indexOf(b[0]));
                int two = Math.max(rank.indexOf(o.a[0]),rank.indexOf(o.b[0]));
                if(in == 2 || in == 3){
                    if(one==two){
                        return rank.indexOf(o.b[0]) - rank.indexOf(b[0]);
                    }
                }
                return two - one;
            }
            return in - o.in;
        }
        public String toString(){
            return hand.get(in) + ": " + Arrays.toString(a) +" " + Arrays.toString(b);
        }
    }
}
