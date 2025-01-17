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

public class convoy {
    int[] weight;
    int minGroup;
    public static void main(String[] args) throws Exception {
        new convoy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("convoy").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            minGroup = Integer.MAX_VALUE;
            int v = f.nextInt();
            weight = new int[v];
            for (int i = 0; i < v; i++) {
                weight[i] = f.nextInt();
            }
            f.nextLine();
            HashSet<Integer> visited = new HashSet<>();
            recur(visited, 0, 0);
            out.println(minGroup);
        }
        f.close();
    }
    public void recur(HashSet<Integer> visited, int sum, int groupAllocated){
        if(visited.size() == weight.length){
            minGroup = Math.min(minGroup, groupAllocated+1);
        }
        else{
            for(int i = 0;i < weight.length;i++){
                if(visited.contains(i)) continue;
                visited.add(i);
                if(sum + weight[i] > 42){
                    recur(visited, weight[i], groupAllocated+1);
                }
                else{
                    recur(visited, sum+weight[i], groupAllocated);
                }
                visited.remove(i);
            }
        }
    }
}
