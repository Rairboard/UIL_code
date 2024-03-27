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

public class prateek {
    public static void main(String[] args) throws Exception {
        new prateek().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("prateek").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Map<Integer,List<Integer>> m = new TreeMap<>();
            int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < ar.length; i++) {
                int count = bs(ar,ar[i]);
                m.putIfAbsent(count,new ArrayList<>());
                m.get(count).add(ar[i]);
            }
            out.print("List: ");
            for (int i = 0; i < ar.length; i++) {
                out.print(ar[i]+" ");
            }
            out.println();
            for(Map.Entry<Integer, List<Integer>> entry : m.entrySet()){
                List<Integer> val = entry.getValue();
                Collections.sort(val);
                out.print(entry.getKey() + "-iterations: ");
                for (int i = 0; i < val.size(); i++) {
                    out.print(val.get(i)+" ");
                }
                out.println();
            }
            out.println();
        }
        f.close();
    }
    public int bs(int[] ar,int target){
        int l = 0, r = ar.length-1, m = (l+r)/2;
        int cnt = 0;
        while(l<=r){
            cnt++;
            if(ar[m]==target){
                return cnt;
            } else if (ar[m] > target){
                r = m-1;
            }
            else{
                l = m+1;
            }
            m = (l+r)/2;
        }
        return cnt;
    }
}
