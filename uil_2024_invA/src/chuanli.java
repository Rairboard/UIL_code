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

public class chuanli {
    public static void main(String[] args) throws Exception {
        new chuanli().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("chuanli").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            List<String> al = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
            Collections.reverse(al);
            for (int i = 0; i < al.size(); i++) {
                out.print(new StringBuilder(al.get(i)).reverse() + " ");
            }
            out.println();
        }
        f.close();
    }
}
