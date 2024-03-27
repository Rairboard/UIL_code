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
    public static void main(String[] args) throws Exception {
        new sofia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sofia").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int con = f.nextInt(), times = f.nextInt();
        f.nextLine();
        m = new HashMap<>();
        for (int i = 0; i < con; i++) {
            String a = f.next(), b = f.next();
            int w = f.nextInt();
            m.putIfAbsent(a,new ArrayList<>());
            m.putIfAbsent(b,new ArrayList<>());
            m.get(a).add(new Edge(b,w));
            m.get(b).add(new Edge(a,w));
        }
        for (int i = 0; i < times; i++) {
            String a = f.next(), b = f.next();
            int w = f.nextInt();
            HashSet<String> visited = new HashSet<>();
            found = false;
            recur(a,b,0,w,visited);
            if(found){
                out.println(b + " is always a good idea.");
            }
            else{
                out.println("There's no place like home.");
            }
        }
        f.close();
    }
    public void recur(String cur, String goal, int c, int lim,Set<String> visited){
        if(!visited.contains(cur)){
            if(cur.equals(goal)){
                found = true;
                return;
            }
            visited.add(cur);
            if(m.get(cur)==null) return;
            for(Edge e : m.get(cur)){
                if(!visited.contains(e.to) && c + e.weight <= lim){
                    recur(e.to, goal, c+e.weight,lim,visited);
                }
            }
            visited.remove(cur);
        }
    }
    class Edge {
        String to;
        int weight;
        public Edge(String b, int w){
            to = b;
            weight = w;
        }
    }
}
