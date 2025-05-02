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

public class GruGalacticHeist {
    public static void main(String[] args) throws Exception {
        new GruGalacticHeist().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("GruGalacticHeist").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        f.nextLine();
        Object[][] point = new Object[n][2];
        for (int i = 0; i < n; i++) {
            point[i] = new Object[]{f.nextInt(),f.nextLine().trim()};
        }
        String ln = f.nextLine().trim();
        int s = f.nextInt();
        long maxDist = f.nextLong();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (point[i][1].equals(ln)) {
                pq.offer(new Edge(s, i, Math.abs(s-(int)point[i][0])));
                for(int j = i+1;j<n;j++){
                    if(point[j][1].equals(ln)){
                        pq.offer(new Edge(i,j,Math.abs(s-(int)point[j][0])));
                    }
                }
            }
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int cnt = 1;
        while(maxDist>0&& !pq.isEmpty()){
            Edge e = pq.remove();
            int ahead = find(parent, e.a);
            int bhead = find(parent, e.b);
            if(ahead!=bhead){
                if(maxDist - e.distance >= 0){
                    union(parent, ahead, bhead);
                    maxDist-=e.distance;
                    cnt++;
                }
            }
        }
        out.println(cnt);
        f.close();
    }
    public void union(int[] parent, int ahead, int bhead){
        parent[ahead] = parent[bhead];
    }
    public int find(int[] parent, int i){
        if(parent[i] == -1) return i;
        return find(parent, parent[i]);
    }
    class Edge implements Comparable<Edge>{
        int a, b;
        long distance;
        public Edge(int i, int j, long distance){
            a = i;
            b = j;
            this.distance = distance;
        }
        public int compareTo(Edge o){
            return Long.compare(distance, o.distance);
        }
    }
}
