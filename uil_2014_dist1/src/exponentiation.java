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

public class exponentiation {
    public static void main(String[] args) throws Exception {
        new exponentiation().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("exponentiation").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double a = f.nextDouble() ,b = f.nextDouble();
            int m = f.nextInt();
            double[] res = new double[2];
            for (int i = 0; i < m-1; i++) {
                //(a,b) * (a,b) = (a*a-b*b, a*b+b*a);
                if(i==0){
                    res = new double[]{a*a - b*b, a*b+b*a};
                }
                else{
                    res = new double[]{a*res[0]-b*res[1], a*res[1]+b*res[0]};
                }
            }
            out.printf("(%f,%f)\n", res[0],res[1]);
        }
        f.close();
    }
}
