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

public class postoffice {
    public static void main(String[] args) throws Exception {
        new postoffice().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("postoffice").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            double sum = 0;
            for (int i = 0; i < ar.length; i++) {
                sum+=ar[i];
            }
            sum+= 0.4;
            if(sum>=5){
                out.println("OVERWEIGHT");
            }
            else{
                out.println("OK");
            }
        }
        f.close();
    }
}
