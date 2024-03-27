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

public class everywhere {
    Map<Integer,List<Integer>>map;
    public static void main(String[] args) throws Exception {
        new everywhere().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("everywhere").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), m = f.nextInt();
            boolean found = false;
            map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                char a = f.next().charAt(0);
                char b = f.next().charAt(0);
                int c = a - '0' + 1, d = b - '0' + 1;
                if (a == '$') {
                    c = 0;
                    found = true;
                }
                if (b == '$') {
                    d = 0;
                    found = true;
                }
                if (found) {
                    map.putIfAbsent(c, new ArrayList<>());
                    map.putIfAbsent(d, new ArrayList<>());
                    map.get(c).add(d);
                    map.get(d).add(c);
                }
            }
            boolean[] visit = new boolean[n+1];
            HashSet<Integer> visited = new HashSet<>();
            recur(0,visited, visit);
            int cnt = 0;
            for (int i = 1; i < visit.length; i++) {
                if(visit[i]){
                    cnt++;
                }
            }
            out.println(cnt);
        }
        f.close();
    }
    public void recur(int cur, HashSet<Integer> visited, boolean[] visit){
        if(!visited.contains(cur)){
            visited.add(cur);
            visit[cur] = true;
            if(map.get(cur)==null) return;
            for(Integer ii : map.get(cur)){
                recur(ii,visited,visit);
            }
            visited.remove(cur);
        }
    }
}
