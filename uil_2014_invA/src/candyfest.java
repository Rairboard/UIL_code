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

public class candyfest {
    public static void main(String[] args) throws Exception {
        new candyfest().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("candyfest").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), best = 100;
            f.nextLine();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = f.nextInt();
                best = Math.min(best,ar[i]);
            }
            outer : for(int k = 1;k<=100;k++){
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if(ar[i] > k){
                        sum+=ar[i] - k;
                    }
                    else{
                        sum-= k -ar[i];
                    }
                    if(sum < 0){
                        break outer;
                    }
                }
                best = Math.max(best, k);
            }
            out.println(best);
        }
        f.close();
    }
}
