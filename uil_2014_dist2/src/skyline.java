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

public class skyline {
    public static void main(String[] args) throws Exception {
        new skyline().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("skyline").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            int[] left = new int[n];
            int[] right = new int[n];
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = f.nextInt();
            }
            left[0] = ar[0];
            right[n-1] = ar[n-1];
            for(int i = 1;i < n;i++){
                left[i] = Math.max(left[i-1], ar[i]);
            }
            for(int i = n-2;i>-1;i--){
                right[i] = Math.max(right[i+1],ar[i]);
            }
            int total = 0;
            int s = 0, e = n-1;
            while(s + 1 < n && ar[s] < ar[s+1]) s++;
            while(e - 1 > -1 && ar[e] < ar[e-1]) e--;
            for(int i = s;i <= e;i++){
                total += Math.min(left[i], right[i]) - ar[i];
            }
            out.println(total);
        }
        f.close();
    }
}
