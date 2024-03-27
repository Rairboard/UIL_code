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

public class binary {
    char[][] m;
    public static void main(String[] args) throws Exception {
        new binary().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("binary").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            m = new char[4][6];
            for (int i = 0; i < m.length; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            String ln = "";
            for (int i = 0; i < m[0].length; i++) {
                String col = "";
                for (int j = 0; j < m.length; j++) {
                    if(m[j][i] == '*'){
                        col+="1";
                    }else{
                        col+="0";
                    }
                }
                ln+=Integer.parseInt(col,2);
            }
            out.println(ln.substring(0,2) + ":" + ln.substring(2,4) + ":" + ln.substring(4));
        }
        f.close();
    }
}
