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

public class perfect {
    public static void main(String[] args) throws Exception {
        new perfect().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("perfect").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            long n = f.nextLong();
            long sum = 0;
            for (int i = 1; i < n; i++) {
                if(n%i==0){
                    sum+=i;
                }
            }
            n-=sum;
            if(n==0){
                out.println("PERFECT");
            }
            else if(n<0){
                out.println("ABUNDANT");
            }
            else{
                out.println("DEFICIENT");
            }
        }
        f.close();
    }
}
