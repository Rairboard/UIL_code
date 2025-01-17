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

public class urvashi {
    public static void main(String[] args) throws Exception {
        new urvashi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("urvashi").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int road = f.nextInt(), k = f.nextInt();
            String s = f.next(), e = f.next();
            if(f.hasNext()) f.nextLine();
            List<String> al = new ArrayList<>();
            List<String[]> con = new ArrayList<>();
            for (int i = 0; i < road; i++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                con.add(ln);
                if(!al.contains(ln[0])) al.add(ln[0]);
                if(!al.contains(ln[1])) al.add(ln[1]);
            }
            if(!al.contains(s) || !al.contains(e)) {
                out.println("Case #" + asdf + ": IMPOSSIBLE");
                continue;
            }
            int n = al.size();
            long[][]shadow = new long[k+1][n];
            long[][] m = new long[n][n];
            for (int i = 0; i < con.size(); i++) {
                int a = al.indexOf(con.get(i)[0]);
                int b = al.indexOf(con.get(i)[1]);
                long cost = Long.parseLong(con.get(i)[2]);
                m[a][b] = cost;
                m[b][a] = cost;
            }
            for (int i = 0; i < shadow.length; i++) {
                Arrays.fill(shadow[i],Long.MAX_VALUE);
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(al.indexOf(s), 0,0));
            while(!pq.isEmpty()){
                Node N = pq.remove();
                int cur = N.cur;
                int spell = N.k;
                long cost = N.cost;
                if(cost >= shadow[spell][cur]) continue;
                shadow[spell][cur] = cost;
                for (int i = 0; i < m.length; i++) {
                    if(m[cur][i]!=0){
                        pq.offer(new Node(i, cost + m[cur][i], spell));
                        if(spell+1 < shadow.length){
                            pq.offer(new Node(i,cost + reverse(m[cur][i]), spell+1));
                        }
                    }
                }
            }

            long min = Long.MAX_VALUE;
            for (int i = 0; i <= k; i++) {
//                out.println(Arrays.toString(shadow[i]));
                min = Math.min(min, shadow[i][al.indexOf(e)]);
            }
            out.println("Case #" + asdf + ": " + (min == Long.MAX_VALUE? "IMPOSSIBLE": min));
        }
        f.close();
    }
    class Node implements Comparable<Node>{
        int cur;
        long cost;
        int k;
        public Node (int c,long w, int spell){
            cur = c;
            cost = w;
            k = spell;
        }
        public int compareTo(Node o){
            return Long.compare(cost, o.cost);
        }
    }
    public long reverse(long k){
        String s = new StringBuilder(k + "").reverse().toString() ;
        return Long.parseLong(s);
    }
}
