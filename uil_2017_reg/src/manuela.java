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

public class manuela {
    public static void main(String[] args) throws Exception {
        new manuela().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("manuela").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            Map<Integer,String> m = new TreeMap<>(Collections.reverseOrder());
            Map<String,Integer> coin = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String s = f.next();
                int val = f.nextInt();
                m.put(val,s);
            }
            int tgt = f.nextInt();
            for(Integer mon : m.keySet()){
                if(mon <= tgt){
                    coin.put(m.get(mon),tgt/mon);
                    tgt%=mon;
                }
            }
            for(String ss : coin.keySet()){
                out.print(ss + ": " + coin.get(ss)+" ");
            }
            out.println();
        }
        f.close();
    }
}
