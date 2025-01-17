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
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt() % 31, k = f.nextInt();
            f.nextLine();
            int[] switches = new int[k];
            for (int i = 0; i < k; i++) {
                String ln = f.nextLine().trim();
                for (int j = 0; j < ln.length(); j++) {
                    if(ln.charAt(j)=='Y') switches[i] |= (1<<j);
                }
            }
            int target = (1<<n)-1;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            HashSet<Integer> visited = new HashSet<>();
            pq.offer(new Node(0,0));
            while(!pq.isEmpty()){
                Node cur = pq.remove();
                int bulb = cur.bulb;
                int flip = cur.flip;
                if(visited.contains(bulb)) continue;
                visited.add(bulb);
                if(bulb == target){
                    if(flip>10) out.println("TOO HARD!");
                    else{
                        out.println(flip);
                    }
                    break;
                }
                if(flip>10) continue;
                for(int i = 0;i < switches.length;i++){
                    int newBulb = bulb ^ switches[i];
                    pq.offer(new Node(newBulb, flip+1));
                }
            }
        }
        f.close();
    }
    class Node implements Comparable<Node> {
        int bulb;
        int flip;
        public Node(int b, int f){
            bulb = b;
            flip = f;
        }
        public int compareTo(Node o){
            return flip - o.flip;
        }
    }
}

