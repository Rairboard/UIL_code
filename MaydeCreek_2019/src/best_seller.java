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

public class best_seller {
    public static void main(String[] args) throws Exception {
        new best_seller().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("best_seller").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        Set<Thing> s = new TreeSet<>();
        while (f.hasNext()) {
            String[] l = f.nextLine().split(",");
            double tp = Double.parseDouble(l[2].replaceAll("\\$","")) * Long.parseLong(l[1]);
            s.add(new Thing(l[0],Long.parseLong(l[1]),tp));
        }
        for(Thing i : s){
            out.println(i);
        }
        f.close();
    }
    class Thing implements Comparable<Thing>{
        String n;
        double tp;
        long ni;
        public Thing(String name, long numItem,double totalProfit){
            n = name;
            ni = numItem;
            tp = totalProfit;
        }
        public int compareTo(Thing o){
            if(tp != o.tp){
                return tp < o.tp? 1 : -1;
            }
            if(ni != o.ni){
                return ni < o.ni ? 1 : -1;
            }
            return n.compareTo(o.n);
        }
        public String toString(){
            return String.format("$%.2f - %s/%d",tp,n,ni);
        }
    }
}
