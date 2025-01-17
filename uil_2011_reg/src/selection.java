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

public class selection {
    public static void main(String[] args) throws Exception {
        new selection().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("selection").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for(int i =0 ;i < ar.length-1;i++){
                int min = i;
                for(int j = i+1;j<ar.length;j++){
                    if(ar[j] < ar[min]){
                        min = j;
                    }
                }
                int a = ar[i];
                ar[i] = ar[min];
                ar[min] = a;
                for(int j : ar){
                    out.print(j+" ");
                }
                out.println();
            }
            out.println();
        }
        f.close();
    }
    public boolean sorted(int[] ar, int[] sorted){
        for(int i = 0;i < ar.length;i++){
            if(ar[i] !=sorted[i]){
                return false;
            }
        }
        return true;
    }
}
