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

public class timonthy {
    public static void main(String[] args) throws Exception {
        new timonthy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("timothy").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        Map<Integer,Integer> m = new TreeMap<>(Collections.reverseOrder());
        while(f.hasNext()){
            int N = f.nextInt();
            m.put(N,m.getOrDefault(N,0)+1);
        }
        for(Integer  i : m.keySet()){
            if(m.get(i)==1){
                out.println(i);
            }
            else{
                out.println(i + " " + (m.get(i)-1));
            }
        }
        f.close();
    }
}
