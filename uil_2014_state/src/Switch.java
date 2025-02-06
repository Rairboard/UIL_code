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

public class Switch {
    public static void main(String[] args) throws Exception {
        new Switch().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Switch").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times =f.nextInt();
        f.nextLine();
        for (int asdf = 0; asdf < times; asdf++) {
            int n = f.nextInt(), k = f.nextInt();
            f.nextLine();
            long target = (1L << n) -1;
            long[] switches = new long[k];
            for (int i = 0; i < k; i++) {
                String ln = f.nextLine().trim();
                for(int j = 0;j < ln.length();j++){
                    if(ln.charAt(ln.length()-1-j) == 'Y') switches[i] |= (1L << j);
                }
            }
            boolean found = false;
            Map<Long,Integer> shadow = new HashMap<>();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0,0));
            while(!pq.isEmpty()){
                Node N = pq.remove();
                long cur = N.n;
                int step = N.step;
                if(cur==target){
                    found = true;
                    out.println(step);
                    break;
                }
                if(step > 10){
                    found = true;
                    out.println("TOO HARD!");
                    break;
                }
                if (shadow.containsKey(cur)){
                    if(step >= shadow.get(cur)) continue;
                }
                shadow.put(cur,step);
                for (int i = 0; i < k; i++) {
                    long b = cur ^ switches[i];
                    pq.offer(new Node(b, step+1));
                }
            }
            if(!found) out.println("TOO HARD!");
        }
        f.close();
    }
    class Node implements Comparable<Node>{
        long n;
        int step;
        public Node(long n, int s){
            this.n = n;
            step = s;
        }
        public int compareTo(Node o){
            return step - o.step;
        }
    }
}

