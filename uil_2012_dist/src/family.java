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

public class family {
    char[][]m;
    public static void main(String[] args) throws Exception {
        new family().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("family").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            m = new char[18][12];
            for (int i = 0; i < m.length; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            f.nextLine();
            for (int i = 0; i < m[0].length; i++) {
                for(int j = m.length-1;j>-1;j--){
                    out.print(m[j][i]);
                }
                out.println();
            }
            out.println();
        }
        f.close();
    }
}
