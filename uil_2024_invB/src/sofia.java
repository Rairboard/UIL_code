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

public class sofia {
    Map<String,List<Edge>> m;
    boolean found;
    Map<String,Integer> shadow;
    public static void main(String[] args) throws Exception {
        new sofia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sofia").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int flight = f.nextInt(), n = f.nextInt();
        f.nextLine();
        m = new HashMap<>();
        shadow = new HashMap<>();
        HashSet<String> name = new HashSet<>();
        for (int i = 0; i < flight; i++) {
            String a = f.next(), b = f.next();
            int c = f.nextInt();
            f.nextLine();
            m.putIfAbsent(a, new ArrayList<>());
            m.putIfAbsent(b, new ArrayList<>());
            m.get(b).add(new Edge(a, c));
            m.get(a).add(new Edge(b, c));
            name.add(a);
            name.add(b);
        }
        for (int i = 0; i < n; i++) {
            found = false;
            for(String s : name){
                shadow.put(s,Integer.MAX_VALUE);
            }
            String a = f.next(), b = f.next();
            int c = f.nextInt();
            recur(a, 0);
            if(shadow.get(b)==null || shadow.get(b)>c) out.println("There's no place like home.");
            else out.println(b  + " is always a good idea.");
        }
        f.close();
    }
    public void recur(String cur, int cost){
        if(cost>=shadow.get(cur)) return;
        shadow.put(cur, cost);
        if(m.get(cur)==null) return;
        for(Edge e : m.get(cur)){
            recur(e.to, cost + e.cost);
        }
    }
    class Edge {
        String to;
        int cost;
        public Edge(String t, int c){
            to =t;
            cost = c;
        }
    }
}
