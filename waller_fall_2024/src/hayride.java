import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class hayride {
    Map<String,Integer> shadow;
    Map<String,List<String>> m;
    Map<String,Integer> cost;
    List<String> path;
    public static void main(String[] args) throws Exception {
        new hayride().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hayride").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            shadow = new HashMap<>();
            m = new HashMap<>();
            cost = new HashMap<>();
            path = new ArrayList<>();
            int n = f.nextInt();
            f.nextLine();
            HashSet<String> al = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                m.putIfAbsent(ln[0],new ArrayList<>());
                m.putIfAbsent(ln[1], new ArrayList<>());
                m.get(ln[0]).add(ln[1]);
                m.get(ln[1]).add(ln[0]);
                cost.put(ln[0]+ln[1],Integer.parseInt(ln[2]));
                cost.put(ln[1]+ln[0],Integer.parseInt(ln[2]));
                al.add(ln[0]);
                al.add(ln[1]);
            }
            for(String s : al){
                shadow.put(s,Integer.MAX_VALUE);
            }
            LinkedHashSet<String> visited =new LinkedHashSet<>();
            recur("Start", "Stop", visited,0);
            for(String s : path){
                out.println(s);
            }
            out.println();
        }
        f.close();
    }
    public void recur(String cur, String goal, LinkedHashSet<String> visited, int step){
        if(step>=shadow.get(cur)||visited.contains(cur)) return;
        shadow.put(cur,step);
        if (cur.equals(goal)) {
            path = new ArrayList<>(visited);
            path.add(goal);
            return;
        }
        if(m.get(cur)==null) return;
        visited.add(cur);
        for(String n : m.get(cur)){
            if (cost.containsKey(cur + n)) {
                recur(n,goal,visited, step + cost.get(cur+n));
            }
        }
        visited.remove(cur);
    }
}
