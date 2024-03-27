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

public class shroud {
    public static void main(String[] args) throws Exception {
        new shroud().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("shroud").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        Map<String,int[]> m = new LinkedHashMap<>();
        while (f.hasNext()) {
            String s = f.next(), gb = f.next();
            m.putIfAbsent(s,new int[]{0,0});
            if (gb.equals("good")) {
                m.get(s)[0]++;
            }else{
                m.get(s)[1]++;
            }
        }
        for(String p : m.keySet()){
            if (m.get(p)[1] >= m.get(p)[0]) {
                out.println(p + " is naughty " + Math.abs(m.get(p)[0] - m.get(p)[1]));
            }else{
                out.println(p + " is nice " + Math.abs(m.get(p)[0] - m.get(p)[1]) );
            }
        }
        f.close();
    }
}
