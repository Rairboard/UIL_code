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

public class I {
    public static void main(String[] args) throws Exception {
        new I().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("I").toLowerCase() + ".txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int N =f.nextInt();
            f.nextLine();
            String ln = f.nextLine();
            String[] seq = "TTT, TTH, THT, THH, HTT,HTH, HHT, HHH".replaceAll(" ","").split(",");
            int[] cnt = new int[seq.length];
            for (int x = 0; x < seq.length; x++) {
                for (int i = 0; i < ln.length() - 2; i++) {
                    if (ln.substring(i, i + 3).equals(seq[x])) {
                        cnt[x]++;
                    }
                }
            }
            out.print(N +" ");
            for (int i = 0; i < cnt.length; i++) {
                out.print(cnt[i]+" ");
            }
            out.println();
        }
        f.close();
    }
}
