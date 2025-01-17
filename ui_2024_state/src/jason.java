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

public class jason {
    public static void main(String[] args) throws Exception {
        new jason().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("jason").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int r1 = f.nextInt(), c1 = f.nextInt(), r2 = f.nextInt(), c2 = f.nextInt();
            f.nextLine();
            if(c1!=r2){
                for (int i = 0; i < r1; i++) {
                    f.nextLine();
                }
                for (int i = 0; i < r2; i++) {
                    f.nextLine();
                }
                out.println(asdf + ":MATRIX SIZES NOT COMPATIBLE");
            }
            else{
                int[][] a = new int[r1][c1];
                int[][] b = new int[r2][c2];
                int[][] c = new int[r1][c2];
                for (int i = 0; i < r1; i++) {
                    a[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                }
                for (int i = 0; i < r2; i++) {
                    b[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                }
                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c2; j++) {
                        for (int k = 0; k < r2; k++) {
                            c[i][j]+= a[i][k] * b[k][j];
                        }
                    }
                }
                out.println(asdf + ":" + r1 + "x" + c2);
                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c2; j++) {
                        out.printf("%7d", c[i][j]);
                    }
                    out.println();
                }
            }
            out.println("^".repeat(15));
        }
        f.close();
    }
}
