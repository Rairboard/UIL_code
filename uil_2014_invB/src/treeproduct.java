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

public class treeproduct {
    public static void main(String[] args) throws Exception {
        new treeproduct().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("treeproduct").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            long[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            out.println(recur(ar,0));
        }
        f.close();
    }
    public long recur(long[] ar, int i){
        if(i * 2 + 1 >= ar.length && i * 2 + 2 >= ar.length){
            return ar[i];
        }
        return Math.max(ar[i] * recur(ar, i*2+1) , ar[i] * recur(ar,i*2+2));
    }
}
