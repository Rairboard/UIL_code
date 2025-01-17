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

public class grades {
    public static void main(String[] args) throws Exception {
        new grades().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("grades").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            String name = f.next();
            f.nextLine();
            out.println(name);
            int A =0,B = 0, C =0, D = 0, F = 0;
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().split("\\s+");
                int g = Integer.parseInt(ln[1]);
                if(g>=90){
                    A++;
                }
                else if(g>=80){
                    B++;
                }
                else if(g>=75){
                    C++;
                }
                else if(g>=70){
                    D++;
                }
                else{
                    F++;
                }
            }
            out.println("A " + A);
            out.println("B " + B);
            out.println("C " + C);
            out.println("D " + D);
            out.println("F " + F);
        }
        f.close();
    }
}
