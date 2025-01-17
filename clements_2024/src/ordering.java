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

public class ordering {
    public static void main(String[] args) throws Exception {
        new ordering().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ordering").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split("\\s+");
            int cnt = 0;
            for (int i = 0; i < ln.length; i++) {
                int min = i;
                boolean swap = false;
                for (int j = i+1; j < ln.length; j++) {
                    if(ln[j].compareTo(ln[min]) < 0){
                        swap = true;
                        min = j;
                    }
                }
                if (swap) {
                    String tmp = ln[min];
                    ln[min] = ln[i];
                    ln[i] = tmp;
                    cnt++;
                }
            }
            out.println(cnt);
        }
        f.close();
    }
}
