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

public class aviation {
    public static void main(String[] args) throws Exception {
        new aviation().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("aviation.in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n= f.nextInt();
            double m = f.nextDouble();
            double s = 0;
            f.nextLine();
            for (int i = 0; i < n; i++) {
                String[] l = f.nextLine().split("\\s+");
                int N = Integer.parseInt(l[l.length-1]);
                if(N>100){
                    s+=4.5;
                }
                else if(N>=90){
                    s+=3.0;
                }
                else if(N>=80){
                    s+=2.0;
                }
                else if(N>=70){
                    s+=1.0;
                }
                else if(N>=60){
                    s+=0.0;
                }
                else if(N>=50){
                    s-=.5;
                }
                else{
                    s-=2;
                }
            }
            String shiver = f.nextLine();
            out.println(shiver.equals("Shiver Approves") && s>=m?"Welcome to Naval Aviation":"Back to ship duty");
        }
        f.close();
    }
}
