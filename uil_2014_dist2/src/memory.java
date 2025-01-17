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

public class memory {
    public static void main(String[] args) throws Exception {
        new memory().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("memory").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Map<Integer,Integer> val = new HashMap<>();
            Map<String,int[]> m =new HashMap<>();
            int M = f.nextInt(), K = f.nextInt();
            f.nextLine();
            for (int i = 0; i < M; i++){
                String s = f.next();
                int address = f.nextInt();
                int value = f.nextInt();
                f.nextLine();
                m.put(s,new int[]{address,value});
                val.put(address,value);
            }
            for (int i = 0; i < K; i++) {
                String ln = f.nextLine();
                if(ln.charAt(0)=='&'){
                    out.println(m.get(ln.substring(1))[0]);
                }
                else if(ln.charAt(0)=='*'){
                    out.println(val.get(m.get(ln.substring(1))[1]));
                }
                else{
                    out.println(m.get(ln)[1]);
                }
            }
        }
        f.close();
    }
}
