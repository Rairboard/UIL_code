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

public class mia {
    public static void main(String[] args) throws Exception {
        new mia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mia").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            char[][] m= new char[n][n];
            for (int i = 0; i < n; i++) {
                m[i] = f.nextLine().trim().replaceAll("\\s+","").toCharArray();
            }
            if (identity(m)) {
                out.println("Matrix " + asdf + ": Identity Matrix - " + (swap(m) ? "Swaps needed":"No swaps needed"));
            }
            else{
                out.println("Matrix " + asdf + ": This is not an Identity Matrix");
            }
        }
        f.close();
    }
    public boolean identity (char[][] m){
        for (int i = 0; i < m.length; i++) {
            int col = 0, row = 0;
            for (int j = 0; j < m[i].length; j++) {
                if(m[j][i] == '1') col++;
                if(m[i][j]=='1') row++;
            }
            if(col>1 || row> 1) return false;
        }
        return true;
    }
    public boolean swap (char[][] m){
        String d1 = "", d2 = "";
        for (int i = 0; i < m.length; i++) {
            d1 += m[i][i];
        }
        if(d1.equals("1".repeat(m.length))) return false;
        return true;
    }
}
