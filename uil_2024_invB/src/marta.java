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

public class marta {
    public static void main(String[] args) throws Exception {
        new marta().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("marta").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        o: for (int asdf = 1; asdf <= times; asdf++) {
            out.print("Test case " + asdf + " pass ");
            int n = f.nextInt(), pass = f.nextInt();
            f.nextLine();
            int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] sorted = new int[n];
            for (int i = 0; i < ar.length; i++) {
                sorted[i] = ar[i];
            }
            Arrays.sort(sorted);
            int cnt = 0;
            while(!SORT(ar,sorted)){
                cnt++;
                for (int i = 0; i < ar.length - 1; i++) {
                    if(ar[i] > ar[i+1]){
                        int tmp = ar[i];
                        ar[i] = ar[i+1];
                        ar[i+1] = tmp;
                    }
                }
                if(cnt==pass){
                    break;
                }
            }
            if(cnt!=pass){
                cnt++;
            }
            out.print(cnt+": ");
            for(Integer ii : ar){
                out.print(ii+" ");
            }
            out.println();
        }
        f.close();
    }
    public boolean SORT(int[] a, int[] b){
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
}
