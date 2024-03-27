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

public class tammy {
    public static void main(String[] args) throws Exception {
        new tammy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tammy").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int v = f.nextInt(), e = f.nextInt();
            int component = v;
            int[] parent = new int[v];
            Arrays.fill(parent,-1);
            for (int i = 0; i < e; i++) {
                int a = f.nextInt()-1, b = f.nextInt()-1;
                int root1 = find(parent,a);
                int root2 = find(parent,b);
                if(root1!=root2){
                    component--;
                    union(parent,root1,root2);
                }
            }
            if(component == v){
                out.println(1+" "+ 1);
            }
            else{
                long ways = 1;
                for (int i = 0; i < component; i++) {
                    ways*=2;
                }
                out.println(2 + " " + ways);
            }
        }
        f.close();
    }
    public int find(int[] p, int i){
        if(p[i] == -1){
            return i;
        }
        return p[i] = find(p,p[i]);
    }
    public void union(int[] p, int a, int b){
        p[a] = b;
    }
}
