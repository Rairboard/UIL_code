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

public class feed_store {
    Map<String,List<String>> m;
    Map<String,Integer> cost, shadow;
    int min,closest;
    List<String> path;
    public static void main(String[] args) throws Exception {
        new feed_store().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("feed_store").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        m = new HashMap<>();
        shadow = new HashMap<>();
        cost = new HashMap<>();
        min = Integer.MAX_VALUE;
        closest = Integer.MAX_VALUE;
        int max= f.nextInt();
        f.nextLine();
        String[] l = f.nextLine().split(",");
        for (int i = 0; i < l.length; i++) {
            String store = l[i].substring(0,1);
            int ff =Integer.parseInt(l[i].substring(1));
            m.put(store,new ArrayList<>());
            shadow.put(store,ff);
        }
        while(f.hasNext()){
            String[] ln = f.nextLine().split("-");
            String[] store = ln[0].split("/");
            int c = Integer.parseInt(ln[1]);
            m.putIfAbsent(store[0],new ArrayList<>());
            m.putIfAbsent(store[1],new ArrayList<>());
            m.get(store[0]).add(store[1]);
            m.get(store[1]).add(store[0]);
            cost.put(store[0] + store[1],c);
            cost.put(store[1]+store[0],c);
        }
        HashSet<String> visited = new LinkedHashSet<>();
        recur("A",visited,0,max);
        out.print("(" + min + ") - ");
        for (int i = 0; i < path.size(); i++) {
            out.print(path.get(i));
        }
        f.close();
    }
    public void recur(String cur,Set<String> visited,int c,int ff){
        if (cur.equals("A") && c!=0) {
            if(Math.abs(0-ff)<closest){
                closest = Math.abs(0-ff);
                if(c < min){
                    min = c;
                    path = new ArrayList<>(visited);
                    path.add("A");
                }
            }
            out.println("feed = " + ff +" cost = " + c + " " + path);
            return;
        }
        else{
            visited.add(cur);
            if(m.get(cur)==null)return;
            for(String store : m.get(cur)){
                if (store.equals("A")) {
                    recur(store,visited,c + cost.get(cur+store),ff);
                }
                else if (!visited.contains(store)){
                    recur(store,visited,c+cost.get(cur+store),ff-shadow.get(store));
                }
            }
        }
        visited.remove(cur);
    }
}
