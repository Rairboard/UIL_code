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
        for (int asdf = 0; asdf < times; asdf++) {
            int v = f.nextInt(), e = f.nextInt();
            int component = v;
            int[] parent = new int[v];
            for (int i = 0; i < v; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < e; i++) {
                int a = f.nextInt()-1 , b = f.nextInt()-1;
                int aHead = find(parent, a);
                int bHead = find(parent, b);
                if(aHead!=bHead){
                    component--;
                    union(parent, aHead, bHead);
                }
            }
            if(e==0){
                out.println(1 + " "  + 1);
            }
            else{
                out.println(2 + " " + (1L << component));
            }
        }
    }
    public void union(int[] parent, int a, int b){
        parent[a] = b;
    }
    public int find(int[] parent, int i){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }
}
