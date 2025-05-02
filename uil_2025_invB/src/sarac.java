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

public class sarac {
    public static void main(String[] args) throws Exception {
        new sarac().run();
    }
    Map<String,List<String>> m;
    boolean good;
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sarac").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int v = f.nextInt(), e = f.nextInt();
            f.nextLine();
            String[] ln = f.nextLine().trim().split("\\s+");
            m = new HashMap<>();
            good = true;
            for (int i = 0; i < ln.length; i++) {
                m.put(ln[i], new ArrayList<>());
            }
            for (int i = 0; i < e; i++) {
                String[] edge = f.next().split("->");
                m.get(edge[0]).add(edge[1]);
            }
            for(String V : m.keySet()){
                HashSet<String> visited =new HashSet<>();
                recur(V, visited);
                if(!good) break;
            }
            if(good) out.println("Deadlock free; all is well");
            else out.println("Deadlock exists; not good...");
        }
        f.close();
    }
    public void recur(String cur, HashSet<String> visited){
        if(!good) return;
        if(visited.contains(cur)){
            good = false;
            return;
        }
        if(m.get(cur)==null) return;
        visited.add(cur);
        for(String v : m.get(cur)){
            recur(v, visited);
        }
        visited.remove(cur);
    }
}
