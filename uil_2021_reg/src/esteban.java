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

public class esteban {
    public static void main(String[] args) throws Exception {
        new esteban().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("esteban").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            char ch = f.next().charAt(0);
            double t = f.nextDouble() , h = f.nextDouble();
            if(ch=='C'){
                t = (9/5.0 * t) + 32;
            }
            h/=100;
            double HI = (-42.379) + (2.04901523 * t) + (10.14333127 * h) - (0.22475541 * t * h) - (6.83783 * Math.pow(10,-3) * Math.pow(t,2)) - (5.481717 * Math.pow(10,-2)  * Math.pow(h,2)) + (1.22874 * Math.pow(10,-3) * Math.pow(t,2) * h) + ( 8.5282 * Math.pow(10,-4) * t * Math.pow(h,2)) - (1.99 * Math.pow(10,-6) * Math.pow(t,2) * Math.pow(h,2));
            if(t < 80){
                if(h< .13){
                    HI-=((13-h)/4.0) * Math.sqrt((17 - Math.abs(t-95.0)) / 17);
                }
                else if(h > .85){
                    HI+= ((h-85)/10)  * ((87-t) / 5);
                }
            }
            if (HI > 140 || (HI < t && h >= .40)) {
                out.printf("#%d:%.1f%c INVALID\n",asdf,HI,ch);
            }
            else{
                out.printf("#%d:%.1f%c\n",asdf,HI,ch);
            }
        }
        f.close();
    }
}
