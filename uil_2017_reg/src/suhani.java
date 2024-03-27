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

public class suhani {
    public static void main(String[] args) throws Exception {
        new suhani().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("suhani").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            List<Double> one = new ArrayList<>();
            List<Double> two = new ArrayList<>();
            int a = 0, b = 0;
            for (int i = 0; i < 3; i++) {
                one.add(f.nextDouble());
            }
            for (int i = 0; i < 3; i++) {
                two.add(f.nextDouble());
            }
            for (int i = 0; i < one.size(); i++) {
                if (two.contains(one.get(i))) {
                    a++;
                }
                if (one.contains(two.get(i))) {
                    b++;
                }
            }
            out.println(Math.min(a,b));
        }
        f.close();
    }
}
