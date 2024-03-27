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

public class katya {
    long[][] a,b,c;
    public static void main(String[] args) throws Exception {
        new katya().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("katya").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int ar = f.nextInt(), ac = f.nextInt(), br = f.nextInt(), bc = f.nextInt();
            f.nextLine();
            a = new long[ar][ac];
            b = new long[br][bc];
            c = new long[ar][bc];
            for (int i = 0; i < ar; i++) {
                a[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            }
            for (int i = 0; i < br; i++) {
                b[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            }
            if(ac==br){
                for (int i = 0; i < ar; i++) {
                    for (int j = 0; j < bc; j++) {
                        for (int k = 0; k < br; k++) {
                            c[i][j]+= a[i][k] * b[k][j];
                        }
                    }
                }
                out.println(asdf+":" + ar + "," + bc);
                for (int i = 0; i < c.length; i++) {
                    for (int j = 0; j < c[i].length; j++) {
                        out.printf("%5d",c[i][j]);
                    }
                    out.println();
                }
            }
            else{
                out.println(asdf +":SIZES NOT COMPATIBLE");
            }
            out.println("^".repeat(12));
        }
        f.close();
    }
}
