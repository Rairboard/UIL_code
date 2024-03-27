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

public class snowball {
    public static void main(String[] args) throws Exception {
        new snowball().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("snowball").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        List<Double> al = new ArrayList<>();
        while (times-- > 0) {
            double r = f.nextDouble() /2;
            al.add((4.0/3)* Math.PI * Math.pow(r,3));
        }
        Collections.sort(al);
        for (int i = 0; i < al.size(); i++) {
            out.printf("%.2f", al.get(i));
            if(i<al.size()-1){
                out.print(", ");
            }
        }
        f.close();
    }
}
