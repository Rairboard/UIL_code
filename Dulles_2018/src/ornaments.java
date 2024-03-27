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

public class ornaments {
    public static void main(String[] args) throws Exception {
        new ornaments().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("ornaments.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while(times-->0){
            BigInteger sum = BigInteger.ZERO;
            BigInteger[] orn = new BigInteger[f.nextInt()+1];
            orn[0] = BigInteger.ZERO;
            for (int i = 1; i < orn.length; i++) {
                orn[i] = BigInteger.valueOf(i).add(orn[i-1]);
                sum = sum.add(orn[i]);
            }
            out.println(sum);
        }
        f.close();
    }
}
