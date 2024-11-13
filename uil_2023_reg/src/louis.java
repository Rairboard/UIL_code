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

public class louis {
    public static void main(String[] args) throws Exception {
        new louis().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("louis").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double a = f.nextDouble(), b = f.nextDouble(), c = f.nextDouble();
            if(a==0){
                out.println("Function is not quadratic");
            }
            else{
                double discriminant = Math.pow(b,2) - 4 * a * c;
                double x = (-b)/(2*a);
                double y = a * Math.pow(x,2) + b * x + c;
                double root1,root2;
                if(discriminant<0){
                    out.printf("Function has no roots with " + (a < 0 ? "max":"min") + " of %.3f at %.3f\n" , y ,x);
                }
                else if(discriminant==0){
                    root1 = ((-b) + Math.sqrt(discriminant))/(2*a);
                    out.printf("Function has 1 root at %.3f with " + (a < 0 ? "max":"min") + " of %.3f at %.3f\n" ,root1,  y ,x);
                }
                else{
                    root1 = ((-b) + Math.sqrt(discriminant))/(2*a);
                    root2 = ((-b) - Math.sqrt(discriminant))/(2*a);
                    double lower = Math.min(root1, root2);
                    double higher = Math.max(root1,root2);
                    out.printf("Function has 2 roots at %.3f and %.3f with " + (a < 0 ? "max":"min") + " of %.3f at %.3f\n",lower, higher, y, x);
                }
            }
        }
        f.close();
    }
}
