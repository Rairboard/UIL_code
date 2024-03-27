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

public class kenneth {
    public static void main(String[] args) throws Exception {
        new kenneth().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("kenneth").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int[][] m = new int[9][9];
            Set<Integer> row = new TreeSet<>(), col =new TreeSet<>();
            for (int i = 0; i < 9; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            for (int i = 0; i < 9; i++) {
                Set<Integer> a = new HashSet<>(),b = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    a.add(m[i][j]);
                    b.add(m[j][i]);
                }
                if(a.size()!=9){
                    row.add(i);
                }
                if(b.size()!=9){
                    col.add(i);
                }
            }
            out.print("GRID #" + asdf +": ");
            if(row.isEmpty() && col.isEmpty()){
                out.println("SOLUTION IS CORRECT");
            }
            else{
                out.println("NOT A SOLUTION");
                out.print(">> ROWS WITH ERRORS: ");
                if(row.isEmpty()){
                    out.println("NONE");
                }
                else{
                    for(Integer i : row){
                        out.print(i+1+" ");
                    }
                    out.println();
                }
                out.print(">> COLUMNS WITH ERRORS: ");
                if(col.isEmpty()){
                    out.println("NONE");
                }
                else{
                    for(Integer i : col){
                        out.print(i+1+" ");
                    }
                    out.println();
                }
            }
            out.println("=".repeat(12));
        }
        f.close();
    }
}
