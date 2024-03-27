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

public class track {
    public static void main(String[] args) throws Exception {
        new track().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("track").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        Map<Integer,List<String>> m = new TreeMap<>();
        while(f.hasNext()) {
            String n = f.next();
            int sec = f.nextInt();
            out.print(n + " ");
            if(sec>17){
                out.println("Poor");
            }
            else if(sec > 15){
                out.println("Average");
            }
            else if(sec > 10){
                out.println("Above Average");
            }
            else{
                out.println("Excellent");
            }
            m.putIfAbsent(sec,new ArrayList<>());
            m.get(sec).add(n);
        }
        out.println();
        out.println("Top-Five");
        int cnt = 0;
        outer : for(Integer s : m.keySet()){
            for(String name : m.get(s)){
                if(cnt==5){
                    break outer;
                }
                out.println(name);
                cnt++;
            }
        }
        f.close();
    }
}
