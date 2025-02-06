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

public class bethany {
    public static void main(String[] args) throws Exception {
        new bethany().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bethany").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int N = f.nextInt(), F = f.nextInt();
            int num = 1;
            int cnt = 0;
            while(cnt < N){
                int factorCount = 0;
                for(int i = 1;i<=num;i++){
                    if(num%i==0){
                        factorCount++;
                    }
                }
                if(factorCount==F){
                    cnt++;
                    out.print(num+" ");
                }
                num++;
            }
            out.println();
        }
        f.close();
    }
}
