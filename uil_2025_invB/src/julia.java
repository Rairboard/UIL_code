import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class julia {
    public static void main(String[] args) throws Exception {
        new julia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("julia").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        boolean[] prime =new boolean[(int)Math.pow(10,7)+1];
        Arrays.fill(prime, true);
        for(int i = 2;i*i<=Math.pow(10,7);i++){
            if(prime[i]){
                for(int p = i * i;p <= Math.pow(10,7);p+=i){
                    prime[p] = false;
                }
            }
        }
        int[] countPrime = new int[(int)1e7 + 1];
        int count = 0;
        for(int i = 2;i<=1e7;i++){
            if(prime[i]) count++;
            countPrime[i] = count;
        }
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int v = f.nextInt();

            out.println(countPrime[v]);
        }
        f.close();
    }
}
