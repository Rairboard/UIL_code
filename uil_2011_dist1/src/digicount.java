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

public class digicount {
    public static void main(String[] args) throws Exception {
        new digicount().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("digicount").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int n = f.nextInt();
            int[] cnt = new int[10];
            for(int i = 1;i<= n;i++){
                String ln = i+"";
                for (int j = 0; j < ln.length(); j++) {
                    int index = Integer.parseInt(ln.substring(j,j+1));
                    cnt[index]++;
                }
            }
            for(int i : cnt){
                out.print(i + " ");
            }
            out.println();
        }
        f.close();
    }
}
