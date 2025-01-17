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

public class convertme {
    public static void main(String[] args) throws Exception {
        new convertme().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("convertme").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n =f.nextInt(), m =f.nextInt();
            if(n>=m) {
                out.println(-1);
                continue;
            }
            int[] shadow = new int[m-n+1];
            Arrays.fill(shadow, Integer.MAX_VALUE);
            PriorityQueue<Node> q = new PriorityQueue<>();
            q.offer(new Node(n,0));
            while(!q.isEmpty()){
                Node node = q.remove();
                int cur = node.cur;
                int step = node.step;
                if( cur > m|| step >= shadow[cur-n]) continue;
                shadow[cur-n] = step;
                for(int i = 2;i<=Math.sqrt(cur);i++){
                    if (cur % i == 0) {
                        for (int j = 1; j <= (m - n) / i; j++) {
                            q.offer(new Node(cur + i*j,step+j));
                        }
                        if(i!=cur/i){
                            for (int j = 1; j <= (m - n) / (cur/i); j++) {
                                q.offer(new Node(cur + (cur/i)*j,step+j));
                            }
                        }
                    }
                }
            }
            if(shadow[m-n]==Integer.MAX_VALUE){
                out.println(-1);
            }
            else{
                out.println(shadow[m-n]);
            }
        }
        f.close();
    }
    class Node implements Comparable<Node>{
        int cur;
        int step;
        public Node(int cur,int step){
            this.cur = cur;
            this.step = step;
        }
        public int compareTo(Node o){
            return step - o.step;
        }
    }
}
