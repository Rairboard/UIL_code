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

public class courses {
    Map<String,List<String>> m;
    Map<String,Integer> shadow;
    boolean cycle;
    public static void main(String[] args) throws Exception {
        new courses().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("courses.in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int courses = f.nextInt(), con = f.nextInt();
            f.nextLine();
            m = new HashMap<>();
            shadow = new HashMap<>();
            cycle = false;
            for (int i = 0; i < courses; i++) {
                m.put(f.nextLine(),new ArrayList<>());
            }
            for (int i = 0; i < con; i++) {
                String[] l = f.nextLine().split(" is a prerequisite of ");
                m.putIfAbsent(l[0],new ArrayList<>());
                m.putIfAbsent(l[1],new ArrayList<>());
                m.get(l[0]).add(l[1]);
            }
            for(String s : m.keySet()){
                for(String asdf : m.keySet()){
                    shadow.put(asdf,Integer.MAX_VALUE);
                }
                Set<String> visited = new HashSet<>();
                recur(s,visited,0);
                if(cycle) break;
            }
            out.println(!cycle ? "Let the cadets in!":"We've got a problem!");
        }
        f.close();
    }
    public void recur(String cur, Set<String> visited, int step){
        if(cycle) return;
        if(visited.contains(cur)){
            cycle = true;
            return;
        }
        if(step < shadow.get(cur)){
            visited.add(cur);
            shadow.put(cur,step);
            if(m.get(cur)==null) return;
            for(String neighbor : m.get(cur)){
                recur(neighbor,visited,step+1);
            }
            visited.remove(cur);
        }
    }
}
