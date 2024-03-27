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

public class sergey {
    public static void main(String[] args) throws Exception {
        new sergey().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sergey").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int N = f.nextInt(), d = f.nextInt();
            f.nextLine();
            char[][] m = new char[N][N];
            for (int i = 0; i < N; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            for (int t = 0; t < d/90; t++) {
                char[][] copy = new char[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        copy[j][N-i-1] = m[i][j];
                    }
                }
                for (int i = 0; i < N; i++) {
                    m[i] = new String(copy[i]).toCharArray();
                }
            }
            for(char[] cc : m){
                out.println(cc);
            }
            out.println("DONE");
        }
        f.close();
    }
}
