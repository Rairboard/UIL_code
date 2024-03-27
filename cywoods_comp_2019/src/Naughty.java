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

public class Naughty {
    public static void main(String[] args) throws Exception {
        new Naughty().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Naughty").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n = f.nextInt();
            boolean yes = false;
            f.nextLine();
            Map<Double,List<String>> m = new TreeMap<>(Collections.reverseOrder());
            String ans = f.nextLine();
            for (int i = 0; i < n-1; i++) {
                String ln  = f.nextLine();
                double r = 0;
                for (int j = 0; j < ln.length(); j++) {
                    if(ln.charAt(j)==ans.charAt(j)){
                        r++;
                    }
                }
                r/=ln.length();
                r*=100;
                m.putIfAbsent(r,new ArrayList<>());
                m.get(r).add(ln);
                if(r > 0){
                    yes = true;
                }
            }
            if(!yes){
                out.println("FAILED\nAccuracy Pecentage: NaN");
            }else{
                for(Double p : m.keySet()){
                    for(String s : m.get(p)){
                        out.println(s);
                        break;
                    }
                    out.println("Accuracy Percentage: " + Math.round(p) + "%");
                    break;
                }
            }
            out.println();
        }
        f.close();
    }
}
