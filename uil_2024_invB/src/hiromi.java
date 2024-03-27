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

public class hiromi {
    public static void main(String[] args) throws Exception {
        new hiromi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hiromi").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            out.print("Puzzle #"  + asdf + ": ");
            HashSet<Integer>[] hs = new HashSet[9];
            boolean flag = false;
            f.nextLine();
            int[][] m = new int[9][9];
            for (int i = 0; i < 9; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            for (int i = 0; i < 9; i++) {
                hs[i] = new HashSet<>();
            }
            for (int i = 0; i < 9; i++) {
                HashSet<Integer> row = new HashSet<>(), col = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    row.add(m[i][j]);
                    col.add(m[j][i]);
                }
                if(row.size()!=9 || col.size()!=9){
                    flag = true;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    hs[0].add(m[i][j]);
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 3; j < 6; j++) {
                    hs[1].add(m[i][j]);
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 6; j < 9; j++) {
                    hs[2].add(m[i][j]);
                }
            }
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    hs[3].add(m[i][j]);
                }
            }
            for (int i = 3; i < 6; i++) {
                for (int j = 3; j < 6; j++) {
                    hs[4].add(m[i][j]);
                }
            }
            for (int i = 3; i < 6; i++) {
                for (int j = 6; j < 9; j++) {
                    hs[5].add(m[i][j]);
                }
            }
            for (int i = 6; i < 9; i++) {
                for (int j = 0; j < 3; j++) {
                    hs[6].add(m[i][j]);
                }
            }
            for (int i = 6; i < 9; i++) {
                for (int j = 3; j < 6; j++) {
                    hs[7].add(m[i][j]);
                }
            }
            for (int i = 6; i < 9; i++) {
                for (int j = 6; j < 9; j++) {
                    hs[8].add(m[i][j]);
                }
            }
            for (int i = 0; i < hs.length; i++) {
                if (hs[i].size() != 9) {
                    flag = true;
                    break;
                }
            }
            out.println(flag?"false":"true");
        }
        f.close();
    }

}
