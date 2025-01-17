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

public class password {
    public static void main(String[] args) throws Exception {
        new password().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("password").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.next();
            int k = f.nextInt();
            if(f.hasNext()) f.nextLine();
            Map<String,Integer> m = new HashMap<>();
            for (int i = 0; i < ln.length() - k + 1; i++) {
                String w = ln.substring(i, i + k);
                m.put(w, m.getOrDefault(w, 0) + 1);
            }
            int max = 0;
            String best = "";
            for(String s : m.keySet()){
                if(m.get(s) > max){
                    max = m.get(s);
                    best = s;
                }
            }
            out.println(best);
        }
        f.close();
    }
}
