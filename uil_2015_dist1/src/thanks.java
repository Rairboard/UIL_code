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

public class thanks {
    public static void main(String[] args) throws Exception {
        new thanks().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("thanks").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int c = f.nextInt(), n =f.nextInt();
            f.nextLine();
            int[] count = new int[3];
            for (int i = 0; i < c; i++) {
                count[0] +=f.nextInt();
                count[1] += f.nextInt();
                count[2]+=f.nextInt();
            }
            int[][] m = new int[n][4];
            int N = f.nextInt();
            f.nextLine();
            for (int i = 0; i < N; i++) {
                char name = f.next().charAt(0);
                int a = f.nextInt(), b = f.nextInt(), c = f.nextInt();
                if()
            }
        }
        f.close();
    }
}
