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

public class lastlevel {
    public static void main(String[] args) throws Exception {
        new lastlevel().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("lastlevel").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            boolean[][] m = new boolean[n][n];
            for (int i = 0; i < n-1; i++) {
                m[f.nextInt()-1][f.nextInt()-1] = true;
            }
            if(n==1){
                out.println(1);
                continue;
            }
            TreeSet<Integer> ts = new TreeSet<>();
            boolean[] visited =new boolean[n];
            for (int i = 0; i < n; i++) {
                if(visited[i]) continue;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int cur = q.remove();
                    if(visited[cur]) continue;
                    visited[cur] = true;
                    boolean haveChildren = false;
                    for(int child = 0;child < n;child++){
                        if(child!=cur && m[cur][child]){
                            haveChildren = true;
                            q.offer(child);
                        }
                    }
                    if(!haveChildren) ts.add(cur+1);
                }
            }
            if(ts.size()>0){
                for(Integer i : ts){
                    out.print(i+" ");
                }
                out.println();
            }
        }
        f.close();
    }
}
