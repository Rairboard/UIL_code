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

public class dog {
    public static void main(String[] args) throws Exception {
        new dog().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dog").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            char[][] m = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(m[i],'@');
            }
            for(int i = 1;i< n-1;i++){
                for(int j = 1;j<n-1;j++){
                    m[i][j]  =' ';
                }
            }
            for(char[] line : m){
                out.println(line);
            }
            out.println();
        }
        f.close();
    }
}
