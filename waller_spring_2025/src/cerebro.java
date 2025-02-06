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

public class cerebro {
    Map<String,List<String>> m;
    boolean found;
    public static void main(String[] args) throws Exception {
        new cerebro().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cerebro").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int N = f.nextInt(), M = f.nextInt();
        f.nextLine();
        m = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String[] ln = f.nextLine().trim().split("\\s+");
            m.putIfAbsent(ln[0],new ArrayList<>());
            m.get(ln[0]).add(ln[1]);
        }
        for (int i = 0; i < N; i++) {
            String name = f.nextLine().trim();
            HashSet<String> visited = new HashSet<>();
            found = false;
            recur("Xavier",name, visited);
            if(found) out.println("Mutant Located.");
            else out.println("Nowhere to be found.");
        }
        f.close();
    }
    public void recur(String cur, String goal, HashSet<String> visited){
        if(cur.equals(goal)){
            found = true;
            return;
        }
        if(visited.contains(cur)) return;
        if(m.get(cur)==null) return;
        visited.add(cur);
        for(String n : m.get(cur)){
            recur(n,goal,visited);
        }
        visited.remove(cur);
    }
}
