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

public class mateo {
    public static void main(String[] args) throws Exception {
        new mateo().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mateo").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            double x1 = f.nextDouble(), x2 = f.nextDouble();
            double ans1 = calculate(x1), ans2 = calculate(x2);
            if (Math.signum(ans1) == Math.signum(ans2)) {
                out.println("UNKNOWN");
            }
            else{
                double low = Math.min(x1, x2);
                double high = Math.max(x1, x2);
                while(low < high){
                    double mid = (low+high)/2;
                    double ans = calculate(mid);
                    if (ans == 0) {
                        out.printf("%.7f\n" ,mid);
                        break;
                    }
                    else if(Math.signum(calculate(low)) == Math.signum(ans)){
                       low = mid;
                    }
                    else if(Math.signum(calculate(high)) == Math.signum(ans)){
                        high = mid;
                    }
                }
                if(low==high){
                    if(calculate(low)==0) out.printf("%.7f\n", low);
                }
                else out.println("UNKNOWN");
            }
        }
        f.close();
    }
    public double calculate(double x){
        return 1.3 * Math.pow(x, 4 ) - 35.1 * Math.pow(x,2)- 18.2 * x + 89.7;
    }
}
